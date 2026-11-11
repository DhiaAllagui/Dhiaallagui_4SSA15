package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule addVehicule(Vehicule vehicule);

    Vehicule updateVehicule(Vehicule vehicule);

    Vehicule retrieveVehicule(Long id);

    List<Vehicule> retrieveAllVehicules();

    void removeVehicule(Long id);
}
