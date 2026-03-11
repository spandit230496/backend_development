package LLD.design_patterns.structural_patterns.facade_design_pattern;
import LLD.design_patterns.structural_patterns.facade_design_pattern.subclasses.*;

public class ComputerFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void startComputer() {

        System.out.println("Starting Computer...");

        cpu.start();
        memory.load();
        hardDrive.read();

        System.out.println("Computer Started Successfully");
    }
}