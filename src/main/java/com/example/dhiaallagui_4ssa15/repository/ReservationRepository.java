package com.example.dhiaallagui_4ssa15.repository;

import com.example.dhiaallagui_4ssa15.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
