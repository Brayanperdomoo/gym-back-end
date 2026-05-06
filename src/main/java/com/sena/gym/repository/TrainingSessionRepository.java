package com.sena.gym.repository;
import com.sena.gym.entity.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;
/** Acceso a la tabla training_sessions. */
public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {}
