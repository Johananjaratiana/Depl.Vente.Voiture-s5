package com.vente.voiture.function.annonce;

import com.vente.voiture.crud.model.Couleur;
import com.vente.voiture.crud.model.Energie;
import com.vente.voiture.crud.model.Marque;
import com.vente.voiture.crud.model.Modele;
import com.vente.voiture.crud.model.Taille;
import com.vente.voiture.crud.model.Transmission;
import com.vente.voiture.crud.model.TypeAnnonce;
import com.vente.voiture.crud.model.TypeMoteur;
import com.vente.voiture.crud.model.Usage;

import java.util.List;

public class DataCreator {

    List<Marque> marque;
    List<Modele> modele;
    List<Couleur> Couleur;
    List<Taille> taille;
    List<Usage> usage;
    List<Energie> energie;
    List<Transmission> transmission;
    List<TypeAnnonce> typeAnnonce;
    List<TypeMoteur> typeMoteur;
    
    public List<Marque> getMarque() {
        return marque;
    }
    public void setMarque(List<Marque> marque) {
        this.marque = marque;
    }
    public List<Modele> getModele() {
        return modele;
    }
    public void setModele(List<Modele> modele) {
        this.modele = modele;
    }
    public List<Couleur> getCouleur() {
        return Couleur;
    }
    public void setCouleur(List<Couleur> couleur) {
        Couleur = couleur;
    }
    public List<Taille> getTaille() {
        return taille;
    }
    public void setTaille(List<Taille> taille) {
        this.taille = taille;
    }
    public List<Usage> getUsage() {
        return usage;
    }
    public void setUsage(List<Usage> usage) {
        this.usage = usage;
    }
    public List<Energie> getEnergie() {
        return energie;
    }
    public void setEnergie(List<Energie> energie) {
        this.energie = energie;
    }
    public List<Transmission> getTransmission() {
        return transmission;
    }
    public void setTransmission(List<Transmission> transmission) {
        this.transmission = transmission;
    }
    public List<TypeAnnonce> getTypeAnnonce() {
        return typeAnnonce;
    }
    public void setTypeAnnonce(List<TypeAnnonce> typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
    }
    public List<TypeMoteur> getTypeMoteur() {
        return typeMoteur;
    }
    public void setTypeMoteur(List<TypeMoteur> typeMoteur) {
        this.typeMoteur = typeMoteur;
    }

    
}
