package com.softserve.edu.atqc.tools.loggers;

public class LoggerUtils {
    private static volatile LoggerUtils instance = null;
    private ILogger logger;

    private LoggerUtils() {
        // Set Strategy by Default.
        this.logger = LoggerRepository.getReporterLogger();
    }

    public static LoggerUtils get() {
        if (instance == null) {
            synchronized (LoggerUtils.class) {
                if (instance == null) {
                    instance = new LoggerUtils();
                }
            }
        }
        return instance;
    }

    // Set Strategy.
    public LoggerUtils setLogger(ILogger logger) {
        synchronized (LoggerUtils.class) {
            this.logger = logger;
        }
        return this;
    }

    public void errorLog(String message) {
        // TODO getClass, getMethod
        this.logger.error(message);
    }

    public void warningLog(String message) {
        // TODO getClass, getMethod
        this.logger.warning(message);
    }

    public void infoLog(String message) {
        // TODO getClass, getMethod
        this.logger.info(message);
    }

    public void insertScreenShot(String fileNamePath) {
        this.logger.insertScreenShot(fileNamePath);
    }

}
