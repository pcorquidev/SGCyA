package com.paul.SGCyA.repositories;

import com.paul.SGCyA.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRespository extends JpaRepository<Curso, Long> {

    Curso findByName(String name);

}
