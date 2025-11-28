package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;

// It Allows multiple object to handel the request without the sender needing to know which object will ultimately
// process it. If object receives a request and it is compatible to process it then it will process
// it otherwise it will pass it to next object
interface LogsProcessor{
    void logMessage(String message);
    void forwardMessage(String message);
}

class InfoLog implements LogsProcessor{
    private final LogsProcessor nextLogsProcessor;

    InfoLog(LogsProcessor nextLogsProcessor){
        this.nextLogsProcessor=nextLogsProcessor;
    }

    @Override
    public void logMessage(String message) {
        if(message.equals("INFO")){
            System.out.println("THE INFO MESSAGE IS LOGGED");
        }
        else{
            System.out.println("FORWARDING MESSAGE TO DEBUG");
            forwardMessage(message);
        }
    }

    @Override
    public void forwardMessage(String message) {
        nextLogsProcessor.logMessage(message);
    }
}

class DebugLog implements LogsProcessor{
    private final LogsProcessor nextLogsProcessor;

    DebugLog(LogsProcessor nextLogsProcessor){
        this.nextLogsProcessor=nextLogsProcessor;
    }

    @Override
    public void logMessage(String message) {
        if(message.equals("DEBUG")){
            System.out.println("THE DEBUG MESSAGE IS LOGGED");
        }
        else{
            System.out.println("FORWARDING MESSAGE TO ERROR");
            forwardMessage(message);
        }
    }

    @Override
    public void forwardMessage(String message) {
        nextLogsProcessor.logMessage(message);
    }
}

class ErrorLog implements LogsProcessor{
    private  LogsProcessor nextLogsProcessor;

    ErrorLog(LogsProcessor nextLogsProcessor){
        this.nextLogsProcessor=nextLogsProcessor;
    }

    ErrorLog(){
    }

    @Override
    public void logMessage(String message) {
        if(message.equals("ERROR")){
            System.out.println("THE ERROR MESSAGE IS LOGGED");
        }
        else{
            forwardMessage(message);
        }
    }

    @Override
    public void forwardMessage(String message) {
        nextLogsProcessor.logMessage(message);
    }
}

public class ChainOfResponsibility {
    public static void main(String [] args){

        LogsProcessor errorLog=new ErrorLog();
        LogsProcessor debugLog=new DebugLog(errorLog);
        LogsProcessor infoLog=new InfoLog(debugLog);

        infoLog.logMessage("ERROR");
        System.out.println("__________________________");
        debugLog.logMessage("ERROR");

    }
}
