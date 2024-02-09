package com.vente.voiture.function.annonce.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnnonceCompletMaterializedService {
    @Autowired
    private AnnonceCompletMaterializedRepository annonceCompletRepository;
    
    public Page<AnnonceCompletMaterializedView> search(String searchTerm, Pageable pageable) {
        Page<AnnonceCompletMaterializedView> answer = annonceCompletRepository.fullTextSearch(searchTerm, pageable);
        return answer;
    }
}


