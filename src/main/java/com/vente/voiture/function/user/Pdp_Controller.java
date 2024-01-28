package com.vente.voiture.function.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vente.voiture.crud.model.Pdp;
import com.vente.voiture.crud.service.PdpService;
import com.vente.voiture.function.image.ImageService;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/pdp_user")
public class Pdp_Controller {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PdpService pdpService;

    @Autowired
    private ImageService imageService;

    @PostMapping
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

    @PostMapping("/current_users")
    public Response GetAllPdpsCurrentUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            response.setDataOnSuccess(pdpService.getPdpByIdUsers(users.getId().intValue()));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
    
}
