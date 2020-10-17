package pl.wizyg.VehicleRental.customers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCustomerService implements CustomerService {

    private final
    CustomerRepository customerRepository;

    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(int id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Couldn't find customer with id: " + id));
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) throws CustomerNotFoundException {
        customerRepository.delete(getCustomer(id));
    }

    @Override
    public Customer updateCustomer(int customerId, Customer newCustomer) throws CustomerNotFoundException {

        Customer cust = getCustomer(customerId);

        cust.setEmail(newCustomer.getEmail() != null ? newCustomer.getEmail() : cust.getEmail());
        cust.setFirstName(newCustomer.getFirstName() != null ? newCustomer.getFirstName() : cust.getFirstName());
        cust.setLastName(newCustomer.getLastName() != null ? newCustomer.getLastName() : cust.getLastName());

        customerRepository.save(cust);

        return cust;
    }
}
