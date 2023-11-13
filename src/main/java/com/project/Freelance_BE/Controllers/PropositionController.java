package com.project.Freelance_BE.Controllers;

import com.project.Freelance_BE.DTOs.PropositionDTO;
import com.project.Freelance_BE.Entities.Proposition;
import com.project.Freelance_BE.Services.PropositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposition")
@AllArgsConstructor
public class PropositionController {

    private final PropositionService propositionService;


    @PostMapping(value = "/add")
    public Proposition addProposition(@RequestBody Proposition proposition) {

            return propositionService.addProposition(proposition);

    }


    @GetMapping("/all")
    public List<PropositionDTO> getAllPropositions() {
        return propositionService.getAllPropositions();
    }


    @GetMapping("/{id}")
    public PropositionDTO getPropositionById(@PathVariable("id") Long id) {
        return propositionService.getPropositionById(id);
    }

    @PutMapping("/update")
    public PropositionDTO updateProposition(@RequestBody PropositionDTO propositionDTO) {
        return propositionService.updateProposition(propositionDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deletePropositionById(@PathVariable("id") Long id) {
        propositionService.deletePropositionById(id);
    }


}
