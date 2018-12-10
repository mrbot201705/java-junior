package com.acme.edu;

public class IntState implements LoggerState {
    private Integer buffer = null;
    private Printer printer;

    public IntState(Printer printerType) {
        this.printer = printerType;
    }

    @Override
    public void log(int message) {
        long intSumTemp = 0;
        if(buffer != null) {
            intSumTemp = buffer;
        }
        if (checkIntOverflow(message, intSumTemp)) {
            checkNullValueAndPrintIntSumIfNotNull();
            printer.print("primitive: " + message);
        } else {
            if(buffer == null) {
                buffer = 0;
            }
            buffer += message;
        }
    }

    @Override
    public void log(String message) {
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }

    @Override
    public void close() {
        checkNullValueAndPrintIntSumIfNotNull();
    }

    private boolean checkIntOverflow(int message, long temporaryVariableForIntSum) {
        return (temporaryVariableForIntSum + message) > Integer.MAX_VALUE;
    }
    private void checkNullValueAndPrintIntSumIfNotNull() {
        if(buffer != null) {
            printer.print("primitive: " + buffer);
            buffer = null;
        }
    }
}
