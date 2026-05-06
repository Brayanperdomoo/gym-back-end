package com.sena.gym.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/** DTO para crear o actualizar miembros. Aqui van las validaciones de entrada. */
public record MemberRequest(
    @NotBlank(message="El nombre es obligatorio")
    @Pattern(regexp="^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$", message="El nombre solo puede contener letras y espacios")
    @Size(min=2, max=100, message="El nombre debe tener entre 2 y 100 caracteres") String firstName,

    @NotBlank(message="El apellido es obligatorio")
    @Pattern(regexp="^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$", message="El apellido solo puede contener letras y espacios")
    @Size(min=2, max=100, message="El apellido debe tener entre 2 y 100 caracteres") String lastName,

    @NotBlank(message="El documento es obligatorio")
    @Pattern(regexp="^\\d{10,12}$", message="El documento debe tener solo numeros y entre 10 y 12 digitos") String documentNumber,

    @NotBlank(message="El celular es obligatorio")
    @Pattern(regexp="^\\d{10,12}$", message="El celular debe tener solo numeros y entre 10 y 12 digitos") String phone,

    @NotBlank(message="El correo es obligatorio")
    @Email(message="El correo debe tener formato valido")
    @Size(max=150, message="El correo no puede superar 150 caracteres") String email,

    @NotBlank(message="El tipo de membresia es obligatorio")
    @Pattern(regexp="^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$", message="La membresia solo puede contener letras y espacios")
    @Size(min=3, max=60, message="La membresia debe tener entre 3 y 60 caracteres") String membershipType
) {}

