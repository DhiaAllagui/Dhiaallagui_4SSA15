package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Employe;
import com.example.dhiaallagui_4ssa15.service.IEmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PutMapping
    public ResponseEntity<Employe> updateEmploye(@RequestBody Employe employe) {
        if (employe.getIdEmploye() == null || employeService.retrieveEmploye(employe.getIdEmploye()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeService.updateEmploye(employe));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> retrieveEmploye(@PathVariable Long id) {
        Employe employe = employeService.retrieveEmploye(id);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employe);
    }

    @GetMapping
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEmploye(@PathVariable Long id) {
        if (employeService.retrieveEmploye(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employeService.removeEmploye(id);
        return ResponseEntity.ok().build();
    }
}
