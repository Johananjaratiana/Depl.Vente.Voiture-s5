package com.vente.voiture.function.annonce.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vente.voiture.crud.model.V_annonce_complet;
import com.vente.voiture.util.SqlParams;
import com.vente.voiture.ws.security.user.Users;
import java.util.List;
import java.util.ArrayList;

public class SearchSelection {

    String marque_modele;

    public SqlParams BuildWhereStatement(){
        SqlParams sqlParams = new SqlParams();
        StringBuilder sqlWhere = sqlParams.getSqlWhere();
        ArrayList<Object> params = sqlParams.getParams();
            
        if (marque_modele != null && marque_modele.length() > 0) {
            sqlWhere.append(" nom_marque = ? AND nom modele = ? ");    
            params.add(marque_modele);
            params.add(marque_modele);
        }

        if (sqlWhere.length() > 0) {
            sqlWhere.insert(0, " WHERE ");
        }
        return sqlParams;
    }
    
    public List<V_annonce_complet> GetAnnonceComplet(Users users, Connection connection){
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
