package LLD.design_patterns.structural_patterns.composite_design_pattern;
import LLD.design_patterns.structural_patterns.composite_design_pattern.composite_class.*;
import LLD.design_patterns.structural_patterns.composite_design_pattern.leaf_class.*;

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

        System.out.println("File Structure:");
        root.ls(0);

        System.out.println("\nTotal Size: " + root.getSize());

        System.out.println("\nOpening all:");
        root.openAll(0);
    }
}
