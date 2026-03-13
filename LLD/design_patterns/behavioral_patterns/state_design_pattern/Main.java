package LLD.design_patterns.behavioral_patterns.state_design_pattern;
import LLD.design_patterns.behavioral_patterns.state_design_pattern.Context.VendingMachine;


public class Main {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        

        machine.getInventory().addProduct(1, new Product("Coke", 20));
        machine.getInventory().addProduct(2, new Product("Pepsi", 25));

        machine.insertCoin();
        machine.selectProduct(1);
        machine.dispense();
    }
}