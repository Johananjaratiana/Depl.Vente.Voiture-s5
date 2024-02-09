package com.vente.voiture.function.annonce.filtre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vente.voiture.crud.model.V_annonce_complet;
import com.vente.voiture.util.SqlParams;

import java.util.List;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class FilterSelection {
    Double prix_min;
    Double prix_max;
    Integer[] marque;
    Integer[] modele;
    Integer[] energie;
    Integer[] transmission;
    Integer[] taille;
    Integer[] type_moteur;
    Integer[] couleur;
    Integer[] usage;
    Date startDate;
    Date endDate;

    public SqlParams BuildWhereStatement(){
        SqlParams sqlParams = new SqlParams();
        StringBuilder sqlWhere = sqlParams.getSqlWhere();
        ArrayList<Object> params = sqlParams.getParams();
    
        if (marque != null && marque.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" marque IN (" + String.join(",", Collections.nCopies(marque.length, "?")) + ") ");    
            params.addAll(Arrays.asList(marque));
        }
    
        if (modele != null && modele.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" modele IN (" + String.join(",", Collections.nCopies(modele.length, "?")) + ") ");    
            params.addAll(Arrays.asList(modele));
        }
    
        if (energie != null && energie.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" energie IN (" + String.join(",", Collections.nCopies(energie.length, "?")) + ") ");    
            params.addAll(Arrays.asList(energie));
        }
    
        if (transmission != null && transmission.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" transmission IN (" + String.join(",", Collections.nCopies(transmission.length, "?")) + ") ");    
            params.addAll(Arrays.asList(transmission));
        }
    
        if (taille != null && taille.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" taille IN (" + String.join(",", Collections.nCopies(taille.length, "?")) + ") ");    
            params.addAll(Arrays.asList(taille));
        }
    
        if (type_moteur != null && type_moteur.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" type_moteur IN (" + String.join(",", Collections.nCopies(type_moteur.length, "?")) + ") ");    
            params.addAll(Arrays.asList(type_moteur));
        }
    
        if (couleur != null && couleur.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" couleur IN (" + String.join(",", Collections.nCopies(couleur.length, "?")) + ") ");    
            params.addAll(Arrays.asList(couleur));
        }
    
        if (usage != null && usage.length > 0) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" usage IN (" + String.join(",", Collections.nCopies(usage.length, "?")) + ") ");    
            params.addAll(Arrays.asList(usage));
        }
        
        if (prix_min != null && prix_max != null) {
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" prix_vente BETWEEN ? AND ? ");    
            params.add(prix_min);
            params.add(prix_max);
        }

        if(startDate != null){
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" date_annonce > ? ");    
            params.add(startDate);
        }

        if(endDate != null){
            if(sqlWhere.length() > 0)sqlWhere.append(" AND ");
            sqlWhere.append(" date_annonce < ? ");    
            params.add(endDate);
        }
    
        if (sqlWhere.length() > 0) {
            sqlWhere.insert(0, " WHERE ");
        }

        return sqlParams;
    }
    
    public List<V_annonce_complet> GetAnnonceComplet(Connection connection){
        List<V_annonce_complet> result = new ArrayList<V_annonce_complet>(); 
        V_annonce_complet temp;
        try {
            SqlParams sqlParams = BuildWhereStatement();
            String sql = "SELECT * FROM v_annonce_complet" + sqlParams.getSqlWhere();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
    
            // Set the parameters for the prepared statement
            for(int index = 1; index <= sqlParams.getParams().size() ; index++) {   
              preparedStatement.setObject(index, sqlParams.getParams().get(index - 1));
            }
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                temp = new V_annonce_complet();
                temp.setId(resultSet.getLong("id"));
                temp.setIdMarque(resultSet.getInt("id_marque"));
                temp.setIdModele(resultSet.getInt("id_modele"));
                temp.setVersion(resultSet.getString("version"));
                temp.setNbPlace(resultSet.getInt("nb_place"));
                temp.setDescription(resultSet.getString("description"));
                temp.setPrixVente(resultSet.getDouble("prix_vente"));
                temp.setConsommation(resultSet.getDouble("consommation"));
                temp.setNbVitesse(resultSet.getInt("nb_vitesse"));
                temp.setIdTypeMoteur(resultSet.getInt("id_type_moteur"));
                temp.setPuissance(resultSet.getInt("puissance"));
                temp.setIdTypeAnnonce(resultSet.getInt("id_type_annonce"));
                temp.setDateAnnonce(resultSet.getDate("date_annonce"));
                temp.setStatus(resultSet.getInt("status"));
                temp.setIdUsers(resultSet.getInt("id_users"));
                temp.setIdEnergie(resultSet.getInt("id_energie"));
                temp.setIdTransmission(resultSet.getInt("id_transmission"));
                temp.setIdUsage(resultSet.getInt("id_usage"));
                temp.setIdTaille(resultSet.getInt("id_taille"));
                temp.setKmEffectue(resultSet.getDouble("km_effectue"));
                temp.setIdCouleur(resultSet.getInt("id_couleur"));
                temp.setNumero(resultSet.getString("numero"));
                temp.setNomMarque(resultSet.getString("nom_marque"));
                temp.setNomModele(resultSet.getString("nom_modele"));
                temp.setNomTypeMoteur(resultSet.getString("nom_type_moteur"));
                temp.setNomTypeAnnonce(resultSet.getString("nom_type_annonce"));
                temp.setCommissionTypeAnnonce(resultSet.getDouble("commission_type_annonce"));
                temp.setNiveauTypeAnnonce(resultSet.getInt("niveau_type_annonce"));
                temp.setNomUsers(resultSet.getString("nom_users"));
                temp.setPrenomUsers(resultSet.getString("prenom_users"));
                temp.setEmailUsers(resultSet.getString("email_users"));
                temp.setTelephoneUsers(resultSet.getString("telephone_users"));
                temp.setNomEnergie(resultSet.getString("nom_energie"));
                temp.setNomTransmission(resultSet.getString("nom_transmission"));
                temp.setNomUsage(resultSet.getString("nom_usage"));
                temp.setNomTaille(resultSet.getString("nom_taille"));
                temp.setEtatCarrosserie(resultSet.getInt("etat_carrosserie"));
                temp.setEtatSiege(resultSet.getInt("etat_siege"));
                temp.setEtatTableauBord(resultSet.getInt("etat_tableau_bord"));
                temp.setEtatMoteur(resultSet.getInt("etat_moteur"));
                temp.setEtatFreinage(resultSet.getInt("etat_freinage"));
                temp.setEtatTransmission(resultSet.getInt("etat_transmission"));
                temp.setEtatPneu(resultSet.getInt("etat_pneu"));
                temp.setEtatElectronique(resultSet.getInt("etat_electronique"));
                temp.setEtatSuspension(resultSet.getInt("etat_suspension"));
                temp.setNomCouleur(resultSet.getString("nom_couleur"));
                temp.setRgbCouleur(resultSet.getString("rgb_couleur"));
                result.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Double getPrix_min() {
        return prix_min;
    }

    public void setPrix_min(Double prix_min) {
        this.prix_min = prix_min;
    }

    public Double getPrix_max() {
        return prix_max;
    }

    public void setPrix_max(Double prix_max) {
        this.prix_max = prix_max;
    }

    public Integer[] getMarque() {
        return marque;
    }

    public void setMarque(Integer[] marque) {
        this.marque = marque;
    }

    public Integer[] getModele() {
        return modele;
    }

    public void setModele(Integer[] modele) {
        this.modele = modele;
    }

    public Integer[] getEnergie() {
        return energie;
    }

    public void setEnergie(Integer[] energie) {
        this.energie = energie;
    }

    public Integer[] getTransmission() {
        return transmission;
    }

    public void setTransmission(Integer[] transmission) {
        this.transmission = transmission;
    }

    public Integer[] getTaille() {
        return taille;
    }

    public void setTaille(Integer[] taille) {
        this.taille = taille;
    }

    public Integer[] getType_moteur() {
        return type_moteur;
    }

    public void setType_moteur(Integer[] type_moteur) {
        this.type_moteur = type_moteur;
    }

    public Integer[] getCouleur() {
        return couleur;
    }

    public void setCouleur(Integer[] couleur) {
        this.couleur = couleur;
    }

    public Integer[] getUsage() {
        return usage;
    }

    public void setUsage(Integer[] usage) {
        this.usage = usage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
