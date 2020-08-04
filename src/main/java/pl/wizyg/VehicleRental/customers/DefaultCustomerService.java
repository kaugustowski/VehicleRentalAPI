package pl.wizyg.VehicleRental.customers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCustomerService implements CustomerService {

    final
    CustomerRepository customerRepository;

    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getClient(int id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Couldn't find customer with id: " + id));
    }

    @Override
    public List<Customer> getClients() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addClient(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteClient(int id) throws CustomerNotFoundException {
        customerRepository.delete(getClient(id));
    }
}
