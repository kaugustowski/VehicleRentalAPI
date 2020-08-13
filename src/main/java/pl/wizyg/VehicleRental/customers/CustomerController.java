package pl.wizyg.VehicleRental.customers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/")
    public Customer getName(@RequestParam int clientId) throws CustomerNotFoundException {
        Customer customer = customerService.getClient(clientId);

        return customer;
    }

    @RequestMapping("/list")
    public List<Customer> getClients() {
        List<Customer> customers = customerService.getClients();

        return customers;
    }

    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer addClient(@RequestBody Customer newCustomer) {
        return customerService.addClient(newCustomer);
    }

    @DeleteMapping("/delete")
    void deleteClient(@RequestParam int clientId) throws CustomerNotFoundException {
        customerService.deleteClient(clientId);
    }

}
