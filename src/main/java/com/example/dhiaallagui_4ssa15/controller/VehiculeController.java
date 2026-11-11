package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Vehicule;
import com.example.dhiaallagui_4ssa15.service.IVehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping
    public ResponseEntity<Vehicule> updateVehicule(@RequestBody Vehicule vehicule) {
        if (vehicule.getIdVehicule() == null || vehiculeService.retrieveVehicule(vehicule.getIdVehicule()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehiculeService.updateVehicule(vehicule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> retrieveVehicule(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.retrieveVehicule(id);
        if (vehicule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicule);
    }

    @GetMapping
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeVehicule(@PathVariable Long id) {
        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.removeVehicule(id);
        return ResponseEntity.ok().build();
    }
}
