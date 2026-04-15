package com.ted.Backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idstudent", length = 10, nullable = false, unique = true)
    private String idstudent;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 20)
    private Gender gender;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "classname", length = 50, nullable = false)
    private String classname;

    @Column(name = "generation", nullable = false)
    private Integer generation;

    @Column(name = "phonenumber", length = 15, nullable = false)
    private String phonenumber;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    public enum Gender {
        Male, Female
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ScoreBoard> scoreboards;
}
