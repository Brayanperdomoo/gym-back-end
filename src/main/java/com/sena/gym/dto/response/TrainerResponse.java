package com.sena.gym.dto.response;
/** DTO de salida para entrenadores. */
public record TrainerResponse(Long id, String firstName, String lastName, String specialty, String phone, String email) {}
