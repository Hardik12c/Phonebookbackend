package com.mis.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "phone_numbers")
public class PhoneNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(nullable = false, unique = true, length = 10)
    private String phoneNumber;

    public PhoneNumbers() {}

    public PhoneNumbers(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

