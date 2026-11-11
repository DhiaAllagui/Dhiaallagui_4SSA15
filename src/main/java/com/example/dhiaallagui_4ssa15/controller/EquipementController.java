package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Equipement;
import com.example.dhiaallagui_4ssa15.service.IEquipementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @PutMapping
    public ResponseEntity<Equipement> updateEquipement(@RequestBody Equipement equipement) {
        if (equipement.getIdEquipement() == null || equipementService.retrieveEquipement(equipement.getIdEquipement()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipementService.updateEquipement(equipement));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> retrieveEquipement(@PathVariable Long id) {
        Equipement equipement = equipementService.retrieveEquipement(id);
        if (equipement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipement);
    }

    @GetMapping
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEquipement(@PathVariable Long id) {
        if (equipementService.retrieveEquipement(id) == null) {
            return ResponseEntity.notFound().build();
        }
        equipementService.removeEquipement(id);
        return ResponseEntity.ok().build();
    }
}
