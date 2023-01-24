package pl.wsiz.computerserviceapp.companyclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyClientController {
    @Autowired
    private CompanyClientService companyClientService;
    @GetMapping("/companyClient")
    public List<CompanyClient> getAllCompanyClients() {
        return companyClientService.getAllCompanyClients();
    }
    @GetMapping("/companyClient/{id}")
    public Optional<CompanyClient> getCompanyClient(@PathVariable Long id) {
        return companyClientService.getCompanyClient(id);
    }
    @PostMapping("/companyClient")
    public void addCompanyClient(@RequestBody CompanyClient companyClient) {
        companyClientService.addCompanyClient(companyClient);
    }

    @PutMapping("/companyClient/{id}")
    public void updateCompanyClient(@RequestBody CompanyClient companyClient, @PathVariable Long id) {
        companyClientService.updateCompanyClient(id, companyClient);
    }
    @DeleteMapping("/companyClient/{id}")
    public void deleteCompanyClient(@PathVariable Long id) {
        companyClientService.deleteCompanyClient(id);
    }
}
