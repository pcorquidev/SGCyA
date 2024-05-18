package com.paul.SGCyA.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Table(name = "CURSOS")
@Entity(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String clave;
    private String name;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;
    @ManyToMany
    private Set<Alumno> alumno;
}
