package behavioral_patterns.state_design_pattern.classes;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(int slot, Product product) {
        products.put(slot, product);
    }

    public Product getProduct(int slot) {
        return products.get(slot);
    }

    public void removeProduct(int slot) {
        products.remove(slot);
    }
}