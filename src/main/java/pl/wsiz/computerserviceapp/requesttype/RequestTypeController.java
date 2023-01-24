package pl.wsiz.computerserviceapp.requesttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientService;

import java.util.List;
import java.util.Optional;

@Controller
public class RequestTypeController {
    @Autowired
    private RequestTypeService requestTypeService;

    @GetMapping("/requestType")
    public List<RequestType> getAllRequestType() {
        return requestTypeService.getAllRequestType();
    }
    @GetMapping("/requestType/{id}")
    public Optional<RequestType> getRequestType(@PathVariable Long id) {
        return requestTypeService.getRequestType(id);
    }
    @PostMapping("/requestType")
    public void addRequestType(@RequestBody RequestType requestType) {
        requestTypeService.addRequestType(requestType);
    }
    @PutMapping("/requestType/{id}")
    public void updateRequestType(@RequestBody RequestType requestType, @PathVariable Long id) {
        requestTypeService.updateRequestType(id, requestType);
    }
    @DeleteMapping("/requestType/{id}")
    public void deleteRequestType(@PathVariable Long id) {
        requestTypeService.deleteRequestType(id);
    }
}
