package ejb.impl;

import ejb.remort.Cart;
import jakarta.ejb.Stateful;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Stateful
public class CartBean implements Cart {
    private Map<String, Object> items = new HashMap<>();
    @Override
    public void addItem(String item) {
        items.put(item, item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public double getTotal() {
        return items.size();
    }

    @Override
    public void removeItem(String item) {
        items.remove(item);
    }

    @Override
    public Map getItems() {
        return items;
    }
}
