package com.paul.SGCyA.repositories;

import com.paul.SGCyA.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumno,Long> {
    Alumno findByMatricula(String matricula);
}
