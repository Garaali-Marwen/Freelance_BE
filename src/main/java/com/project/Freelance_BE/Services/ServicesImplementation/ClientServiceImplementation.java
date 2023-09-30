package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.ClientDTO;
import com.project.Freelance_BE.DTOs.Mappers.ClientDTOMapper;
import com.project.Freelance_BE.Entities.Client;
import com.project.Freelance_BE.Enum.Role;
import com.project.Freelance_BE.Repositories.ClientRepository;
import com.project.Freelance_BE.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImplementation implements ClientService {
    private ClientRepository clientRepository;
    private ClientDTOMapper clientDTOMapper;

    @Override
    public ClientDTO addClient(Client client) {
        client.setRole(Role.CLIENT);
        return clientDTOMapper.apply(clientRepository.save(client));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(clientDTOMapper).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return clientDTOMapper.apply(
                clientRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                        "Client not found"
                ))
        );
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = clientRepository.findById(
                clientDTO.id()).orElseThrow(() -> new NoSuchElementException(
                "Client not found"
        ));
        client.setFirstName(clientDTO.firstName());
        client.setLastName(clientDTO.lastName());
        client.setEmail(clientDTO.email());
        client.setTel(clientDTO.tel());
        return clientDTOMapper.apply(clientRepository.save(client));
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
