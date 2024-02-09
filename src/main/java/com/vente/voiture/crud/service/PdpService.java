package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Pdp;
import com.vente.voiture.crud.repository.PdpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PdpService {
    @Autowired
    private PdpRepository pdpRepository;

    // Create
    public Pdp save(Pdp pdp) {
        return pdpRepository.save(pdp);
    }

    // Read
    public List<Pdp> getAllpdp() {
        return pdpRepository.findAll();
    }

    // Read
    public Page<Pdp> getAllPdp(Pageable pageable) {
        return pdpRepository.findAll(pageable);
    }

    // GetById
    public Optional<Pdp> getPdpById(Long id) {
        return pdpRepository.findById(id);
    }

    // Update
    public Pdp updatePdp(Long id, Pdp updatedPdp) {
        if (pdpRepository.existsById(id)) {
            updatedPdp.setId(id);
            return pdpRepository.save(updatedPdp);
        }
        return null; // not found
    }

    // Delete
    public void deletePdp(Long id) {
        pdpRepository.deleteById(id);
    }

    public Page<Pdp> getPdpByIdUsers(Integer IdUsers, Pageable pageable) {
        return pdpRepository.findByIdUsers(IdUsers, pageable);
    }

    // Add your service methods here

}
