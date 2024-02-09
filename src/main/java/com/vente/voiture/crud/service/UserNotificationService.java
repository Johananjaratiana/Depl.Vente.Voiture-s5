package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.UserNotification;
import com.vente.voiture.crud.repository.UserNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
    public List<UserNotification> getAlluser_notification() {
        return user_notificationRepository.findAll();
    }

    // Read
    public Page<UserNotification> getAllUserNotification(Pageable pageable) {
        return user_notificationRepository.findAll(pageable);
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

    public Page<UserNotification> getUserNotificationByIdUsers(Integer IdUsers, Pageable pageable) {
        return user_notificationRepository.findByIdUsers(IdUsers, pageable);
    }

    // Add your service methods here

}
