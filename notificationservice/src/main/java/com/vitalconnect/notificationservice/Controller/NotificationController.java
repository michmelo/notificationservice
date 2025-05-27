package com.vitalconnect.notificationservice.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vitalconnect.notificationservice.model.Notification;
import com.vitalconnect.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificationController {
    
    @Autowired
    private NotificationService service;

    @PostMapping
    public ResponseEntity<Notification> crearNotificacion(@Valid @RequestBody Notification n) {
        Notification creada = service.crearNotificacion(n);
        return ResponseEntity.status(201).body(creada);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAll() {
        var lista = service.obtenerTodas();
        return lista.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(lista);
    }

    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<Notification>> getByDestinatario(@PathVariable String destinatario) {
        var lista = service.obtenerPorDestinatario(destinatario);
        return lista.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> actualizarNotificacion(@PathVariable int id, @RequestBody Notification datosActualizados) {
        Notification actualizada = service.actualizarEstado(id, datosActualizados.getEstado());
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable int id) {
        return service.eliminarNotificacion(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
