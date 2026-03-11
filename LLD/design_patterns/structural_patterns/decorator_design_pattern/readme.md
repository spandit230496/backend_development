# Decorator Design Pattern (Java)

## Overview

The **Decorator Pattern** is a **structural design pattern** that allows behavior to be added to an object **dynamically at runtime** without modifying the original class.

Instead of creating many subclasses using inheritance, the decorator pattern **wraps objects with additional functionality**.

It follows the principle:

**"Favor Composition Over Inheritance."**

---

# Problem

Consider a **Mario game character** that can gain multiple powers.

Example powers:

* Height Up
* Gun Power
* Star Power
* Fly Power

If we implement this using inheritance:

```
Mario
MarioWithHeight
MarioWithGun
MarioWithHeightAndGun
MarioWithHeightAndGunAndStar
MarioWithFly
MarioWithFlyAndGun
MarioWithFlyAndHeight
MarioWithFlyHeightGun
```

As more abilities are added, the number of classes increases rapidly.

This is called **Class Explosion**.

Inheritance becomes difficult to manage and maintain.

---

# Solution: Decorator Pattern

Instead of creating many subclasses, we wrap objects with decorators.

Each decorator:

1. Calls the original object
2. Adds extra behavior

Structure:

```
Client
   |
Decorator
   |
Decorator
   |
Base Object
```

Each decorator modifies the result of the wrapped object.

---

# Key Concept

The decorator pattern uses two relationships with the component:

```
Decorator IS-A Component
Decorator HAS-A Component
```

This allows decorators to behave like the original object while also wrapping it.

---

# Structure of Decorator Pattern

The pattern consists of four main parts:

### 1. Component

Defines the interface for objects that can have responsibilities added.

### 2. Concrete Component

The base object that will be decorated.

### 3. Decorator (Base Decorator)

An abstract class that wraps the component.

### 4. Concrete Decorators

Classes that extend the decorator and add new behavior.

---

# UML Structure

```
        Component
        ---------
        operation()

            ^
            |
    -------------------
    |                 |
ConcreteComponent   Decorator
                        |
                        |
              ---------------------
              |                   |
     ConcreteDecoratorA   ConcreteDecoratorB
```

---

# Java Implementation Example

We will implement a Mario character with dynamic powers.

---

## 1. Component Interface

```java
interface Character {
    String getAbilities();
}
```

---

## 2. Concrete Component

```java
class Mario implements Character {

    public String getAbilities() {
        return "Mario";
    }
}
```

---

## 3. Base Decorator

```java
abstract class CharacterDecorator implements Character {

    protected Character character;

    public CharacterDecorator(Character character) {
        this.character = character;
    }
}
```

### Why this is the base decorator

* It **implements the component interface**
* It **stores a reference to the component**
* All decorators extend this class

This avoids repeating common code.

---

## 4. Concrete Decorators

### Height Power Decorator

```java
class HeightUpDecorator extends CharacterDecorator {

    public HeightUpDecorator(Character character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Height Up";
    }
}
```

---

### Gun Power Decorator

```java
class GunPowerDecorator extends CharacterDecorator {

    public GunPowerDecorator(Character character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Gun Power";
    }
}
```

---

### Star Power Decorator

```java
class StarPowerDecorator extends CharacterDecorator {

    public StarPowerDecorator(Character character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Star Power";
    }
}
```

---

# Usage Example

```java
public class Main {

    public static void main(String[] args) {

        Character mario = new Mario();

        mario = new HeightUpDecorator(mario);
        mario = new GunPowerDecorator(mario);
        mario = new StarPowerDecorator(mario);

        System.out.println(mario.getAbilities());
    }
}
```

---

# Output

```
Mario with Height Up with Gun Power with Star Power
```

---

# How It Works

1. Base object is created

```
Mario
```

2. First decorator wraps Mario

```
HeightUpDecorator(Mario)
```

3. Second decorator wraps the previous decorator

```
GunPowerDecorator(HeightUpDecorator(Mario))
```

4. Third decorator wraps again

```
StarPowerDecorator(GunPowerDecorator(HeightUpDecorator(Mario)))
```

Each decorator adds new functionality.

---

# Advantages

* Add functionality dynamically
* Avoid class explosion
* Follows Open Closed Principle
* More flexible than inheritance
* Promotes composition

---

# Disadvantages

* Many small classes can be created
* Debugging may be harder due to multiple layers

---

# Real World Examples

### 1. Text Formatting

```
Text
→ BoldDecorator
→ ItalicDecorator
→ UnderlineDecorator
```

Example:

```
Text → Bold → Italic
```

---

### 2. Input Validation

```
Request
→ EmailValidator
→ SQLInjectionValidator
→ XSSValidator
```

---

### 3. Java IO Classes

Java uses decorator pattern in its IO library.

Example:

```
InputStream
   ↓
FileInputStream
   ↓
BufferedInputStream
```

Classes:

* BufferedReader
* BufferedInputStream
* BufferedOutputStream

---

# When to Use Decorator Pattern

Use this pattern when:

* Behavior needs to be added dynamically
* You want to avoid subclass explosion
* You want flexible object composition
* Multiple optional features can be combined

---

# Official Definition

**Decorator Pattern attaches additional responsibilities to an object dynamically and provides a flexible alternative to subclassing for extending functionality.**

---

# Summary

The Decorator Pattern allows objects to be wrapped with additional functionality dynamically while keeping the original class unchanged. It is widely used in frameworks, libraries, and real-world systems to add behavior in a flexible and scalable way.

---

# Author

This project demonstrates the **Decorator Design Pattern in Java** for learning **Low Level Design (LLD)** and **Software Design Patterns**.
