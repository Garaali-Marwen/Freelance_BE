package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.PropositionDTO;
import com.project.Freelance_BE.Entities.Proposition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class PropositionDTOMapper implements Function<Proposition, PropositionDTO> {
    private final DeveloperDTOMapper developerDTOMapper;
    private final ProjectDTOMapper projectDTOMapper;

    @Override
    public PropositionDTO apply(Proposition proposition) {
        return new PropositionDTO(
                proposition.getId(),
                developerDTOMapper.apply(proposition.getDeveloper()),
                proposition.getPropositionState(),
                projectDTOMapper.apply(proposition.getProject())
        );
    }
}
