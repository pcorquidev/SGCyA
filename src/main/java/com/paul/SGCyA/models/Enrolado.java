package com.paul.SGCyA.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Enrolado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double calificacion;
    @Column
    private Long asistencia;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso cursos;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumnos;
}
