package com.paul.SGCyA.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "CURSOS")
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @ManyToMany
    private Alumno alumno;
}
