package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    Reservation retrieveReservation(Long id);

    List<Reservation> retrieveAllReservations();

    void removeReservation(Long id);
}
