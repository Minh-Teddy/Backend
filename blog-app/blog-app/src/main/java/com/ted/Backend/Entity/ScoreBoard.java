package com.ted.Backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "scoreboard")
public class ScoreBoard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idscoreboard", length = 20, nullable = false)
    private Integer idscoreboard;

    @Column(name = "processscore", nullable = false)
    private Float processscore;

    @Column(name = "componentscore", nullable = false)
    private Float componentscore;

    @Column(name = "finalscore", nullable = false)
    private Float finalscore;

    @Column(name = "ispassed", nullable = false)
    private Boolean ispassed;

    @Column(name = "registerdate", nullable = false)
    private LocalDateTime registereddate;

    @ManyToOne
    @JoinColumn(name = "idstudent", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "idsubject", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subject subject;
}
