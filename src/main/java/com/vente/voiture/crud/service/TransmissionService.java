package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Transmission;
import com.vente.voiture.crud.repository.TransmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
    public List<Transmission> getAlltransmission() {
        return transmissionRepository.findAll();
    }

    // Read
    public Page<Transmission> getAllTransmission(Pageable pageable) {
        return transmissionRepository.findAll(pageable);
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
