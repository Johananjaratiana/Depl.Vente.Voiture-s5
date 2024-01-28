package com.vente.voiture.function.annonce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vente.voiture.crud.service.MarqueService;
import com.vente.voiture.crud.service.ModeleService;
import com.vente.voiture.crud.service.TailleService;
import com.vente.voiture.crud.service.TransmissionService;
import com.vente.voiture.crud.service.TypeAnnonceService;
import com.vente.voiture.crud.service.TypeMoteurService;
import com.vente.voiture.crud.service.UsageService;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.structure.Response;
import com.vente.voiture.crud.model.Annonce;
import com.vente.voiture.crud.service.AnnonceService;
import com.vente.voiture.crud.service.CouleurService;
import com.vente.voiture.crud.service.EnergieService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/creation_annnonce")
public class DataCreatorController {

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MarqueService marqueService;

    @Autowired
    private ModeleService modeleService;

    @Autowired
    private CouleurService couleurService;

    @Autowired
    private TailleService tailleService;

    @Autowired
    private UsageService usageService;

    @Autowired
    private EnergieService energieService;

    @Autowired
    private TransmissionService transmissionService;

    @Autowired
    private TypeAnnonceService typeAnnonceService;

    @Autowired
    private TypeMoteurService typeMoteurService;


    @GetMapping("/data_utils")
    public Response GetDataCreationOfAnnonce() {
        Response response = new Response();
        try{
            DataCreator dataCreator = new DataCreator();
            dataCreator.setMarque(marqueService.getAllMarque());
            dataCreator.setModele(modeleService.getAllModele());
            dataCreator.setCouleur(couleurService.getAllCouleur());
            dataCreator.setTaille(tailleService.getAllTaille());
            dataCreator.setUsage(usageService.getAllUsage());
            dataCreator.setEnergie(energieService.getAllEnergie());
            dataCreator.setTransmission(transmissionService.getAllTransmission());
            dataCreator.setTypeAnnonce(typeAnnonceService.getAllTypeAnnonce());
            dataCreator.setTypeMoteur(typeMoteurService.getAllTypeMoteur());

            response.setDataOnSuccess(dataCreator);
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PostMapping("/save")
    public Response CreateAnnonce(@RequestBody Annonce annonce, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            Users users =  jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            annonce.setIdUsers(users.getId().intValue());
            response.setDataOnSuccess(annonceService.save(annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
