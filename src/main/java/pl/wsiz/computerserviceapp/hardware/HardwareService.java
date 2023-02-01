package pl.wsiz.computerserviceapp.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HardwareService {
    @Autowired
    private HardwareRepository hardwareRepository;

    public List<Hardware> getAllHardware() {
        List<Hardware> hardware = new ArrayList<>();
        hardwareRepository.findAll().forEach(hardware::add);
        return hardware;
    }
    public void addHardware(Hardware hardware) {
        hardware.setReleased(false);
        hardwareRepository.save(hardware);
    }

    public void addHardwareObject(Hardware hardware) {
        hardware.setReleased(false);
        hardwareRepository.save(hardware);
    }
    public Optional<Hardware> getHardware(Long id) {
        return hardwareRepository.findById(id);
    }
    public void updateHardware(Long id, Hardware hardware) {
        hardwareRepository.save(hardware);
    }
    public void deleteHardware(Long id) {
        hardwareRepository.deleteById(id);
    }
}
