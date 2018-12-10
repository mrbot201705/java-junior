package com.acme.edu;

public class OtherState implements LoggerState {
    private Printer printer;

    public OtherState(Printer printerType) {
        this.printer = printerType;
    }


    @Override
    public void log(int message) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void log(String message) {
            printer.print(message);
    }

    @Override
    public void close() {

    }
}
