package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Agence;
import com.example.dhiaallagui_4ssa15.service.IAgenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping
    public ResponseEntity<Agence> updateAgence(@RequestBody Agence agence) {
        if (agence.getIdAgence() == null || agenceService.retrieveAgence(agence.getIdAgence()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> retrieveAgence(@PathVariable Long id) {
        Agence agence = agenceService.retrieveAgence(id);
        if (agence == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agence);
    }

    @GetMapping
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAgence(@PathVariable Long id) {
        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.removeAgence(id);
        return ResponseEntity.ok().build();
    }
}
