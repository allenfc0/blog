package com.farias.blog.models;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Long id;
    private String name;
    private LocalDate dob;
    private String email;

    public User(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
}
