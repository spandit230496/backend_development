package LLD.design_patterns.behavioral_patterns.chain_of_responsiblity;

abstract class Logger {

    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(String level, String message) {
        if (canHandle(level)) {
            write(message);
        } else if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract boolean canHandle(String level);
    protected abstract void write(String message);
}

class InfoLogger extends Logger {

    protected boolean canHandle(String level) {
        return level.equals("INFO");
    }

    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

class DebugLogger extends Logger {

    protected boolean canHandle(String level) {
        return level.equals("DEBUG");
    }

    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}

class ErrorLogger extends Logger {

    protected boolean canHandle(String level) {
        return level.equals("ERROR");
    }

    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

public class Main {

    public static void main(String[] args) {

        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        // Build the chain
        infoLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);

        // Send requests
        infoLogger.logMessage("INFO", "Application started");
        infoLogger.logMessage("DEBUG", "Debugging mode on");
        infoLogger.logMessage("ERROR", "Something went wrong");
    }
}
