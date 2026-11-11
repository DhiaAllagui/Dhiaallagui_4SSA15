package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Contrat;
import com.example.dhiaallagui_4ssa15.service.IContratService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping
    public ResponseEntity<Contrat> updateContrat(@RequestBody Contrat contrat) {
        if (contrat.getIdContrat() == null || contratService.retrieveContrat(contrat.getIdContrat()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contratService.updateContrat(contrat));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> retrieveContrat(@PathVariable Long id) {
        Contrat contrat = contratService.retrieveContrat(id);
        if (contrat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contrat);
    }

    @GetMapping
    public List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeContrat(@PathVariable Long id) {
        if (contratService.retrieveContrat(id) == null) {
            return ResponseEntity.notFound().build();
        }
        contratService.removeContrat(id);
        return ResponseEntity.ok().build();
    }
}
