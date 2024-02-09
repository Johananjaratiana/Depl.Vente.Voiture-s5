package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.Transmission;
import com.vente.voiture.crud.service.TransmissionService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/transmissions")
public class TransmissionController {
    @Autowired
    private TransmissionService transmissionService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createTransmission(@RequestBody Transmission Transmission, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(transmissionService.save(Transmission));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAlltransmission() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(transmissionService.getAlltransmission());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPagetransmission( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(transmissionService.getAllTransmission(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getTransmissionById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(transmissionService.getTransmissionById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateTransmission(@PathVariable Long id, @RequestBody Transmission TransmissionDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(transmissionService.updateTransmission(id, TransmissionDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteTransmission(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            transmissionService.deleteTransmission(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
