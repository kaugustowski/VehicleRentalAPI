package pl.wizyg.VehicleRental.customers;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(int id) throws CustomerNotFoundException;

    List<Customer> getCustomers();

    Customer addCustomer(Customer customer);

    void deleteCustomer(int id) throws CustomerNotFoundException;

    Customer updateCustomer(int customerId, Customer newCustomer) throws CustomerNotFoundException;
}
