# Vending Machine - Low Level Design (State Design Pattern)

## Overview

This project demonstrates the **Low Level Design (LLD)** of a **Vending Machine** using the **State Design Pattern in Java**.
The State pattern is used because the behavior of the vending machine changes depending on its internal state such as **No Coin**, **Has Coin**, **Dispensing Product**, or **Sold Out**.

Instead of writing large `if-else` or `switch` statements, the behavior is encapsulated into separate **state classes**.

---

## Design Pattern Used

**State Design Pattern**

The **State Pattern** allows an object to change its behavior when its internal state changes. The object appears to change its class.

In this design:

* `VendingMachine` → Context
* `State` → Interface
* `NoCoinState`, `HasCoinState`, `DispenseState`, `SoldOutState` → Concrete States

---

## System Components

### 1. VendingMachine (Context)

This is the main class that maintains the current state of the vending machine.

Responsibilities:

* Manage machine states
* Handle user actions
* Maintain inventory
* Delegate behavior to the current state

---

### 2. State Interface

Defines all actions that can be performed on the vending machine.

Common actions:

* Insert Coin
* Select Product
* Dispense Product

Each concrete state implements these actions differently.

---

### 3. Concrete States

#### NoCoinState

Represents the state when the machine is waiting for a coin.

Behavior:

* Accept coin
* Reject product selection without coin

---

#### HasCoinState

Represents the state when a coin has been inserted.

Behavior:

* Allow product selection
* Move to dispensing state

---

#### DispenseState

Represents the state when the machine is dispensing a product.

Behavior:

* Release the selected product
* Update inventory
* Change state accordingly

---

#### SoldOutState

Represents the state when the machine has no products left.

Behavior:

* Reject coin insertion
* Reject product selection

---

### 4. Product

Represents items stored inside the vending machine.

Attributes:

* Product Name
* Product Price

---

### 5. Inventory

Maintains the mapping between machine slots and products.

Responsibilities:

* Add products
* Retrieve products
* Remove products after dispensing

---

## Workflow

1. User inserts a coin.
2. Machine transitions from **NoCoinState → HasCoinState**.
3. User selects a product.
4. Machine transitions from **HasCoinState → DispenseState**.
5. Product is dispensed.
6. Machine returns to **NoCoinState** or **SoldOutState** depending on inventory.

---

## Advantages of Using State Pattern

* Eliminates complex conditional logic
* Improves code readability
* Easy to extend with new states
* Follows **Open/Closed Principle**
* Each state has its own behavior

---

## Example Execution

Example flow:

```
Coin inserted
Product selected
Dispensing: Coke
```

---

## Possible Enhancements

This design can be extended further by adding:

* Multiple payment methods (UPI / Card / Cash)
* Coin validation system
* Change return algorithm
* Product restocking
* Admin interface
* Error handling

---

## Real World Usage

The State Design Pattern is commonly used in:

* ATM Machines
* Vending Machines
* Traffic Light Systems
* Media Players
* Order Processing Systems

---

## Conclusion

This project demonstrates how the **State Design Pattern** can be used to build a scalable and maintainable vending machine system.
By separating behaviors into different states, the system becomes easier to extend and maintain.

---
