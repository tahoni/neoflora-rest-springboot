package za.co.neoflora.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import za.co.neoflora.dao.model.HybridDTO;
import za.co.neoflora.rest.services.HybridService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController("/hybrid")
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
}
