package com.hillel.bugtracker.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @NotBlank(message = "first name is required")
    @Column(name = "first_Name")
    @NonNull
    @EqualsAndHashCode.Exclude
    private String firstName;

    @NotBlank(message = "last name is required")
    @Column(name = "last_Name")
    @NonNull
    @EqualsAndHashCode.Exclude
    private String lastName;


    @Email(message = "invalid email format")
    @Column(name = "email")
    @NotBlank(message = "email is required")
    @NonNull
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private String email;

}
