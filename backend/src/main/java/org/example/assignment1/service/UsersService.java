package org.example.assignment1.service;

// Author: Syed Rayan Hashmi (ID: 764000072)
// Service: UsersService

import org.example.assignment1.model.Users;
import org.example.assignment1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    public List<Users> searchByName(String name) {
        return usersRepository.findByNameContaining(name);
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public List<Users> getUsersByRole(String role) {
        return usersRepository.findByRole(role);
    }

    @Transactional
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    @Transactional
    public Users updateUser(Long id, Users updatedUser) {
        Optional<Users> existing = usersRepository.findById(id);
        if (existing.isPresent()) {
            Users u = existing.get();
            u.setName(updatedUser.getName());
            u.setEmail(updatedUser.getEmail());
            u.setRole(updatedUser.getRole());
            return usersRepository.save(u);
        }
        return null;
    }

    @Transactional
    public boolean deleteUser(Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
