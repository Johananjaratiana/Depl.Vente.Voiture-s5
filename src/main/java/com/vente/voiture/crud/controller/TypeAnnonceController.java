package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.TypeAnnonce;
import com.vente.voiture.crud.service.TypeAnnonceService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/type_annonces")
public class TypeAnnonceController {
    @Autowired
    private TypeAnnonceService type_annonceService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createTypeAnnonce(@RequestBody TypeAnnonce TypeAnnonce, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(type_annonceService.save(TypeAnnonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllTypeAnnonce() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(type_annonceService.getAllTypeAnnonce());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getTypeAnnonceById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(type_annonceService.getTypeAnnonceById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateTypeAnnonce(@PathVariable Long id, @RequestBody TypeAnnonce TypeAnnonceDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(type_annonceService.updateTypeAnnonce(id, TypeAnnonceDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteTypeAnnonce(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            type_annonceService.deleteTypeAnnonce(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
