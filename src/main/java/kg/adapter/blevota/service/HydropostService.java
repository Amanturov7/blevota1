package kg.adapter.blevota.service;

import kg.adapter.blevota.document.Hydropost;
import kg.adapter.blevota.repository.HydropostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HydropostService {

    private final HydropostRepository repository;

    @Autowired
    public HydropostService(HydropostRepository repository) {
        this.repository = repository;
    }

    public void save(List<Hydropost> hydroposts) {
        repository.saveAll(hydroposts);
    }

    public Hydropost findById(final String id) {
        return repository.findById(id).orElse(null);
    }
}
