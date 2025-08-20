package com.daniel.tasks.model;

import com.daniel.tasks.enums.EnumStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único

    private String name;  // Nome da tarefa

    private String description;  // Descrição curta

    @Enumerated(EnumType.STRING)
    private EnumStatus status;  // Estado da tarefa (PENDING, DONE)

    private LocalDateTime createdAt;  // Data de criação

    private LocalDateTime scheduledAt;  // Data e hora agendada (opcional, para cron jobs)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }
}
