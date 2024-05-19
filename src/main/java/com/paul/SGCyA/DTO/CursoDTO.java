package com.paul.SGCyA.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private String nombreCurso;
    private String matricula;
    private List<AlumnoDTO> alumnos;
}
