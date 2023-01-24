package pl.wsiz.computerserviceapp.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public List<Address> getAllAddress() {
        List<Address> address = new ArrayList<>();
        addressRepository.findAll().forEach(address::add);
        return address;
    }
    public void addAddress(Address address) {
        addressRepository.save(address);
    }
    public Optional<Address> getAddress(Long id) {
        return addressRepository.findById(id);
    }
    public void updateAddress(Long id, Address address) {
        addressRepository.save(address);
    }
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
