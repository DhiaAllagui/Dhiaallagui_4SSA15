package com.example.dhiaallagui_4ssa15.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    @ManyToOne
    @ToString.Exclude
    private Vehicule vehicule;

    @ManyToOne
    @ToString.Exclude
    private Client client;

    @OneToOne(mappedBy = "reservation")
    @ToString.Exclude
    private Contrat contrat;
}
