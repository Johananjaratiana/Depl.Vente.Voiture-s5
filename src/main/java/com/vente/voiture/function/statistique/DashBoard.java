package com.vente.voiture.function.statistique;

import com.vente.voiture.crud.model.V_best_user;
import com.vente.voiture.crud.model.V_latest_annonce_vendu;
import com.vente.voiture.crud.model.V_nombre_important;
import com.vente.voiture.crud.model.V_stat_annonce_vendu_par_marque;
import com.vente.voiture.crud.model.V_stat_current_month;

import java.util.List;

public class DashBoard {
    List<V_stat_current_month> v_stat_current_month;
    List<V_stat_annonce_vendu_par_marque> v_stat_annonce_vendu_par_marque;
    List<V_nombre_important> v_nombre_important;
    List<V_latest_annonce_vendu> v_latest_annonce_vendu;
    List<V_best_user> v_best_user;
    
    public List<V_stat_current_month> getV_stat_current_month() {
        return v_stat_current_month;
    }
    public void setV_stat_current_month(List<V_stat_current_month> v_stat_current_month) {
        this.v_stat_current_month = v_stat_current_month;
    }
    public List<V_stat_annonce_vendu_par_marque> getV_stat_annonce_vendu_par_marque() {
        return v_stat_annonce_vendu_par_marque;
    }
    public void setV_stat_annonce_vendu_par_marque(List<V_stat_annonce_vendu_par_marque> v_stat_annonce_vendu_par_marque) {
        this.v_stat_annonce_vendu_par_marque = v_stat_annonce_vendu_par_marque;
    }
    public List<V_nombre_important> getV_nombre_important() {
        return v_nombre_important;
    }
    public void setV_nombre_important(List<V_nombre_important> v_nombre_important) {
        this.v_nombre_important = v_nombre_important;
    }
    public List<V_latest_annonce_vendu> getV_latest_annonce_vendu() {
        return v_latest_annonce_vendu;
    }
    public void setV_latest_annonce_vendu(List<V_latest_annonce_vendu> v_latest_annonce_vendu) {
        this.v_latest_annonce_vendu = v_latest_annonce_vendu;
    }
    public List<V_best_user> getV_best_user() {
        return v_best_user;
    }
    public void setV_best_user(List<V_best_user> v_best_user) {
        this.v_best_user = v_best_user;
    }
    
    
}
