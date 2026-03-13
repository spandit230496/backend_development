package behavioral_patterns.state_design_pattern.states;

import behavioral_patterns.state_design_pattern.interfaces.State;
import behavioral_patterns.state_design_pattern.Context.VendingMachine;
import behavioral_patterns.state_design_pattern.classes.Product;


public class HasCoinState implements State {

    VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    public void selectProduct(int slot) {

        Product product = machine.getInventory().getProduct(slot);

        if (product == null) {
            System.out.println("Product not available");
            return;
        }

        machine.setSelectedSlot(slot);
        System.out.println("Product selected: " + product.getName());

        machine.setState(machine.getDispenseState());
    }

    public void dispense() {
        System.out.println("Select product first");
    }
}