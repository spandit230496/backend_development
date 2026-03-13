package behavioral_patterns.state_design_pattern.states;

import behavioral_patterns.state_design_pattern.interfaces.State;
import behavioral_patterns.state_design_pattern.Context.VendingMachine;

public class NoCoinState implements State {

    VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Coin inserted");
        machine.setState(machine.getHasCoinState());
    }

    public void selectProduct(int slot) {
        System.out.println("Insert coin first");
    }

    public void dispense() {
        System.out.println("Insert coin");
    }
}
