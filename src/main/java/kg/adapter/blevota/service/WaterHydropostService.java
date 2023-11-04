package kg.adapter.blevota.service;

import kg.adapter.blevota.document.WaterHydropost;
import kg.adapter.blevota.repository.WaterHydropostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterHydropostService {

    private final WaterHydropostRepository repository;

    @Autowired
    public WaterHydropostService(WaterHydropostRepository repository) {
        this.repository = repository;
    }

    public void save(List<WaterHydropost> waters) {
        repository.saveAll(waters);
    }

    public WaterHydropost findById(final String id) {
        return repository.findById(id).orElse(null);
    }
}
