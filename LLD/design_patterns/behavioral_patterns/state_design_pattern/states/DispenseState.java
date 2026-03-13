package behavioral_patterns.state_design_pattern.states;

import behavioral_patterns.state_design_pattern.interfaces.State;
import behavioral_patterns.state_design_pattern.Context.VendingMachine;
import behavioral_patterns.state_design_pattern.classes.Product;

public class DispenseState implements State {

    VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Wait... dispensing product");
    }

    public void selectProduct(int slot) {
        System.out.println("Already processing");
    }

    public void dispense() {

        Product product = machine.getInventory()
                .getProduct(machine.getSelectedSlot());

        if (product != null) {
            System.out.println("Dispensing: " + product.getName());
            machine.getInventory().removeProduct(machine.getSelectedSlot());
        }

        machine.setState(machine.getNoCoinState());
    }
}
