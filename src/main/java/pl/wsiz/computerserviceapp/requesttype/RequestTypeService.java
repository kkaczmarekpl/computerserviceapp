package pl.wsiz.computerserviceapp.requesttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestTypeService {
    @Autowired
    private RequestTypeRepository requestTypeRepository;

    public List<RequestType> getAllRequestType() {
        List<RequestType> requestType = new ArrayList<>();
        requestTypeRepository.findAll().forEach(requestType::add);
        return requestType;
    }

    public void addRequestType(RequestType requestType) {
        requestTypeRepository.save(requestType);
    }
    public Optional<RequestType> getRequestType(Long id) {
        return requestTypeRepository.findById(id);
    }
    public void updateRequestType(Long id, RequestType requestType) {
        requestTypeRepository.save(requestType);
    }
    public void deleteRequestType(Long id) {
        requestTypeRepository.deleteById(id);
    }
}
