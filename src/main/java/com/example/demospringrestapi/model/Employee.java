package com.example.demospringrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @JsonProperty("full_name")
    @NotBlank(message = "name must not be a null value")
    private String name;
//    @JsonIgnore
    private Long age = 0L;
    private String location;
    @Email(message = "please a valid email address")
    private String email;
    @NotBlank(message = "department must not be a null value")
    private String department;
    @CreationTimestamp
    @Column (name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column (name = "updated_at", nullable = false)
    private LocalDateTime UpdatedAt;
}
