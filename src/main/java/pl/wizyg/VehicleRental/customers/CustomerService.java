package pl.wizyg.VehicleRental.customers;

import java.util.List;

public interface CustomerService {

    Customer getClient(int id) throws CustomerNotFoundException;

    List<Customer> getClients();

    Customer addClient(Customer customer);

    void deleteClient(int id) throws CustomerNotFoundException;

}
