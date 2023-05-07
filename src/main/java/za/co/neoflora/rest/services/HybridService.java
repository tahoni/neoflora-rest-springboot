package za.co.neoflora.rest.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import za.co.neoflora.dao.domain.Hybrid;
import za.co.neoflora.dao.domain.OffspringType;
import za.co.neoflora.dao.domain.SeedType;
import za.co.neoflora.dao.model.HybridDTO;
import za.co.neoflora.dao.repositories.HybridRepository;
import za.co.neoflora.dao.repositories.OffspringTypeRepository;
import za.co.neoflora.dao.repositories.SeedTypeRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class HybridService {
    private final HybridRepository hybridRepository;
    private final SeedTypeRepository seedTypeRepository;
    private final OffspringTypeRepository offspringTypeRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<HybridDTO> getAll() {
        List<Hybrid> hybrids = hybridRepository.findAll();
        return hybrids.stream()
                .map(hybrid -> modelMapper.map(hybrid, HybridDTO.class))
                .toList();
    }

    public Optional<HybridDTO> get(String id) {
        Long hybridId = Long.parseLong(id);
        Optional<Hybrid> hybrid = hybridRepository.findById(hybridId);
        HybridDTO hybridDTO = hybrid.map(hybrid1 -> modelMapper.map(hybrid1, HybridDTO.class)).orElseThrow();
        return Optional.of(hybridDTO);
    }

    public Optional<HybridDTO> insert(HybridDTO hybridDTO) {
        return insertOrUpdate(hybridDTO, new Hybrid());
    }

    public Optional<HybridDTO> update(HybridDTO hybridDTO) {
        Hybrid hybrid = hybridRepository.findById(hybridDTO.getId()).orElseThrow();
        return insertOrUpdate(hybridDTO, hybrid);
    }

    public void delete(String id) {
        Optional<Hybrid> hybrid = Optional.of(hybridRepository.findById(Long.parseLong(id)).orElseThrow());
        hybrid.ifPresent(hybridRepository::delete);
    }

    private Optional<HybridDTO> insertOrUpdate(HybridDTO hybridDTO, Hybrid hybrid) {
        hybrid.setCode(hybridDTO.getCode());
        hybrid.setDescription(hybridDTO.getDescription());
        hybrid.setComments(hybridDTO.getComments());

        SeedType seed = null;
        if (hybridDTO.getSeed() != null) {
            Long seedId = hybridDTO.getSeed().getId();
            seed = seedTypeRepository.findById(seedId).orElse(null);
        }
        hybrid.setSeed(seed);
        OffspringType offspring = null;
        if (hybridDTO.getOffspring() != null) {
            Long offspringId = hybridDTO.getOffspring().getId();
            offspring = offspringTypeRepository.findById(offspringId).orElse(null);
        }
        hybrid.setOffspring(offspring);

        Hybrid mother = null;
        if (hybridDTO.getMother() != null) {
            Long motherId = hybridDTO.getMother().getId();
            mother = hybridRepository.findById(motherId).orElse(null);
        }
        hybrid.setMother(mother);
        Hybrid father = null;
        if (hybridDTO.getFather() != null) {
            Long fatherId = hybridDTO.getFather().getId();
            father = hybridRepository.findById(fatherId).orElse(null);
        }
        hybrid.setFather(father);

        hybrid = hybridRepository.saveAndFlush(hybrid);
        return Optional.ofNullable(modelMapper.map(hybrid, HybridDTO.class));
    }
}
