package com.paul.SGCyA.services;

import com.paul.SGCyA.models.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> findAll();
    Curso findByName(String name);
}
