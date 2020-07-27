package pl.wizyg.VehicleRental.clients;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    final
    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClient(int id) throws ClientNotFoundException {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Couldn't find client with id: " + id));
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}
