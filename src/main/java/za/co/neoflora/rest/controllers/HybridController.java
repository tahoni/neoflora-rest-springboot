package za.co.neoflora.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.neoflora.dao.model.HybridDTO;
import za.co.neoflora.rest.services.HybridService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/hybrid")
public class HybridController {
    private final HybridService hybridService;

    @GetMapping
    public List<HybridDTO> getAll() {
        return hybridService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<HybridDTO> get(@PathVariable String id) {
        return hybridService.get(id);
    }

    @PostMapping
    public Optional<HybridDTO> insert(HybridDTO hybrid) {
        return hybridService.insert(hybrid);
    }

    @PutMapping
    public Optional<HybridDTO> update(HybridDTO hybrid) {
        return hybridService.update(hybrid);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return hybridService.delete(id);
    }
}
