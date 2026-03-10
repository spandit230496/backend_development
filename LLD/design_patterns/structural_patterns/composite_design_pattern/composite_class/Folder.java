package LLD.design_patterns.structural_patterns.composite_design_pattern.composite_class;

import java.util.*;
import LLD.design_patterns.structural_patterns.composite_design_pattern.interfaces.*;

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