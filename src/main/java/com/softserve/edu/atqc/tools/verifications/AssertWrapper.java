package com.softserve.edu.atqc.tools.verifications;

import org.testng.Assert;

import com.softserve.edu.atqc.tools.browsers.CaptureScreenImage;
import com.softserve.edu.atqc.tools.controls.ILabel;
import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.ITextField;
import com.softserve.edu.atqc.tools.loggers.LoggerUtils;

public class AssertWrapper {
    private final String NEW_LINE = "\n";
    private final String APPEND_TEXT = "%sDescription: %s";
    private final String SCREEN_IMAGE_PATH = "Screen image is located by the next path %s";
    //
    private boolean summaryResult;
    private StringBuffer summaryDescription;
    private static volatile AssertWrapper instance = null;

    private AssertWrapper() {
        this.summaryResult = true;
        this.summaryDescription = new StringBuffer();
    }

    public static AssertWrapper get() {
        if (instance == null) {
            synchronized (AssertWrapper.class) {
                if (instance == null) {
                    instance = new AssertWrapper();
                }
            }
        }
        return instance;
    }

    // getters

    public boolean getPassed() {
        return summaryResult;
    }

    public String getSummaryDescription() {
        return summaryDescription.toString();
    }

    // business

    public void verify(boolean pass, String errorText) {
        summaryResult = summaryResult && pass;
        if (!pass) {
            summaryDescription.append(String.format(APPEND_TEXT, NEW_LINE, errorText));
            LoggerUtils.get().errorLog(errorText);
            String fileNamePath = CaptureScreenImage.get().captureAndSaveScreen();
            LoggerUtils.get().errorLog(String.format(SCREEN_IMAGE_PATH, fileNamePath));
            LoggerUtils.get().insertScreenShot(fileNamePath);
        }
    }

    public void addWarning(String warningText) {
        summaryDescription.append(String.format(APPEND_TEXT, NEW_LINE, warningText));
    }

    public void check() {
        boolean result = getPassed();
        String description = getSummaryDescription();
        this.summaryResult = true;
        this.summaryDescription = new StringBuffer();
        Assert.assertTrue(result, description);
    }

    public TextCriteria forElement(String text) {
        return TextCriteria.get(text);
    }

    // public ComponentCriteria forElement(IComponent component) {
    // return ComponentCriteria.get(component);
    // }

    public ILabelCriteria forElement(ILabel label) {
        return LabelCriteria.get(label);
    }

    public ILinkCriteria forElement(ILink link) {
        return LinkCriteria.get(link);
    }

    // public ButtonCriteria forElement(IButton button) {
    // return ButtonCriteria.get(button);
    // }

    public ITextFieldCriteria forElement(ITextField textField) {
        return TextFieldCriteria.get(textField);
    }

}
