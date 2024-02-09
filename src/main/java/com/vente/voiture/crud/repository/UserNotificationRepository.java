package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.UserNotification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
    @Query("SELECT tbl FROM user_notification tbl WHERE tbl.IdUsers = ?1")
   Page<UserNotification> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM user_notification tbl")
   Page<UserNotification> findAll(Pageable pageable);

}
