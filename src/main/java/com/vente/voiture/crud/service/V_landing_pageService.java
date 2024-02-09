package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_landing_page;
import com.vente.voiture.crud.repository.V_landing_pageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_landing_pageService {
    @Autowired
    private V_landing_pageRepository v_landing_pageRepository;

    // Read
    public List<V_landing_page> getAllV_landing_page() {
        return v_landing_pageRepository.findAll();
    }

    // Read
    public Page<V_landing_page> getAllV_landing_page(Pageable pageable) {
        return v_landing_pageRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_landing_page> getV_landing_pageById(Long id) {
        return v_landing_pageRepository.findById(id);
    }

    // Add your service methods here

}
