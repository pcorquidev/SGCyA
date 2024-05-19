package com.paul.SGCyA.repositories;

import com.paul.SGCyA.models.Enrolado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnroladoRepository extends JpaRepository<Enrolado,Long> {
}
