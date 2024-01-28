package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Transmission;
import com.vente.voiture.crud.repository.TransmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class TransmissionService {
    @Autowired
    private TransmissionRepository transmissionRepository;

    // Create
    public Transmission save(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    // Read
    public List<Transmission> getAllTransmission() {
        return (List<Transmission>) transmissionRepository.findAll();
    }

    // GetById
    public Optional<Transmission> getTransmissionById(Long id) {
        return transmissionRepository.findById(id);
    }

    // Update
    public Transmission updateTransmission(Long id, Transmission updatedTransmission) {
        if (transmissionRepository.existsById(id)) {
            updatedTransmission.setId(id);
            return transmissionRepository.save(updatedTransmission);
        }
        return null; // not found
    }

    // Delete
    public void deleteTransmission(Long id) {
        transmissionRepository.deleteById(id);
    }

    // Add your service methods here

}
