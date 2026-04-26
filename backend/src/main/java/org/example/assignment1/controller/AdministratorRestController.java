package org.example.assignment1.controller;

// Author: Ali Faisal (ID: 415002117)
// REST Controller: AdministratorRestController

import org.example.assignment1.model.Administrator;
import org.example.assignment1.service.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorRestController {

    private final AdministratorService adminService;

    public AdministratorRestController(AdministratorService adminService) {
        this.adminService = adminService;
    }

    // GET /api/administrators — get all
    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        try {
            return ResponseEntity.ok(adminService.getAllAdministrators());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET /api/administrators/{id} — get one by ID
    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long id) {
        try {
            Optional<Administrator> admin = adminService.getAdministratorById(id);
            if (admin.isPresent()) {
                return new ResponseEntity<>(admin.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET /api/administrators/search?department=xxx — search by department
    @GetMapping("/search")
    public ResponseEntity<List<Administrator>> searchAdministrators(@RequestParam String department) {
        try {
            return ResponseEntity.ok(adminService.searchByDepartment(department));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // POST /api/administrators — create new
    @PostMapping
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator admin) {
        try {
            Administrator created = adminService.createAdministrator(admin);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT /api/administrators/{id} — full update
    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long id, @RequestBody Administrator admin) {
        try {
            Administrator updated = adminService.updateAdministrator(id, admin);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE /api/administrators/{id} — delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
        try {
            return adminService.deleteAdministrator(id)
                    ? ResponseEntity.noContent().build()
                    : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
