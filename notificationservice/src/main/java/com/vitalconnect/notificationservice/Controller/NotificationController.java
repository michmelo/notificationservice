package com.vitalconnect.notificationservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitalconnect.notificationservice.model.Notification;
import com.vitalconnect.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificationController {
    
    @Autowired
    private NotificationService service;

    @GetMapping
    public ResponseEntity<List<Notification>> getAll() {
        var lista = service.listarTodas();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @GetMapping("/receptor/{receptor}")
    public ResponseEntity<List<Notification>> getByReceptor(@PathVariable String receptor) {
        var lista = service.listarPorReceptor(receptor);
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Notification> post(@Valid @RequestBody Notification n) {
        return ResponseEntity.ok(service.crear(n));
    }
}
