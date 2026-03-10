package LLD.design_patterns.structural_patterns.composite_design_pattern.interfaces;

public interface FileSystemItem {

    void ls(int indent);

    void openAll(int indent);

    int getSize();

    FileSystemItem cd(String name);

    String getName();

    boolean isFolder();
}
