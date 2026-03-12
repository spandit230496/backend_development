# Chain of Responsibility Design Pattern (Java)

## Overview

The **Chain of Responsibility** is a **behavioral design pattern** that allows a request to pass through a chain of handlers.
Each handler decides whether to:

* **Handle the request**, or
* **Pass it to the next handler in the chain**

This pattern **decouples the sender of a request from its receivers**, allowing multiple objects to handle the request dynamically.

---

# Problem

Sometimes a request can be handled by **multiple possible objects**, but the sender should not know which one will process it.

Example:

* Logging systems
* Middleware pipelines
* Authentication filters
* Approval workflows

Instead of tightly coupling the sender with a specific handler, we create a **chain of handlers**.

---

# Solution

Create a chain of handler objects where:

1. Each handler has a reference to the **next handler**
2. The handler decides whether it can process the request
3. If it cannot, it forwards the request to the **next handler**

---

classDiagram

class Logger{
  <<abstract>>
  - Logger nextLogger
  + setNext(Logger)
  + logMessage(level, message)
  # canHandle(level)
  # write(message)
}

class InfoLogger{
  + canHandle(level)
  + write(message)
}

class DebugLogger{
  + canHandle(level)
  + write(message)
}

class ErrorLogger{
  + canHandle(level)
  + write(message)
}

class Main{
  + main()
}

Logger <|-- InfoLogger
Logger <|-- DebugLogger
Logger <|-- ErrorLogger

Logger --> Logger : nextLogger
Main --> Logger

# Structure

Client → Handler1 → Handler2 → Handler3

Each handler performs:

```
Handle Request
      OR
Forward Request
```

---

# Implementation (Java Example)

```java
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

        infoLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);

        infoLogger.logMessage("INFO", "Application started");
        infoLogger.logMessage("DEBUG", "Debugging mode");
        infoLogger.logMessage("ERROR", "Something went wrong");
    }
}
```

---

# Execution Flow

Chain:

```
InfoLogger → DebugLogger → ErrorLogger
```

Example request:

```
logMessage("ERROR", "Something went wrong")
```

Flow:

```
InfoLogger → cannot handle
     ↓
DebugLogger → cannot handle
     ↓
ErrorLogger → handles request
```

---

# Output

```
INFO: Application started
DEBUG: Debugging mode
ERROR: Something went wrong
```

---

# Real World Use Cases

## 1. Logging Frameworks

Used in libraries like **Log4j** or **SLF4J**

```
INFO → DEBUG → ERROR → FATAL
```

Each logger handles its own level.

---

## 2. Middleware Pipeline

Used in **Spring Boot filters** or **Express.js middleware**

```
Request
   ↓
Authentication Filter
   ↓
Authorization Filter
   ↓
Logging Filter
   ↓
Controller
```

---

## 3. Payment Processing

```
Payment Request
      ↓
Fraud Check
      ↓
Balance Check
      ↓
Payment Processor
```

Each step decides whether to continue.

---

## 4. Approval Systems

Example: Leave approval

```
Employee Request
      ↓
Manager
      ↓
Director
      ↓
CEO
```

If manager cannot approve, it moves up.

---

## 5. Customer Support Escalation

```
Customer Issue
      ↓
Level 1 Support
      ↓
Level 2 Support
      ↓
Manager
```

---

# Advantages

✔ Loose coupling between sender and receiver
✔ Flexible chain configuration
✔ Single Responsibility Principle
✔ Easy to add new handlers

---

# Disadvantages

✖ Request might go unhandled
✖ Hard to debug long chains
✖ Performance overhead if chain is large

---

# When to Use

Use **Chain of Responsibility** when:

* Multiple objects can handle a request
* The handler should be determined **at runtime**
* You want to avoid **tight coupling between sender and receiver**
* Processing must happen in **sequence**

---

# Key Concept

Instead of:

```
if (type == A)
if (type == B)
if (type == C)
```

We create a **chain of handlers**.

```
HandlerA → HandlerB → HandlerC
```

Each handler decides:

```
Handle OR Forward
```

---