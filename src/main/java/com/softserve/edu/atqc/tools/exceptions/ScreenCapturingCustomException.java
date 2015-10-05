package com.softserve.edu.atqc.tools.exceptions;

import com.softserve.edu.atqc.tools.browsers.CaptureScreenImage;
import com.softserve.edu.atqc.tools.loggers.LoggerUtils;

public class ScreenCapturingCustomException extends GeneralCustomException {
    private static final long serialVersionUID = 1L;
    private static final String SCREENSHOT_FILENAME = "Screenshot filename is ";

    // Classic constructor with a message of error.
    public ScreenCapturingCustomException(String message) {
        super(message);
        takeScreenshot();
    }

    public ScreenCapturingCustomException(String message, Throwable e) {
        super(message, e);
        takeScreenshot();
    }

    private void takeScreenshot() {
        String fileNamePath = CaptureScreenImage.get().captureAndSaveScreen();
        LoggerUtils.get().errorLog(SCREENSHOT_FILENAME + fileNamePath);
        LoggerUtils.get().insertScreenShot(fileNamePath);
    }

}
