package com.example.dhiaallagui_4ssa15.controller;

import com.example.dhiaallagui_4ssa15.entity.Reservation;
import com.example.dhiaallagui_4ssa15.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        if (reservation.getIdReservation() == null || reservationService.retrieveReservation(reservation.getIdReservation()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> retrieveReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.retrieveReservation(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable Long id) {
        if (reservationService.retrieveReservation(id) == null) {
            return ResponseEntity.notFound().build();
        }
        reservationService.removeReservation(id);
        return ResponseEntity.ok().build();
    }
}
