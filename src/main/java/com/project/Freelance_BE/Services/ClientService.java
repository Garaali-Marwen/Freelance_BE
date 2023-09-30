package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.ClientDTO;
import com.project.Freelance_BE.Entities.Client;

import java.util.List;

public interface ClientService {
    ClientDTO addClient(Client client);
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClientById(Long id);
}
