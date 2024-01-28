package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.TypeMoteur;
import com.vente.voiture.crud.service.TypeMoteurService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/type_moteurs")
public class TypeMoteurController {
    @Autowired
    private TypeMoteurService type_moteurService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createTypeMoteur(@RequestBody TypeMoteur TypeMoteur, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(type_moteurService.save(TypeMoteur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllTypeMoteur() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(type_moteurService.getAllTypeMoteur());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getTypeMoteurById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(type_moteurService.getTypeMoteurById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateTypeMoteur(@PathVariable Long id, @RequestBody TypeMoteur TypeMoteurDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(type_moteurService.updateTypeMoteur(id, TypeMoteurDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteTypeMoteur(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            type_moteurService.deleteTypeMoteur(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
