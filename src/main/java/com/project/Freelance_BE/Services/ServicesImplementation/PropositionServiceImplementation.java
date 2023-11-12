package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.Mappers.PropositionDTOMapper;
import com.project.Freelance_BE.DTOs.PropositionDTO;
import com.project.Freelance_BE.Entities.Proposition;
import com.project.Freelance_BE.Repositories.PropositionRepository;
import com.project.Freelance_BE.Services.PropositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service

public class PropositionServiceImplementation implements PropositionService {

    private final PropositionRepository propositionRepository;
    private final PropositionDTOMapper propositionDTOMapper;
    @Override
    public Proposition addProposition(Proposition proposition) {
        return propositionRepository.save(proposition);    }

    @Override
    public List<PropositionDTO> getAllPropositions() {
        return propositionRepository.findAll().stream().map(propositionDTOMapper).collect(Collectors.toList());
    }

    @Override
    public PropositionDTO getPropositionById(Long id) {
        return propositionDTOMapper.apply(
                propositionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                        "Proposition not found"
                ))
        );    }

    @Override
    public PropositionDTO updateProposition(PropositionDTO propositionDTO) {
        Proposition proposition = propositionRepository.findById(
                propositionDTO.id()).orElseThrow(() -> new NoSuchElementException(
                "Proposition not found"
        ));

        return propositionDTOMapper.apply(propositionRepository.save(proposition));    }

    @Override
    public void deletePropositionById(Long id) {
        propositionRepository.deleteById(id);

    }
}
