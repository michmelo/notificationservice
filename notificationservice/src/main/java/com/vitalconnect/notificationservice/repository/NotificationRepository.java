package com.vitalconnect.notificationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitalconnect.notificationservice.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{
    List<Notification> findByReceptor(String receptor);
}
