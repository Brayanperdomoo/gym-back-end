package com.sena.gym.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
/** Representa una sesion de entrenamiento dirigida por un entrenador para un miembro. */
@Entity 
@Table(name = "training_sessions")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class TrainingSession extends BaseEntity {

    @Column(name="session_date", nullable=false) 
    private LocalDateTime sessionDate;

    @Column(name="training_type", nullable=false, length=100) 
    private String trainingType;

    @Column(name="duration_minutes", nullable=false) 
    private Integer durationMinutes;

    @Column(length=255) private String notes;

    /** Muchos entrenamientos pueden pertenecer a un mismo miembro. */
    @ManyToOne 
    @JoinColumn(name="member_id", nullable=false) 
    private Member member;

    /** Muchos entrenamientos pueden ser dirigidos por un mismo entrenador. */
    @ManyToOne 
    @JoinColumn(name="trainer_id", nullable=false) 
    private Trainer trainer;
}
