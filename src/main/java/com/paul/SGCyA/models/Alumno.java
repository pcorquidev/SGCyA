package com.paul.SGCyA.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Table(name = "ALUMNOS")
@Entity(name = "ALUMNO")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String matricula;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @ManyToMany(mappedBy = "alumno")
    private Set<Curso> curso;
}
