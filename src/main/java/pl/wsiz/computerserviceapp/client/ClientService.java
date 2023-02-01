package pl.wsiz.computerserviceapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wsiz.computerserviceapp.Role;
import pl.wsiz.computerserviceapp.servicerequest.ServiceRequest;
import pl.wsiz.computerserviceapp.user.User;
import pl.wsiz.computerserviceapp.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserService userService;

    //public List<Client> getAllClients() {return clients;}  wersja przed JPA
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }
    public void addClient(Client client) {
        client.setClientType("standard");
        client.setAllowNotifications(true);
        User user = new User();
        user.setRole(Role.USER);
        user.setUsername(((client.getFirstName()+client.getLastName()+getNextClientId()).trim()).toLowerCase());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(client.getPassword());
        user.setPassword(encodedPassword);

        userService.addUser(user);
        client.setUser(user);
        clientRepository.save(client);
    }
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }
    public void updateClient(Client client) {
        Client clientSaved = new Client();
        clientSaved = clientRepository.findById(client.getId()).get();
        if(!clientSaved.equals(client)) {
            client.setCompanyClient(clientSaved.getCompanyClient());
            client.setClientType(clientSaved.getClientType());
            client.setAllowNotifications(clientSaved.isAllowNotifications());
            clientRepository.save(client);
        }
    }
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
    public List<Client> getClientByCompanyClient(Long id) {
        List<Client> clients = new ArrayList<>();
        clientRepository.findByCompanyClientId(id).forEach(clients::add);
        return clients;
    }

    public Long getNextClientId() {
        if(getBiggestId() <= 0)
            return 1L;
        else
            return getBiggestId();
    }

    public Long getBiggestId() {
        if(clientRepository.findBiggestId() != null)
            return clientRepository.findBiggestId()+1;
        else
            return 1L;
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
