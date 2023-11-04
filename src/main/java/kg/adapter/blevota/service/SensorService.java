package kg.adapter.blevota.service;

import kg.adapter.blevota.document.Sensor;
import kg.adapter.blevota.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final PersonRepository repository;

    @Autowired
    public SensorService(PersonRepository repository) {
        this.repository = repository;
    }

    public void save(List<Sensor> sensors) {
        repository.saveAll(sensors);
    }


    public Sensor findById(final String id) {
        return repository.findById(id).orElse(null);
    }
}
