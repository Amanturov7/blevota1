package kg.adapter.blevota.service;

import kg.adapter.blevota.document.WaterSystem;
import kg.adapter.blevota.repository.WaterSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WaterSystemService {

    private final WaterSystemRepository repository;

    @Autowired
    public WaterSystemService(WaterSystemRepository repository) {
        this.repository = repository;
    }

    public void save(List<WaterSystem> waters) {
        repository.saveAll(waters);
    }

    public WaterSystem findById(final String id) {
        return repository.findById(id).orElse(null);
    }
}
