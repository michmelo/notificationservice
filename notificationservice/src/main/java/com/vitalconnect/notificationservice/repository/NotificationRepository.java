package com.vitalconnect.notificationservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vitalconnect.notificationservice.model.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{
    List<Notification> findByDestinatario(String receptor);
}
