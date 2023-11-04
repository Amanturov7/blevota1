package kg.adapter.blevota.controller;
import kg.adapter.blevota.document.WaterHydropost;
import kg.adapter.blevota.service.WaterHydropostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/water/hydropost")
public class WaterHydropostController {
    private final WaterHydropostService service;

    @Autowired
    public WaterHydropostController(WaterHydropostService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final List<WaterHydropost> waters) {
        service.save(waters);
    }

    @GetMapping("/{id}")
    public WaterHydropost findById(@PathVariable final String id) {
        return service.findById(id);
    }
}
