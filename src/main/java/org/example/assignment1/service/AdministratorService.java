package org.example.assignment1.service;

// Author: Ali Faisal (ID: 415002117)
// Service: AdministratorService

import org.example.assignment1.model.Administrator;
import org.example.assignment1.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository adminRepository;

    public List<Administrator> getAllAdministrators() {
        return adminRepository.findAll();
    }

    public Optional<Administrator> getAdministratorById(Long id) {
        return adminRepository.findById(id);
    }

    public Optional<Administrator> getAdministratorByAdminId(String adminId) {
        return adminRepository.findByAdminId(adminId);
    }

    public List<Administrator> searchByDepartment(String department) {
        return adminRepository.findByDepartment(department);
    }

    @Transactional
    public Administrator createAdministrator(Administrator admin) {
        return adminRepository.save(admin);
    }

    @Transactional
    public Administrator updateAdministrator(Long id, Administrator updatedAdmin) {
        Optional<Administrator> existing = adminRepository.findById(id);
        if (existing.isPresent()) {
            Administrator a = existing.get();
            a.setAdminId(updatedAdmin.getAdminId());
            a.setAccessLevel(updatedAdmin.getAccessLevel());
            a.setDepartment(updatedAdmin.getDepartment());
            return adminRepository.save(a);
        }
        return null;
    }

    @Transactional
    public boolean deleteAdministrator(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
