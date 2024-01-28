package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.PhotoAnnonce;
import com.vente.voiture.crud.service.PhotoAnnonceService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/photo_annonces")
public class PhotoAnnonceController {
    @Autowired
    private PhotoAnnonceService photo_annonceService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createPhotoAnnonce(@RequestBody PhotoAnnonce PhotoAnnonce, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(photo_annonceService.save(PhotoAnnonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllPhotoAnnonce() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(photo_annonceService.getAllPhotoAnnonce());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getPhotoAnnonceById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(photo_annonceService.getPhotoAnnonceById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updatePhotoAnnonce(@PathVariable Long id, @RequestBody PhotoAnnonce PhotoAnnonceDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(photo_annonceService.updatePhotoAnnonce(id, PhotoAnnonceDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deletePhotoAnnonce(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            photo_annonceService.deletePhotoAnnonce(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("annonce/{id_annonce}")
    public Response getPhotoAnnonceByIdAnnonce(@PathVariable Integer id_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(photo_annonceService.getPhotoAnnonceByIdAnnonce(id_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
