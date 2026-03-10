# Composite Design Pattern – File System Example (Java)

## Overview

The **Composite Design Pattern** is a **structural design pattern** that allows you to treat **individual objects (leaf)** and **groups of objects (composite)** uniformly.

It is useful when objects form a **tree-like structure**, such as a **file system**, where folders can contain files or other folders.

In this implementation:

* **File** → Leaf node
* **Folder** → Composite node
* **FileSystemItem** → Common interface

The client interacts with all objects through the **FileSystemItem interface**.

---

# Problem

Without the Composite Pattern, the client must check the object type:

```java
if(item instanceof File) {
    // file logic
}
else if(item instanceof Folder) {
    // folder logic
}
```

This makes the code **complex and difficult to maintain**.

---

# Solution

Introduce a **common interface** that both leaf and composite classes implement.

```
FileSystemItem
       |
  -----------------
  |               |
 File           Folder
(Leaf)       (Composite)
```

This allows the client to treat **files and folders uniformly**.

---

# Project Structure

```
composite_design_pattern
│
├── interfaces
│     └── FileSystemItem.java
│
├── leaf_class
│     └── File.java
│
├── composite_class
│     └── Folder.java
│
└── Main.java
```

---

# UML Class Diagram

```
                <<interface>>
               FileSystemItem
        --------------------------------
        + ls(indent:int)
        + openAll(indent:int)
        + getSize():int
        + cd(name:String):FileSystemItem
        + getName():String
        + isFolder():boolean
        --------------------------------
                   ▲
          -----------------------
          |                     |
        File                  Folder
       (Leaf)              (Composite)
      ----------          -----------------
      - name:String       - name:String
      - size:int          - items:List<FileSystemItem>
      ----------          -----------------
      + ls()              + add(FileSystemItem)
      + openAll()         + ls()
      + getSize()         + openAll()
      + getName()         + getSize()
      + isFolder()        + cd()
```

---

# How Composite Pattern Works

```
Folder root
   |
   |---- File notes.txt
   |
   |---- File image.png
   |
   |---- Folder docs
            |
            |---- File resume.pdf
```

Both **File** and **Folder** are treated as **FileSystemItem**.

---

# Component Interface

Defines common operations for both files and folders.

```java
public interface FileSystemItem {

    void ls(int indent);

    void openAll(int indent);

    int getSize();

    FileSystemItem cd(String name);

    String getName();

    boolean isFolder();
}
```

---

# Leaf Class – File

Represents an individual file.

```java
public class File implements FileSystemItem {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void ls(int indent) {
        System.out.println(" ".repeat(indent) + name);
    }

    public void openAll(int indent) {
        System.out.println(" ".repeat(indent) + "Opening file: " + name);
    }

    public int getSize() {
        return size;
    }

    public FileSystemItem cd(String name) {
        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isFolder() {
        return false;
    }
}
```

---

# Composite Class – Folder

Represents a directory that can contain **files or other folders**.

```java
import java.util.*;

public class Folder implements FileSystemItem {

    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        items.add(item);
    }

    public void ls(int indent) {

        System.out.println(" ".repeat(indent) + "[" + name + "]");

        for (FileSystemItem item : items) {
            item.ls(indent + 2);
        }
    }

    public void openAll(int indent) {

        System.out.println(" ".repeat(indent) + "Opening folder: " + name);

        for (FileSystemItem item : items) {
            item.openAll(indent + 2);
        }
    }

    public int getSize() {

        int total = 0;

        for (FileSystemItem item : items) {
            total += item.getSize();
        }

        return total;
    }

    public FileSystemItem cd(String name) {

        for (FileSystemItem item : items) {
            if (item.getName().equals(name) && item.isFolder()) {
                return item;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isFolder() {
        return true;
    }
}
```

---

# Main Example

```java
public class Main {

    public static void main(String[] args) {

        Folder root = new Folder("root");
        Folder docs = new Folder("docs");

        File f1 = new File("notes.txt", 10);
        File f2 = new File("image.png", 20);
        File f3 = new File("resume.pdf", 15);

        docs.add(f3);

        root.add(f1);
        root.add(f2);
        root.add(docs);

        root.ls(0);
    }
}
```

---

# Output

```
[root]
  notes.txt
  image.png
  [docs]
    resume.pdf
```

---

# Advantages

* Treats **individual objects and compositions uniformly**
* Simplifies client code
* Supports **recursive tree structures**
* Follows **Open/Closed Principle**

---

# Real-World Examples

* File systems (files and folders)
* HTML DOM tree
* GUI components (panels and buttons)
* Organization hierarchy
* Menu systems

---

# Key Concepts Used

* Interface
* Inheritance
* Polymorphism
* Recursion
* Tree structures

---

# Conclusion

The **Composite Design Pattern** allows the client to work with **individual objects and compositions in the same way**.

In this example, both **File** and **Folder** implement the **FileSystemItem interface**, enabling a flexible and scalable file system structure.
