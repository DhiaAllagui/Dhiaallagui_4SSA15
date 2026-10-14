package com.example.dhiaallagui_4ssa15.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;
    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne
    @ToString.Exclude
    private Agence agence;

    @ManyToMany
    @ToString.Exclude
    private List<Equipement> equipements;

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude
    private List<Maintenance> maintenances;
}
