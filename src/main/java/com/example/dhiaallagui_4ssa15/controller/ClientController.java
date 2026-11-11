package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Client;
import com.example.dhiaallagui_4ssa15.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        if (client.getIdClient() == null || clientService.retrieveClient(client.getIdClient()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> retrieveClient(@PathVariable Long id) {
        Client client = clientService.retrieveClient(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeClient(@PathVariable Long id) {
        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.removeClient(id);
        return ResponseEntity.ok().build();
    }
}
