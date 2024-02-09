package com.vente.voiture.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vente.voiture.crud.model.UserNotification;
import com.vente.voiture.crud.service.UserNotificationService;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/notification")
public class NotificationController {
    
    @Autowired
    FirebaseMessagingService firebaseMessagingService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UsersService usersService;

    @Autowired
    UserNotificationService userNotificationService;

    @PostMapping("/xposdff_adfvqepovuqadfae;lka;aiq[pvalgkvlqn")
    public String SendNotificationByToken(@RequestBody NotificationMessage notificationMessage){
        return firebaseMessagingService.SendNotificationByToken(notificationMessage);
    }

    @PostMapping("/send_by_current_user")
    public Response SendRealNotificationMessage(@RequestBody NotificationMessage notificationMessage, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            Integer recipientId = Integer.parseInt(notificationMessage.getRecipientToken());
            Page<UserNotification> pageUserNotifications= userNotificationService.getUserNotificationByIdUsers(recipientId, PageRequest.of(0, 10));
            List<UserNotification> userNotifications = pageUserNotifications.toList();

            if(userNotifications.size() == 0){
                throw new Exception("Le récépteur ne peut pas recevoir la notification de votre message pour le moment.");
            } else {
                notificationMessage.setTitle(users.getPrenom() + " vous a envoyé un message.");
                notificationMessage.setRecipientToken(userNotifications.get(0).getToken());
                String status = firebaseMessagingService.SendNotificationByToken(notificationMessage);
                response.setDataOnSuccess(status);
            }
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
