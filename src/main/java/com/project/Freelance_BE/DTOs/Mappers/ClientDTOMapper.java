package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.ClientDTO;
import com.project.Freelance_BE.Entities.Client;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getRole(),
                client.getImage(),
                client.getTel()
        );
    }
}
