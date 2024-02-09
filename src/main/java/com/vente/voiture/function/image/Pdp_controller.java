package com.vente.voiture.function.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import com.vente.voiture.crud.model.Pdp;
import com.vente.voiture.crud.service.PdpService;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/pdp")
public class Pdp_controller {
    @Autowired
    private PdpService pdpService;

    @Autowired
    private ImageService imageService;

    @PostMapping("/new_user")
    public Response createPdp(@RequestBody Pdp pdp) {
        Response response = new Response();
        try{
            pdp.setImage(imageService.upload(pdp.getImage()));
            response.setDataOnSuccess(pdpService.save(pdp));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    
}
