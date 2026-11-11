package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Paiement;
import com.example.dhiaallagui_4ssa15.service.IPaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @PostMapping
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @PutMapping
    public ResponseEntity<Paiement> updatePaiement(@RequestBody Paiement paiement) {
        if (paiement.getIdPaiement() == null || paiementService.retrievePaiement(paiement.getIdPaiement()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paiementService.updatePaiement(paiement));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> retrievePaiement(@PathVariable Long id) {
        Paiement paiement = paiementService.retrievePaiement(id);
        if (paiement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paiement);
    }

    @GetMapping
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePaiement(@PathVariable Long id) {
        if (paiementService.retrievePaiement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiementService.removePaiement(id);
        return ResponseEntity.ok().build();
    }
}
