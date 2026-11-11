package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Maintenance;
import com.example.dhiaallagui_4ssa15.service.IMaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @PutMapping
    public ResponseEntity<Maintenance> updateMaintenance(@RequestBody Maintenance maintenance) {
        if (maintenance.getIdMaintenance() == null || maintenanceService.retrieveMaintenance(maintenance.getIdMaintenance()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maintenanceService.updateMaintenance(maintenance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> retrieveMaintenance(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.retrieveMaintenance(id);
        if (maintenance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maintenance);
    }

    @GetMapping
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMaintenance(@PathVariable Long id) {
        if (maintenanceService.retrieveMaintenance(id) == null) {
            return ResponseEntity.notFound().build();
        }
        maintenanceService.removeMaintenance(id);
        return ResponseEntity.ok().build();
    }
}
