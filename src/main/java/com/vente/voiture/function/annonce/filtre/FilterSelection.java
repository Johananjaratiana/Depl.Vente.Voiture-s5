package com.vente.voiture.function.annonce.filtre;

import java.sql.Connection;
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

    public SqlParams BuildWhereStatement(){
        SqlParams sqlParams = new SqlParams();
        StringBuilder sqlWhere = sqlParams.getSqlWhere();
        ArrayList<Object> params = sqlParams.getParams();
    
        if (marque != null && marque.length > 0) {
            sqlWhere.append(" marque IN (" + String.join(",", Collections.nCopies(marque.length, "?")) + ") ");    
            params.addAll(Arrays.asList(marque));
        }
    
        if (modele != null && modele.length > 0) {
            sqlWhere.append(" AND modele IN (" + String.join(",", Collections.nCopies(modele.length, "?")) + ") ");    
            params.addAll(Arrays.asList(modele));
        }
    
        if (energie != null && energie.length > 0) {
            sqlWhere.append(" AND energie IN (" + String.join(",", Collections.nCopies(energie.length, "?")) + ") ");    
            params.addAll(Arrays.asList(energie));
        }
    
        if (transmission != null && transmission.length > 0) {
            sqlWhere.append(" AND transmission IN (" + String.join(",", Collections.nCopies(transmission.length, "?")) + ") ");    
            params.addAll(Arrays.asList(transmission));
        }
    
        if (taille != null && taille.length > 0) {
            sqlWhere.append(" AND taille IN (" + String.join(",", Collections.nCopies(taille.length, "?")) + ") ");    
            params.addAll(Arrays.asList(taille));
        }
    
        if (type_moteur != null && type_moteur.length > 0) {
            sqlWhere.append(" AND type_moteur IN (" + String.join(",", Collections.nCopies(type_moteur.length, "?")) + ") ");    
            params.addAll(Arrays.asList(type_moteur));
        }
    
        if (couleur != null && couleur.length > 0) {
            sqlWhere.append(" AND couleur IN (" + String.join(",", Collections.nCopies(couleur.length, "?")) + ") ");    
            params.addAll(Arrays.asList(couleur));
        }
    
        if (usage != null && usage.length > 0) {
            sqlWhere.append(" AND usage IN (" + String.join(",", Collections.nCopies(usage.length, "?")) + ") ");    
            params.addAll(Arrays.asList(usage));
        }
        
        if (prix_min != null && prix_max != null) {
            sqlWhere.append(" AND prix BETWEEN ? AND ? ");    
            params.add(prix_min);
            params.add(prix_max);
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
    
}
