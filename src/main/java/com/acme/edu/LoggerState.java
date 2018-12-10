package com.acme.edu;

public interface LoggerState {
    void log(int message);
    void log(String message);
    void close();
}
