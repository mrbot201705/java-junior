package com.acme.edu;

public class LoggerOOP {
    private LoggerState intState;
    private LoggerState stringState;
    private LoggerState otherState;
    private LoggerState previousState;

    public LoggerOOP(Printer printerType) {
        this.intState = new IntState(printerType);
        this.stringState = new StringState(printerType);
        this.otherState = new OtherState(printerType);
    }

    public void log(int message) {
        checkPreviousStateOnNullAndCompareStateWithIntState();
        intState.log(message);
        previousState = intState;
    }

    public void log(int... messages) {
        checkPreviousStateOnNullAndCompareStateWithIntState();
        for(int message : messages) {
            log(message);
        }
        previousState = intState;
    }

    public void log(int[][] matrix) {
        checkPreviousStateOnNullAndCompareStateWithIntState();
        for (int[] array : matrix) {
            log(array);
        }
        previousState = intState;
    }

    public void log(String message) {
        checkPreviousStateOnNullAndCompareStateWithStringState();
        stringState.log(message);
        previousState = stringState;
    }

    public void log(String... messages) {
        checkPreviousStateOnNullAndCompareStateWithStringState();
        for(String message : messages) {
            log(message);
        }
        previousState = stringState;
    }

    public void log(char message) {
        otherState.log("char: " + message);
        previousState = otherState;
    }

    public void log(boolean message) {
        otherState.log("primitive: " + message);
        previousState = otherState;
    }

    public void close() {
        previousState.close();
    }

    private void checkPreviousStateOnNullAndCompareStateWithIntState() {
        if(previousState != null && previousState != intState) {
            previousState.close();
        }
    }

    private void checkPreviousStateOnNullAndCompareStateWithStringState() {
        if(previousState != null && previousState != stringState) {
            previousState.close();
        }
    }
}
