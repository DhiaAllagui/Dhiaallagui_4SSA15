package com.example.dhiaallagui_4ssa15.repository;

import com.example.dhiaallagui_4ssa15.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
