package com.vitalconnect.notificationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitalconnect.notificationservice.model.Notification;
import com.vitalconnect.notificationservice.repository.NotificationRepository;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository repo;

    public Notification crear(Notification notification) {
        return repo.save(notification);
    }

    public List<Notification> listarTodas() {
        return repo.findAll();
    }

    public List<Notification> listarPorReceptor(String receptor) {
        return repo.findByReceptor(receptor);
    }
}
