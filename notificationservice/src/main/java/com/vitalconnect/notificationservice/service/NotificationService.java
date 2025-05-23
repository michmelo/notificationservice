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

    public Notification enviarCorreo(Notification correo) {
        return repo.save(correo);
    }

    public List<Notification> listarTodasLasNotificaciones() {
        return repo.findAll();
    }

    public List<Notification> listarPorUsuario(String destinatario) {
        return repo.findByReceptor(destinatario);
    }

    public boolean deleteNotification(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
