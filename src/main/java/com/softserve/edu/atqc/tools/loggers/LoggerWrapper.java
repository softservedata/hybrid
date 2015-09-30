package com.softserve.edu.atqc.tools.loggers;

public class LoggerWrapper {
    private static volatile LoggerWrapper instance = null;
    private ILogger logger;

    private LoggerWrapper() {
        // Set Strategy by Default.
        this.logger = LoggerRepository.getReporterLogger();
    }

    public static LoggerWrapper get() {
        if (instance == null) {
            synchronized (LoggerWrapper.class) {
                if (instance == null) {
                    instance = new LoggerWrapper();
                }
            }
        }
        return instance;
    }

    // Set Strategy.
    public LoggerWrapper setLogger(ILogger logger) {
        synchronized (LoggerWrapper.class) {
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
