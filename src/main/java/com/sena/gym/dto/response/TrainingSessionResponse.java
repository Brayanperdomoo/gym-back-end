package com.sena.gym.dto.response;
import java.time.LocalDateTime;
/** DTO de salida para sesiones de entrenamiento. */
public record TrainingSessionResponse(Long id, LocalDateTime sessionDate, String trainingType, Integer durationMinutes, String notes, MemberResponse member, TrainerResponse trainer) {}
