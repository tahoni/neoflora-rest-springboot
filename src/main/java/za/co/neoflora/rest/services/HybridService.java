package za.co.neoflora.rest.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.neoflora.dao.domain.Hybrid;
import za.co.neoflora.dao.model.HybridDTO;
import za.co.neoflora.dao.repositories.HybridRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HybridService {
    private final HybridRepository hybridRepository;

    public List<HybridDTO> getAll() {
        List<Hybrid> hybrids = hybridRepository.findAll();
        return new ArrayList<>();
    }

    public Optional<HybridDTO> get(String id) {
        Long hybridId = Long.parseLong(id);
        Optional<Hybrid> hybrid = hybridRepository.findById(hybridId);
        return Optional.empty();
    }
}
