package com.paul.SGCyA.services;

import com.paul.SGCyA.DTO.CursoDTO;
import com.paul.SGCyA.models.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> findAll();
    CursoDTO findByName(String name);
}
