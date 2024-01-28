package com.vente.voiture.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.HttpHeaders;

import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MessageService messageService;

    @GetMapping("/not_seen_message")
    public Response GetNotSeenMessage(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            response.setDataOnSuccess(messageService.GetNotSeenMessage(users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id_other_user}")
    public Response GetMessageByTokenAndUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader, @PathVariable Integer id_other_user) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            response.setDataOnSuccess(messageService.GetMessageByTokenAndUser(users, id_other_user));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/view/{id_other_user}")
    public Response SetViewMessage(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader, @PathVariable Integer id_other_user) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            response.setDataOnSuccess(messageService.SetViewMessage(users, id_other_user));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PostMapping
    public Response SaveMessageByTokenAndUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader, @RequestBody ReceivedMessage receivedMessage) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            response.setDataOnSuccess(messageService.SaveMessageByTokenAndUser(users, receivedMessage));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
}
