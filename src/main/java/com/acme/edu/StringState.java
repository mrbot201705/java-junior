package com.acme.edu;

public class StringState implements LoggerState {
    private String buffer;
    private int stringCounter;
    private Printer printer;

    public StringState(Printer printerType) {
        this.printer = printerType;
    }

    @Override
    public void log(int message) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public void log(String message) {
        if (buffer != null && buffer.equals(message)) {
            stringCounter++;
        } else {
            checkStringCounterAndPrintStringsIfNotZero();
            buffer = message;
            stringCounter = 1;
        }
    }

    @Override
    public void close() {
        checkStringCounterAndPrintStringsIfNotZero();
    }

    private void checkStringCounterAndPrintStringsIfNotZero() {
        if(stringCounter == 0) {
            return;
        }
        if (stringCounter == 1) {
            printer.print("string: " + buffer);
        } else {
            printer.print("string: " + buffer + " (x" + stringCounter + ")");
        }
        stringCounter = 0;
    }
}
