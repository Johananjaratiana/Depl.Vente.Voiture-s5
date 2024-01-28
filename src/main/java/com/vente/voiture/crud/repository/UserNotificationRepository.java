package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.UserNotification;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
    @Query("SELECT pa FROM user_notification pa WHERE pa.IdUsers = ?1")
   List<UserNotification> findByIdUsers(Integer IdUsers);

}
