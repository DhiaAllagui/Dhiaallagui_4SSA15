package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addMaintenance(Maintenance maintenance);

    Maintenance updateMaintenance(Maintenance maintenance);

    Maintenance retrieveMaintenance(Long id);

    List<Maintenance> retrieveAllMaintenances();

    void removeMaintenance(Long id);
}
