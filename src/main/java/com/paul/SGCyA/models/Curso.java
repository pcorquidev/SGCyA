package com.paul.SGCyA.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Table(name = "CURSOS")
@Entity(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToMany
    private Set<Alumno> alumno;
}
