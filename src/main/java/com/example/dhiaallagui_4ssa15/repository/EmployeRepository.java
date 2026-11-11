package com.example.dhiaallagui_4ssa15.repository;

import com.example.dhiaallagui_4ssa15.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
