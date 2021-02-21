package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public abstract class LoggerBase {
    private final EnumSet<LogLevel> logLevels;
    private LoggerBase next;

    public LoggerBase(final EnumSet<LogLevel> logLevels) {
        this.logLevels = logLevels;
    }

    public void setNext(final LoggerBase next) {
        this.next = next;
    }

    protected abstract void writeMessage(String message);

    public void message(String message, LogLevel logLevel) {
        if (logLevels.contains(logLevel)) {
            writeMessage(message);
        }
        if (next != null) {
            next.message(message, logLevel);
        }
    }
}
