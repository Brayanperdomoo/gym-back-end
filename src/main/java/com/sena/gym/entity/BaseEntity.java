package com.sena.gym.entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
/** Clase base para no repetir id, createdAt y updatedAt en cada entidad. */
@MappedSuperclass
@Getter 
@Setter
public abstract class BaseEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    /** Se ejecuta antes de insertar el registro. */
    @PrePersist public void prePersist(){ this.createdAt = LocalDateTime.now(); }
    /** Se ejecuta antes de actualizar el registro. */
    @PreUpdate public void preUpdate(){ this.updatedAt = LocalDateTime.now(); }
}
