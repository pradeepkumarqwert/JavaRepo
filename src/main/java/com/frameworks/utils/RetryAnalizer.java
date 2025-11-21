package com.frameworks.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) {
            count++;
            return true;
        }
        return false;
    }
}