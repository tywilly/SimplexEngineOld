package com.tywilly.SimplexEngine.util;

public class SELogger {

    public enum LogLevel{
        ERROR, WARN, INFO
    }

    private LogLevel logLevel;
    private String subsystem;

    public SELogger(){
        logLevel = LogLevel.INFO;
        subsystem = "General";
    }

    public SELogger(String subsystem){
        logLevel = LogLevel.INFO;
        this.subsystem = subsystem;
    }

    public SELogger(String subsystem, LogLevel logLevel){
        this.logLevel = logLevel;
        this.subsystem = subsystem;
    }

    private void printMessage(String message){
        System.out.println("[SimplexEngine][" + subsystem + "]" + message);
    }

    public void info(String message){
        if(logLevel == LogLevel.INFO)
            printMessage("[INFO]" + message);
    }

    public void warn(String message){
        if(logLevel == LogLevel.INFO || logLevel == LogLevel.WARN)
            printMessage("[WARN]" + message);
    }

    public void error(String message){
        if(logLevel == LogLevel.INFO || logLevel == LogLevel.WARN || logLevel == LogLevel.ERROR)
            printMessage("[ERROR]" + message);
    }

}
