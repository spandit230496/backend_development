# Command Design Pattern (Java)

## Introduction

The **Command Design Pattern** is a behavioral design pattern that converts a request into an object. By wrapping a request inside an object, we can pass the request as a parameter, queue it, log it, or execute it later.

The main idea of this pattern is to **separate the object that sends a request from the object that performs the action**.

Instead of calling methods directly on a class, we create a command object that contains the request and execute that command when needed.

---

## Problem

In many applications, one object needs to trigger an action on another object. If the sender directly calls the receiver's methods, both classes become tightly coupled.

For example, if a remote control directly calls methods on devices like Light, Fan, or AC, the remote becomes dependent on all these classes. Adding new devices later would require modifying the remote control code.

The **Command Pattern** solves this problem by introducing a command object between the sender and the receiver.

---

## Real World Example

A simple real-world example is a **TV or Light remote control**.

When you press a button on the remote:

1. The remote triggers a command.
2. The command knows which device to operate.
3. The device performs the requested action.

The remote does not know how the device works internally. It simply executes a command.

---

## Components of Command Pattern

The Command Pattern has five main components.

### 1. Command

An interface that declares a method to execute the command.

```java
interface Command {
    void execute();
}
```

---

### 2. Receiver

The receiver is the object that performs the actual work.

```java
class Light {

    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
```

---

### 3. Concrete Command

Concrete command classes implement the command interface and connect the command to the receiver.

Example: turning the light ON.

```java
class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}
```

Example: turning the light OFF.

```java
class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}
```

---

### 4. Invoker

The invoker is the object that triggers the command.

```java
class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

The invoker does not know how the command works internally. It only calls the `execute()` method.

---

### 5. Client

The client creates command objects and connects them with the receiver.

```java
public class Main {

    public static void main(String[] args) {

        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
```

---

## Execution Flow

The execution flow of the command pattern works as follows:

1. The client creates the receiver.
2. The client creates command objects and passes the receiver to them.
3. The client sets the command in the invoker.
4. The invoker calls the command.
5. The command executes the receiver's method.

Flow representation:

```
Client → Invoker → Command → Receiver
```

Example:

```
RemoteControl → LightOnCommand → Light.turnOn()
```

---

## Output

```
Light is ON
Light is OFF
```

---

## Advantages

- Reduces coupling between the sender and the receiver.
- Makes the system easier to extend.
- Supports undo and redo operations.
- Commands can be stored, queued, or logged.
- Follows the Open-Closed Principle.

---

## Disadvantages

- The number of classes increases.
- Adds extra complexity for simple operations.

---

## When to Use Command Pattern

The Command Pattern is commonly used in the following scenarios:

- GUI buttons and menu actions
- Remote control systems
- Task queues and job schedulers
- Undo and redo functionality
- Transaction processing systems

---

## Key Idea

The main idea of the Command Pattern is:

```
Invoker → Command → Receiver
```

The invoker triggers the command, and the command performs the action on the receiver.

This approach makes the system flexible, modular, and easy to extend.