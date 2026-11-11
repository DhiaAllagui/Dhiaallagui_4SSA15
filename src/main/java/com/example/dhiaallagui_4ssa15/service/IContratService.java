package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Contrat;

import java.util.List;

public interface IContratService {
    Contrat addContrat(Contrat contrat);

    Contrat updateContrat(Contrat contrat);

    Contrat retrieveContrat(Long id);

    List<Contrat> retrieveAllContrats();

    void removeContrat(Long id);
}
