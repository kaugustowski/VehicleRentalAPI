package pl.wizyg.VehicleRental.clients;

import java.util.List;

public interface ClientService {

    Client getClient(int id) throws ClientNotFoundException;

    List<Client> getClients();

}
