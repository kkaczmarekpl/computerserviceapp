package pl.wsiz.computerserviceapp.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.servicerequest.ServiceRequest;
import pl.wsiz.computerserviceapp.servicerequest.ServiceRequestService;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }
    @GetMapping("/address/{id}")
    public Optional<Address> getAddress(@PathVariable Long id) {
        return addressService.getAddress(id);
    }
    @PostMapping("/address")
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }
    @PutMapping("/address/{id}")
    public void updateAddress(@RequestBody Address address, @PathVariable Long id) {
        addressService.updateAddress(id, address);
    }
    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
