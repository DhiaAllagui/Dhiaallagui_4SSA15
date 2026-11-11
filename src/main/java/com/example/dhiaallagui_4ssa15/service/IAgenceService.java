package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Agence;

import java.util.List;

public interface IAgenceService {
    Agence addAgence(Agence agence);

    Agence updateAgence(Agence agence);

    Agence retrieveAgence(Long id);

    List<Agence> retrieveAllAgences();

    void removeAgence(Long id);
}
