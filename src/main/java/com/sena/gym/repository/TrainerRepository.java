package com.sena.gym.repository;
import com.sena.gym.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
/** Acceso a la tabla trainers. */
public interface TrainerRepository extends JpaRepository<Trainer, Long> {}
