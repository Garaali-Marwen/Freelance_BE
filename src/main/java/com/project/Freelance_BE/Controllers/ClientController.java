package com.project.Freelance_BE.Controllers;

import com.project.Freelance_BE.DTOs.ClientDTO;
import com.project.Freelance_BE.Entities.Client;
import com.project.Freelance_BE.Entities.File;
import com.project.Freelance_BE.Services.ClientService;
import com.project.Freelance_BE.Services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final FileService fileService;

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ClientDTO addClient(@RequestPart("client") Client client,
                               @RequestPart("image") MultipartFile image) {
        try {
            File file = fileService.uploadFile(image);
            client.setImage(file);
            return clientService.addClient(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/all")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/update")
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClientById(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }
}
