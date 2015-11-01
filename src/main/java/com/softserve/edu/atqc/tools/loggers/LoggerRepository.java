package com.softserve.edu.atqc.tools.loggers;

public final class LoggerRepository {

    private LoggerRepository() {
    }

    public static ILogger getLog4jLogger() {
        return Log4jWrapper.get();
    }

    public static ILogger getReporterLogger() {
        return ReporterWrapper.get();
    }

    public static ILogger getReporterLoggerWithoutConsole() {
        return ReporterWrapper.get(false);
    }

}
