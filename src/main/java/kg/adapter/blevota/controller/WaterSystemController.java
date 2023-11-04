package kg.adapter.blevota.controller;
import kg.adapter.blevota.document.WaterSystem;
import kg.adapter.blevota.service.WaterSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/water/system")
public class WaterSystemController {
    private final WaterSystemService service;

    @Autowired
    public WaterSystemController(WaterSystemService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final List<WaterSystem> waters) {
        service.save(waters);
    }

    @GetMapping("/{id}")
    public WaterSystem findById(@PathVariable final String id) {
        return service.findById(id);
    }
}
