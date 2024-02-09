package com.vente.voiture.function.statistique;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.vente.voiture.ws.services.DatabaseConnection;

public class StatByYear {
    Integer month;
    Integer nb_annonce;
    Integer nb_annonce_vendu;
    Double prix_mois_actuelle;
    Double commission_mois_actuelle;
    Integer year;


    public static List<StatByYear> GetStatByYear(Integer year)throws Exception{
        String request_4_parameter = ""
            + "WITH all_months AS ( "
            + "    SELECT generate_series(1, 12) AS month "
            + ") "
            + " "
            + "SELECT "
            + "    all_months.month AS month, "
            + "    COALESCE(max(v_count_annonce_current_month.nb_annonce), 0) AS nb_annonce, "
            + "    COALESCE(max(v_count_annonce_vendu_current_month.nb_annonce_vendu), 0) AS nb_annonce_vendu, "
            + "    COALESCE(sum(a.prix_vente), 0) AS prix_mois_actuelle, "
            + "    COALESCE(sum(a.prix_vente * ta.commission), 0) AS commission_mois_actuelle, "
            + "    ? AS year "
            + "FROM "
            + "    all_months "
            + "LEFT JOIN "
            + "    (SELECT "
            + "        EXTRACT(month FROM date_annonce) AS month, "
            + "        COUNT(*) AS nb_annonce "
            + "     FROM "
            + "        annonce "
            + "     WHERE "
            + "        EXTRACT(year FROM date_annonce) = ? "
            + "     GROUP BY "
            + "        EXTRACT(month FROM date_annonce) "
            + "    ) v_count_annonce_current_month ON all_months.month = v_count_annonce_current_month.month "
            + " "
            + "LEFT JOIN "
            + "    (SELECT "
            + "        EXTRACT(month FROM date_annonce) AS month, "
            + "        COUNT(*) AS nb_annonce_vendu "
            + "     FROM "
            + "        annonce "
            + "     WHERE "
            + "        status = 20 "
            + "        AND EXTRACT(year FROM date_annonce) = ? "
            + "     GROUP BY "
            + "        EXTRACT(month FROM date_annonce) "
            + "    ) v_count_annonce_vendu_current_month ON all_months.month = v_count_annonce_vendu_current_month.month "
            + " "
            + "LEFT JOIN "
            + "    annonce a ON all_months.month = EXTRACT(month FROM a.date_annonce) AND a.status = 20 AND EXTRACT(year FROM a.date_annonce) = ? "
            + "LEFT JOIN "
            + "    type_annonce ta ON a.id_type_annonce = ta.id "
            + "GROUP BY "
            + "    all_months.month";

        List<StatByYear> list_statByYear = new ArrayList<StatByYear>();
        StatByYear statByYear = null;
        try {
            try (Connection connection = DatabaseConnection.GetConnection()) {
                String sql = request_4_parameter;
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1, year);
                preparedStatement.setInt(2, year);
                preparedStatement.setInt(3, year);
                preparedStatement.setInt(4, year);

                // System.out.println(preparedStatement.toString());

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    statByYear = new StatByYear();
                    statByYear.setMonth(resultSet.getInt("month"));
                    statByYear.setNb_annonce(resultSet.getInt("nb_annonce"));
                    statByYear.setNb_annonce_vendu(resultSet.getInt("nb_annonce_vendu"));
                    statByYear.setPrix_mois_actuelle(resultSet.getDouble("prix_mois_actuelle"));
                    statByYear.setCommission_mois_actuelle(resultSet.getDouble("commission_mois_actuelle"));
                    statByYear.setYear(resultSet.getInt("year"));
                    list_statByYear.add(statByYear);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return list_statByYear;
    }


    public Integer getMonth() {
        return month;
    }


    public void setMonth(Integer month) {
        this.month = month;
    }


    public Integer getNb_annonce() {
        return nb_annonce;
    }


    public void setNb_annonce(Integer nb_annonce) {
        this.nb_annonce = nb_annonce;
    }


    public Integer getNb_annonce_vendu() {
        return nb_annonce_vendu;
    }


    public void setNb_annonce_vendu(Integer nb_annonce_vendu) {
        this.nb_annonce_vendu = nb_annonce_vendu;
    }


    public Double getPrix_mois_actuelle() {
        return prix_mois_actuelle;
    }


    public void setPrix_mois_actuelle(Double prix_mois_actuelle) {
        this.prix_mois_actuelle = prix_mois_actuelle;
    }


    public Double getCommission_mois_actuelle() {
        return commission_mois_actuelle;
    }


    public void setCommission_mois_actuelle(Double commission_mois_actuelle) {
        this.commission_mois_actuelle = commission_mois_actuelle;
    }


    public Integer getYear() {
        return year;
    }


    public void setYear(Integer year) {
        this.year = year;
    }
    
}
