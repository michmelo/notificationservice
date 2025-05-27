# Notifications Service - VitalConnect
Este microservicio forma parte del ecosistema de la plataforma VitalConnect, diseñada para la gestión descentralizada, segura y trazable de historiales médicos.

El notifications-service es responsable del envío de notificaciones en tiempo real a pacientes, médicos y administradores del sistema.

## Funcionalidad
- Crear notificaciones asociadas a eventos del sistema (ej. acceso a historial).
- Consultar todas las notificaciones registradas.
- Consultar notificaciones por destinatario (correo electrónico).
- Marcar notificaciones como leídas (actualización parcial).
- Eliminar notificaciones específicas por ID.
- Manejo centralizado de excepciones comunes y personalizadas.

## Tecnologías a utilizar
- Java 17
- Spring Boot 3.4.5
- Spring Data JPA + Hibernate
- MySQL (hospedada en AWS EC2)
- Jakarta Validation
- Spring Exception Handling con @ControllerAdvice
- Maven

## Requisitos para ejecutar localmente
- Java 17
- Maven 3.8.1 o superior
- IntelliJ IDEA (recomendado)
- MySQL 8.x instalado localmente (Workbench opcional para visualización)

## Cómo ejecutar el microservicio
Desde el directorio raíz del proyecto VitalConnect:
```bash
cd notifications-service
mvn spring-boot:run
```
O desde IntelliJ IDEA:
- Click derecho sobre la clase principal → Run

## Estructura del proyecto
```
notificationservice/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/vitalconnect/notificationservice/
│   │   │       ├── controller/
│   │   │       │   ├── ExceptionControllerAdvice.java
│   │   │       │   └── NotificationController.java
│   │   │       ├── exception/
│   │   │       │   └── ResourceNotFoundException.java
│   │   │       ├── model/
│   │   │       │   └── Notification.java
│   │   │       ├── repository/
│   │   │       │   └── NotificationRepository.java
│   │   │       ├── service/
│   │   │       │   └── NotificationService.java
│   │   │       └── NotificationserviceApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Endpoints disponibles:
- `POST /api/v1/notificaciones` → Crea una nueva notificación.
- `GET /api/v1/notificaciones` → Lista todas las notificaciones registradas.
- `GET /api/v1/notificaciones/destinatario/{correo}` → Lista notificaciones por destinatario (correo).
- `PUT /api/v1/notificaciones/{id}` → Actualiza el estado de una notificación (ej. leída).
- `DELETE /api/v1/notificaciones/{id}` → Elimina una notificación por su ID.

---
## Autoría
Proyecto propuesto y desarrollado como parte de la asignatura DSY1103 – Desarrollo Fullstack I (DuocUC) por Milenka Guerra y Michelle Melo.

## Licencia
Uso educativo. Código desarrollado con fines académicos.