package com.sena.gym.dto.response;
/** DTO de salida para miembros. */
public record MemberResponse(Long id, String firstName, String lastName, String documentNumber, String phone, String email, String membershipType) {}
