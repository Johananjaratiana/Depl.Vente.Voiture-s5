package com.vente.voiture.function.annonce.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vente.voiture.crud.model.V_annonce_complet;
import com.vente.voiture.crud.repository.V_annonce_completRepository;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class AnnonceCompletMaterializedService {
    @Autowired
    private V_annonce_completRepository annonceCompletRepository;
    
    public Page<V_annonce_complet> search(String searchTerm, Pageable pageable) {
        searchTerm = ChangeAllSpaceInOneCharacter(searchTerm, "|");
        Page<V_annonce_complet> answer = annonceCompletRepository.fullTextSearch(searchTerm, pageable);
        return answer;
    }

    private static String ChangeAllSpaceInOneCharacter(String str, String replace){
        Pattern pattern = Pattern.compile("\\s+"); // Matches one or more spaces
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll(replace); // Replaces the matched spaces with the given replace string
    }
}


