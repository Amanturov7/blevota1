package kg.adapter.blevota.controller;

import kg.adapter.blevota.document.Hydropost;
import kg.adapter.blevota.service.HydropostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hydropost")
public class HydropostController {
    private final HydropostService service;

    @Autowired
    public HydropostController(HydropostService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final List<Hydropost> hydroposts) {
        service.save(hydroposts);
    }

    @GetMapping("/{id}")
    public Hydropost findById(@PathVariable final String id) {
        return service.findById(id);
    }
}
