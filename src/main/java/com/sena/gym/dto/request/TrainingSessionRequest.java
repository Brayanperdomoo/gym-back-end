package com.sena.gym.dto.request;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
/** DTO para crear o actualizar sesiones de entrenamiento. */
public record TrainingSessionRequest(
    @NotNull(message="La fecha y hora de la sesion es obligatoria")
    @FutureOrPresent(message="La fecha no puede estar en el pasado") LocalDateTime sessionDate,
    @NotBlank(message="El tipo de entrenamiento es obligatorio")
    @Pattern(regexp="^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$", message="El tipo de entrenamiento solo puede contener letras y espacios")
    @Size(min=3, max=100, message="El tipo debe tener entre 3 y 100 caracteres") String trainingType,
    @NotNull(message="La duracion es obligatoria") @Min(value=15, message="La duracion minima es 15 minutos") @Max(value=240, message="La duracion maxima es 240 minutos") Integer durationMinutes,
    @Size(max=255, message="Las notas no pueden superar 255 caracteres") String notes,
    @NotNull(message="El miembro es obligatorio") Long memberId,
    @NotNull(message="El entrenador es obligatorio") Long trainerId
) {}
