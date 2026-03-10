package LLD.design_patterns.structural_patterns.composite_design_pattern.leaf_class;
import LLD.design_patterns.structural_patterns.composite_design_pattern.interfaces.FileSystemItem;

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