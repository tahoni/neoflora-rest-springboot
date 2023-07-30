package za.co.neoflora.neoflorarest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.neoflora.neofloradao.model.HybridDTO;
import za.co.neoflora.neoflorarest.services.HybridService;

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
    public Optional<HybridDTO> insert(@RequestBody HybridDTO hybrid) {
        return hybridService.insert(hybrid);
    }

    @PutMapping
    public Optional<HybridDTO> update(@RequestBody HybridDTO hybrid) {
        return hybridService.update(hybrid);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        hybridService.delete(id);
    }
}
