package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.UserNotification;
import com.vente.voiture.crud.repository.UserNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationService {
    @Autowired
    private UserNotificationRepository user_notificationRepository;

    // Create
    public UserNotification save(UserNotification user_notification) {
        return user_notificationRepository.save(user_notification);
    }

    // Read
    public List<UserNotification> getAllUserNotification() {
        return (List<UserNotification>) user_notificationRepository.findAll();
    }

    // GetById
    public Optional<UserNotification> getUserNotificationById(Long id) {
        return user_notificationRepository.findById(id);
    }

    // Update
    public UserNotification updateUserNotification(Long id, UserNotification updatedUserNotification) {
        if (user_notificationRepository.existsById(id)) {
            updatedUserNotification.setId(id);
            return user_notificationRepository.save(updatedUserNotification);
        }
        return null; // not found
    }

    // Delete
    public void deleteUserNotification(Long id) {
        user_notificationRepository.deleteById(id);
    }

    public List<UserNotification> getUserNotificationByIdUsers(Integer IdUsers) {
        return user_notificationRepository.findByIdUsers(IdUsers);
    }

    // Add your service methods here

}
