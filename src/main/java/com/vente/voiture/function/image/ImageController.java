package com.vente.voiture.function.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/images")
public class ImageController {
    
    @Autowired
    private ImageService imageService;

    @PostMapping("/save")
    public Response createPdp(@RequestBody String base64Image) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(imageService.upload(base64Image));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
    
}
