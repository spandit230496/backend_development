package behavioral_patterns.state_design_pattern.Context;

import behavioral_patterns.state_design_pattern.interfaces.State;
import behavioral_patterns.state_design_pattern.classes.Inventory;
import behavioral_patterns.state_design_pattern.states.NoCoinState;
import behavioral_patterns.state_design_pattern.states.HasCoinState;
import behavioral_patterns.state_design_pattern.states.DispenseState;


public class VendingMachine {

    private State noCoinState;
    private State hasCoinState;
    private State dispenseState;

    private State currentState;

    private Inventory inventory;
    private int selectedSlot;

    public VendingMachine() {

        inventory = new Inventory();

        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        dispenseState = new DispenseState(this);

        currentState = noCoinState;
    }

    public void setState(State state) {
        currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void selectProduct(int slot) {
        currentState.selectProduct(slot);
    }

    public void dispense() {
        currentState.dispense();
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(int slot) {
        this.selectedSlot = slot;
    }
}
