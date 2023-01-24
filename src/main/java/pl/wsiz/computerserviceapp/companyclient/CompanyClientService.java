package pl.wsiz.computerserviceapp.companyclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyClientService {
    @Autowired
    private CompanyClientRepository companyClientRepository;

    public List<CompanyClient> getAllCompanyClients() {
        List<CompanyClient> companyClients = new ArrayList<>();
        companyClientRepository.findAll().forEach(companyClients::add);
        return companyClients;
    }
    public void addCompanyClient(CompanyClient companyClient) {
        companyClientRepository.save(companyClient);
    }
    public Optional<CompanyClient> getCompanyClient(Long id) {
        return companyClientRepository.findById(id);
    }
    public void updateCompanyClient(Long id, CompanyClient companyClient) {
        companyClientRepository.save(companyClient);
    }
    public void deleteCompanyClient(Long id) {
        companyClientRepository.deleteById(id);
    }
}
