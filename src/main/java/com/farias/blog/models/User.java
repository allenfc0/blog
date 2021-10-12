package com.farias.blog.models;

import java.time.LocalDate;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NotBlank(message = "Please provide a name")
    @NonNull
    String name;

    @NotBlank(message = "Please provide a dob")
    @NonNull
    String dob;

    @NotBlank(message = "Please provide a email")
    @NonNull
    String email;

    @NotBlank(message = "Please provide a password")
    @NonNull
    String password;

    public User(String name, String dob,String email, String password) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }
}
