package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_stat_annonce_vendu_par_marque;
import com.vente.voiture.crud.repository.V_stat_annonce_vendu_par_marqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_stat_annonce_vendu_par_marqueService {
    @Autowired
    private V_stat_annonce_vendu_par_marqueRepository v_stat_annonce_vendu_par_marqueRepository;

    // Read
    public List<V_stat_annonce_vendu_par_marque> getAllV_stat_annonce_vendu_par_marque() {
        return (List<V_stat_annonce_vendu_par_marque>) v_stat_annonce_vendu_par_marqueRepository.findAll();
    }

    // GetById
    public Optional<V_stat_annonce_vendu_par_marque> getV_stat_annonce_vendu_par_marqueById(Long id) {
        return v_stat_annonce_vendu_par_marqueRepository.findById(id);
    }

    public List<V_stat_annonce_vendu_par_marque> getV_stat_annonce_vendu_par_marqueByIdMarque(Integer IdMarque) {
        return v_stat_annonce_vendu_par_marqueRepository.findByIdMarque(IdMarque);
    }

    // Add your service methods here

}
