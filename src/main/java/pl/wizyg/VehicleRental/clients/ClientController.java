package pl.wizyg.VehicleRental.clients;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    final
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/client")
    public Client getName(@RequestParam int clientId) throws ClientNotFoundException {
        Client client = clientService.getClient(clientId);

        return client;
    }

    @RequestMapping("/client/list")
    public List<Client> getClients() {
        List<Client> clients = clientService.getClients();

        return clients;
    }
}
