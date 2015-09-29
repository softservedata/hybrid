package com.softserve.edu.atqc.tools.loggers;

import org.testng.Reporter;

public class ReporterWrapper implements ILogger {
    
    private static enum ReporterTags {
        BR_ERROR("<br>[ERROR] "),
        BR_WARNING("<br>[WARNING] "),
        BR_INFO("<br>[INFO] "),
        BR_DIV_IMG("<br><div><image style=\"max-width:100%%\" src=\"%s\"/></div>"),
        BR_DIV_IMG50("<br><div><image width=\"50%%\" src=\"%s\"/></div>");
        private String field;

        private ReporterTags(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
    
    private static enum ReporterLevels {
        SCREENSHOT_LEVEL(2),
        ERROR_LEVEL(3),
        WARNING_LEVEL(5),
        INFO_LEVEL(7);
        private int level;

        private ReporterLevels(int level) {
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }
    }

    private static volatile ReporterWrapper instance = null;
    private final String SLASH = "/";
    private boolean consoleOutput;

    private ReporterWrapper(boolean consoleOutput) {
        this.consoleOutput = consoleOutput;
    }

    public static ReporterWrapper get() {
        return get(true);
    }

    public static ReporterWrapper get(boolean consoleOutput) {
        if (instance == null) {
            synchronized (ReporterWrapper.class) {
                if (instance == null) {
                    instance = new ReporterWrapper(consoleOutput);
                }
            }
        }
        return instance;
    }
    
    public void error(String message){
        Reporter.log(ReporterTags.BR_ERROR.toString() + message,
                ReporterLevels.ERROR_LEVEL.getLevel(), consoleOutput);
    }

    public void warning(String message){
        Reporter.log(ReporterTags.BR_WARNING.toString() + message,
        ReporterLevels.WARNING_LEVEL.getLevel(), consoleOutput);
    }

    public void info(String message){
        Reporter.log(ReporterTags.BR_INFO.toString() + message,
                ReporterLevels.INFO_LEVEL.getLevel(), consoleOutput);
    }

    public void insertScreenShot(String fileNamePath){
        Reporter.log(String.format(ReporterTags.BR_DIV_IMG.toString(),
                fileNamePath.substring(fileNamePath.lastIndexOf(SLASH) + 1)),
                ReporterLevels.SCREENSHOT_LEVEL.getLevel(), false);
    }

}
