package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement addPaiement(Paiement paiement);

    Paiement updatePaiement(Paiement paiement);

    Paiement retrievePaiement(Long id);

    List<Paiement> retrieveAllPaiements();

    void removePaiement(Long id);
}
