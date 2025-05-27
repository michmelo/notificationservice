package com.vitalconnect.notificationservice.service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitalconnect.notificationservice.model.Notification;
import com.vitalconnect.notificationservice.repository.NotificationRepository;

@Service
@Transactional
public class NotificationService {

    private final NotificationRepository repo;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.repo = notificationRepository;
    }

    public Notification crearNotificacion(Notification notificacion) {
        return repo.save(notificacion);
    }

    public List<Notification> obtenerTodas() {
        return repo.findAll();
    }

    public List<Notification> obtenerPorDestinatario(String destinatario) {
        return repo.findByDestinatario(destinatario);
    }

    public boolean eliminarNotificacion(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
