package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Employe;

import java.util.List;

public interface IEmployeService {
    Employe addEmploye(Employe employe);

    Employe updateEmploye(Employe employe);

    Employe retrieveEmploye(Long id);

    List<Employe> retrieveAllEmployes();

    void removeEmploye(Long id);
}
