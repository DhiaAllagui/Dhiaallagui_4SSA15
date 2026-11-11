package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Contrat;
import com.example.dhiaallagui_4ssa15.repository.ContratRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService {

    private final ContratRepository contratRepository;

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        // paiements n'est pas envoyé en JSON : on garde ceux déjà en base,
        // sinon orphanRemoval les supprimerait
        if (contrat.getPaiements() == null) {
            contratRepository.findById(contrat.getIdContrat())
                    .ifPresent(existant -> contrat.setPaiements(existant.getPaiements()));
        }
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat retrieveContrat(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public void removeContrat(Long id) {
        contratRepository.findById(id).ifPresent(contrat -> {
            // détacher la réservation avant suppression ; les paiements suivent (cascade)
            if (contrat.getReservation() != null) {
                contrat.getReservation().setContrat(null);
            }
            contratRepository.delete(contrat);
        });
    }
}
