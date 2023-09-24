package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.TransactionDTO;
import com.project.Freelance_BE.Entities.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class TransactionDTOMapper implements Function<Transaction, TransactionDTO> {
    private final ProjectDTOMapper projectDTOMapper;
    private final DeveloperDTOMapper developerDTOMapper;

    @Override
    public TransactionDTO apply(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                projectDTOMapper.apply(transaction.getProject()),
                developerDTOMapper.apply(transaction.getDeveloper())
        );
    }
}
