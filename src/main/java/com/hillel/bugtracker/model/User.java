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

    @NotBlank
    @Column(name = "first_Name")
    @NonNull
    @EqualsAndHashCode.Exclude
    private String firstName;

    @NotBlank
    @Column(name = "last_Name")
    @NonNull
    @EqualsAndHashCode.Exclude
    private String lastName;


    @Email
    @Column(name = "email")
    @NotBlank
    @NonNull
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private String email;

}
