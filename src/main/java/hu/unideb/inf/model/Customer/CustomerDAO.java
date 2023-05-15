package hu.unideb.inf.model.Customer;

import javafx.collections.ObservableList;

public interface CustomerDAO extends AutoCloseable{

    //A Customer adatintézés
    public void saveCustomer(Customer c);
    public void deleteCustomer(Customer c);
    public void updateCustomer(Customer c);
    public ObservableList<Customer> getCustomer();

}
