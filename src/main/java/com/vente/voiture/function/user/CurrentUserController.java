
package com.vente.voiture.function.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vente.voiture.crud.model.V_annonce_complet;
import com.vente.voiture.crud.service.V_annonce_completService;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.structure.Response;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/current_users")
public class CurrentUserController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private V_annonce_completService v_annonce_completService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/annonce_complets")
    public Response GetDataCreationOfAnnonce(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            List<V_annonce_complet> list = v_annonce_completService.getV_annonce_completByIdUsers(users.getId().intValue());
            
            response.setDataOnSuccess(list);
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
    
}
