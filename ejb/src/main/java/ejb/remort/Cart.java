package ejb.remort;

import jakarta.ejb.Remote;

import java.util.Map;
@Remote
public interface Cart {
    public void addItem(String item);
    public int getCount();
    public double getTotal();
    public void removeItem(String item);
    public Map <String, Object> getItems();
}
