package com.projekat.SR19.model.entity;

import com.projekat.SR19.model.entity.UserRole;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String displayName;

    @Column(nullable = false)
    private UserRole userRole;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", registrationDate=" + registrationDate +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
