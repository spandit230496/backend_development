# Interface Segregation Principle (ISP)

The **Interface Segregation Principle (ISP)** is one of the five SOLID principles of object-oriented design.

> **Clients should not be forced to depend on interfaces they do not use.**

Instead of creating **one large interface**, we create **multiple small and specific interfaces** so that classes implement only the methods they actually need.

---

# Problem Without ISP

If we create a large interface like this:

```python
from abc import ABC, abstractmethod

class Worker(ABC):

    @abstractmethod
    def work(self):
        pass

    @abstractmethod
    def eat(self):
        pass
```

Now if we create two classes:

```python
class Human(Worker):

    def work(self):
        print("Human is working")

    def eat(self):
        print("Human is eating")


class Robot(Worker):

    def work(self):
        print("Robot is working")

    def eat(self):
        raise Exception("Robot cannot eat")
```

### Issue

The `Robot` class is **forced to implement `eat()`**, even though robots do not eat.
This violates the **Interface Segregation Principle**.

---

# Solution Using ISP

We split the large interface into smaller interfaces.

```python
from abc import ABC, abstractmethod

class Workable(ABC):

    @abstractmethod
    def work(self):
        pass


class Eatable(ABC):

    @abstractmethod
    def eat(self):
        pass
```

---

# Implementation

### Human Class

```python
class Human(Workable, Eatable):

    def work(self):
        print("Human is working")

    def eat(self):
        print("Human is eating")
```

### Robot Class

```python
class Robot(Workable):

    def work(self):
        print("Robot is working")
```

---

# Usage

```python
if __name__ == "__main__":

    human = Human()
    robot = Robot()

    human.work()
    human.eat()

    robot.work()
```

---

# Output

```
Human is working
Human is eating
Robot is working
```

---

# Benefits of ISP

* Reduces **unnecessary dependencies**
* Improves **code maintainability**
* Improves **flexibility**
* Makes **code easier to extend**
* Prevents classes from implementing methods they do not use

---

# Key Idea

Instead of this:

```
Worker
 ├── work()
 └── eat()
```

Use this:

```
Workable
 └── work()

Eatable
 └── eat()
```

Each class implements **only the interfaces it needs**.

---

# Interview Definition

**Interface Segregation Principle (ISP):**

> A class should not be forced to implement methods it does not use.

---

# SOLID Principles

1. **S** – Single Responsibility Principle
2. **O** – Open/Closed Principle
3. **L** – Liskov Substitution Principle
4. **I** – Interface Segregation Principle
5. **D** – Dependency Inversion Principle
