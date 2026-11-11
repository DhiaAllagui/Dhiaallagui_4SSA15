package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement addEquipement(Equipement equipement);

    Equipement updateEquipement(Equipement equipement);

    Equipement retrieveEquipement(Long id);

    List<Equipement> retrieveAllEquipements();

    void removeEquipement(Long id);
}
