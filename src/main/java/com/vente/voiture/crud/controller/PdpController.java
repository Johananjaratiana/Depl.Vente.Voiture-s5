package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.Pdp;
import com.vente.voiture.crud.service.PdpService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/pdps")
public class PdpController {
    @Autowired
    private PdpService pdpService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createPdp(@RequestBody Pdp Pdp, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(pdpService.save(Pdp));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllPdp() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(pdpService.getAllPdp());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getPdpById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(pdpService.getPdpById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updatePdp(@PathVariable Long id, @RequestBody Pdp PdpDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(pdpService.updatePdp(id, PdpDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deletePdp(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            pdpService.deletePdp(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("users/{id_users}")
    public Response getPdpByIdUsers(@PathVariable Integer id_users) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(pdpService.getPdpByIdUsers(id_users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
