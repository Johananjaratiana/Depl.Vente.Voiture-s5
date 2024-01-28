package com.vente.voiture.ws.security.user;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    // Create
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    // Read
    public List<Users> getAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    // GetById
    public Optional<Users> getUsersById(Long id) {
        return usersRepository.findById(id);
    }

    // Update
    public Users updateUsers(Long id, Users updatedUsers) {
        if (usersRepository.existsById(id)) {
            updatedUsers.setId(id);
            return usersRepository.save(updatedUsers);
        }
        return null; // not found
    }

    // Delete
    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }
    // Add your service methods here

}
