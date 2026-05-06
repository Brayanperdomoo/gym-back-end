package com.sena.gym.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/** Representa a un cliente o miembro del gimnasio. */
@Entity @Table(name = "members")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Member extends BaseEntity {

    @Column(name="first_name", nullable=false, length=100) 
    private String firstName;

    @Column(name="last_name", nullable=false, length=100) 
    private String lastName;

    @Column(name="document_number", nullable=false, unique=true, length=12) 
    private String documentNumber;

    @Column(nullable=false, length=12) 
    private String phone;

    @Column(nullable=false, unique=true, length=150) 
    private String email;

    @Column(name="membership_type", nullable=false, length=60) 
    private String membershipType;

}
