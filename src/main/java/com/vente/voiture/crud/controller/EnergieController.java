package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.Energie;
import com.vente.voiture.crud.service.EnergieService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/energies")
public class EnergieController {
    @Autowired
    private EnergieService energieService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createEnergie(@RequestBody Energie Energie, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(energieService.save(Energie));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllenergie() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(energieService.getAllenergie());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageenergie( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(energieService.getAllEnergie(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getEnergieById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(energieService.getEnergieById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateEnergie(@PathVariable Long id, @RequestBody Energie EnergieDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(energieService.updateEnergie(id, EnergieDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteEnergie(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            energieService.deleteEnergie(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
