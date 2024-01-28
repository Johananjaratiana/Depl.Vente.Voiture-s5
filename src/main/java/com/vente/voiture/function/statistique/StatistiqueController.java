package com.vente.voiture.function.statistique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vente.voiture.crud.service.V_best_userService;
import com.vente.voiture.crud.service.V_latest_annonce_venduService;
import com.vente.voiture.crud.service.V_nombre_importantService;
import com.vente.voiture.crud.service.V_stat_annonce_vendu_par_marqueService;
import com.vente.voiture.crud.service.V_stat_current_monthService;
import com.vente.voiture.ws.structure.Response;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/statistiques")
public class StatistiqueController {

    @Autowired
    private V_stat_current_monthService v_stat_current_monthService;

    @Autowired
    private V_stat_annonce_vendu_par_marqueService v_annonce_vendu_par_marqueService;

    @Autowired
    private V_nombre_importantService v_nombre_importantService;

    @Autowired
    private V_latest_annonce_venduService v_latest_annonce_venduService;

    @Autowired
    private V_best_userService v_best_userService;

    @GetMapping("/{year}")
    public Response getAnnonceById(@PathVariable Integer year) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(StatByYear.GetStatByYear(year));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/dashboard")
    public Response GetStatOnDashBoard() {
        Response response = new Response();
        try{
            DashBoard dashBoard = new DashBoard();
            dashBoard.setV_stat_current_month(v_stat_current_monthService.getAllV_stat_current_month());
            dashBoard.setV_stat_annonce_vendu_par_marque(v_annonce_vendu_par_marqueService.getAllV_stat_annonce_vendu_par_marque());
            dashBoard.setV_nombre_important(v_nombre_importantService.getAllV_nombre_important());
            dashBoard.setV_latest_annonce_vendu(v_latest_annonce_venduService.getAllV_latest_annonce_vendu());
            dashBoard.setV_best_user(v_best_userService.getAllV_best_user());
            
            response.setDataOnSuccess(dashBoard);
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
    
}
