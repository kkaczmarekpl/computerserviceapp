package pl.wsiz.computerserviceapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //public List<Client> getAllClients() {return clients;}  wersja przed JPA
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }
    public List<Client> getClientByCompanyClient(Long id) {
        List<Client> clients = new ArrayList<>();
        clientRepository.findByCompanyClientId(id).forEach(clients::add);
        return clients;
    }
    public void addClient(Client client) {
        client.setClientType("standard");
        client.setAllowNotifications(true);
        clientRepository.save(client);
    }
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }
    public void updateClient(Long id, Client client) {
        clientRepository.save(client);
    }
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    //metody używane przy testowaniu obiektu client
    /*public Client getClient(Integer id) {
        Client client = clients.stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return client;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void updateClient(Integer id, Client client) {
        for(int i=0 ; i<clients.size(); i++) {
            Client c = clients.get(i);
            Integer idInteger = c.getId();    //przypisanie c.getId do klasy Integer
            if(idInteger.equals(id)) {
                clients.set(i, client);
            }
        }
    }


    public void deleteClient(Integer id) {
        clients.removeIf(c -> Integer.valueOf(c.getId()).equals(id));
    }*/
}
