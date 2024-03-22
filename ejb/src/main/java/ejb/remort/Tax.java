package ejb.remort;

import jakarta.ejb.Remote;

@Remote
public interface Tax {
    double calculate(double amount,double rate);
}
