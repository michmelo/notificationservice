package com.vitalconnect.notificationservice.model;

//<editor-fold desc="IMPORTS">
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//</editor-fold>

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String destinatario;

    @NotBlank
    private String asunto;

    @NotBlank
    @Size(max = 500)
    @Column(length = 500)
    private String mensaje;

    @Column(nullable = false)
    private Boolean estado;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime timestamp;

    @PrePersist
    protected void onCreate(){
        this.timestamp = LocalDateTime.now();
    }
}
