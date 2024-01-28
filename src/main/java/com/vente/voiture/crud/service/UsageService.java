package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Usage;
import com.vente.voiture.crud.repository.UsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class UsageService {
    @Autowired
    private UsageRepository usageRepository;

    // Create
    public Usage save(Usage usage) {
        return usageRepository.save(usage);
    }

    // Read
    public List<Usage> getAllUsage() {
        return (List<Usage>) usageRepository.findAll();
    }

    // GetById
    public Optional<Usage> getUsageById(Long id) {
        return usageRepository.findById(id);
    }

    // Update
    public Usage updateUsage(Long id, Usage updatedUsage) {
        if (usageRepository.existsById(id)) {
            updatedUsage.setId(id);
            return usageRepository.save(updatedUsage);
        }
        return null; // not found
    }

    // Delete
    public void deleteUsage(Long id) {
        usageRepository.deleteById(id);
    }

    // Add your service methods here

}
