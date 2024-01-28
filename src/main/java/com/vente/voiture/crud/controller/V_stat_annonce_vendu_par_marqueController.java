package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_stat_annonce_vendu_par_marque;
import java.util.*;
import com.vente.voiture.crud.service.V_stat_annonce_vendu_par_marqueService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_stat_annonce_vendu_par_marques")
public class V_stat_annonce_vendu_par_marqueController {
    @Autowired
    private V_stat_annonce_vendu_par_marqueService v_stat_annonce_vendu_par_marqueService;

    @GetMapping
    public List<V_stat_annonce_vendu_par_marque> getAllV_stat_annonce_vendu_par_marque() {
        return v_stat_annonce_vendu_par_marqueService.getAllV_stat_annonce_vendu_par_marque();
    }

    @GetMapping("/{id}")
    public Optional<V_stat_annonce_vendu_par_marque> getV_stat_annonce_vendu_par_marqueById(@PathVariable Long id) {
        return v_stat_annonce_vendu_par_marqueService.getV_stat_annonce_vendu_par_marqueById(id);
    }


    @GetMapping("marque/{id_marque}")
    public Response getV_stat_annonce_vendu_par_marqueByIdMarque(@PathVariable Integer id_marque) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_stat_annonce_vendu_par_marqueService.getV_stat_annonce_vendu_par_marqueByIdMarque(id_marque));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
