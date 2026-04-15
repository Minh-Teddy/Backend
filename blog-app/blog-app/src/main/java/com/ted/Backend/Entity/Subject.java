package com.ted.Backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idsubject", length = 20, nullable = false, unique = true)
    private String idsubject;

    @Column(name = "subjectname", length = 100, nullable = false)
    private String subjectname;

    @Column(name = "totalperiod", nullable = false)
    private Integer totalperiod;

    @Column(name = "processratio", nullable = false)
    private Float processratio;

    @Column(name = "componentratio", nullable = false)
    private Float componentratio;

    @Column(name = "passscore", nullable = false)
    private Float passscore;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<ScoreBoard> scoreboards;
}
