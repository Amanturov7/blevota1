package kg.adapter.blevota.controller;

import kg.adapter.blevota.document.Sensor;
import kg.adapter.blevota.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class SensorController {
    private final SensorService service;

    @Autowired
    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final List<Sensor> sensors) {
        service.save(sensors);
    }

    @GetMapping("/{id}")
    public Sensor findById(@PathVariable final String id) {
        return service.findById(id);
    }
}
