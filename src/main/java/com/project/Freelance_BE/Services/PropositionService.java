package com.project.Freelance_BE.Services;



import com.project.Freelance_BE.DTOs.PropositionDTO;
import com.project.Freelance_BE.Entities.Proposition;

import java.util.List;

public interface PropositionService  {
    Proposition addProposition(Proposition proposition);
    List<PropositionDTO> getAllPropositions();
    PropositionDTO getPropositionById(Long id);
    PropositionDTO updateProposition(PropositionDTO propositionDTO);
    void deletePropositionById(Long id);
}