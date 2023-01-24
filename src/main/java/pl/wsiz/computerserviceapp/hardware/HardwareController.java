package pl.wsiz.computerserviceapp.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientService;

import java.util.List;
import java.util.Optional;

@Controller
public class HardwareController {
    @Autowired
    private HardwareService hardwareService;

    @GetMapping("/hardware")
    public List<Hardware> getAllCHardware() {
        return hardwareService.getAllCHardware();
    }
    @GetMapping("/hardware/{id}")
    public Optional<Hardware> getHardware(@PathVariable Long id) {
        return hardwareService.getHardware(id);
    }
    @PostMapping("/index/service-request/hardware")
    public void addHardware(@RequestBody Hardware hardware) {
        hardwareService.addHardware(hardware);
    }
    @PutMapping("/hardware/{id}")
    public void updateHardware(@RequestBody Hardware hardware, @PathVariable Long id) {
        hardwareService.updateHardware(id, hardware);
    }
    @DeleteMapping("/hardware/{id}")
    public void deleteHardware(@PathVariable Long id) {
        hardwareService.deleteHardware(id);
    }
}
