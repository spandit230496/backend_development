package behavioral_patterns.state_design_pattern.interfaces;

public interface State {

    void insertCoin();
    void selectProduct(int slot);
    void dispense();
}