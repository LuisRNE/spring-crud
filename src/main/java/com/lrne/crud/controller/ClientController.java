package com.lrne.crud.controller;

import com.lrne.crud.entity.Client;
import com.lrne.crud.exception.ResourceNotFoundException;
import com.lrne.crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud/v1/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }
    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id:" + id));
        return ResponseEntity.ok(client);
    }
    @PutMapping("{id}")
    public ResponseEntity<Client> updateEmployee(@PathVariable long id, @RequestBody Client clientDetails){
        Client updateClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id:" + id));
        updateClient.setFirstName(clientDetails.getFirstName());
        updateClient.setLastName(clientDetails.getLastName());
        updateClient.setEmail(clientDetails.getEmail());
        updateClient.setRfc(clientDetails.getRfc());
        updateClient.setNss(clientDetails.getNss());

        clientRepository.save(updateClient);

        return  ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id:" + id));

        clientRepository.delete(client);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

