package pl.wizyg.VehicleRental.clients;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    public Client getClient(int id) throws ClientNotFoundException;

    public List<Client> getClients();


}
