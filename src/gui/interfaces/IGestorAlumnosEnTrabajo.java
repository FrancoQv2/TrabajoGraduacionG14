/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.personas.modelos.Alumno;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import java.time.LocalDate;

/**
 *
 * @author franc
 */
public interface IGestorAlumnosEnTrabajo {
    public static final String EXITO = "Se agregó el alumno en trabajo correctamente";
    public static final String DUPLICADO = "El alumno en trabajo ya fue creada";
    public static final String ERROR = "No se pudo crear el alumno en trabajo";
    
    
    public AlumnoEnTrabajo nuevoAlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno);
    
    
}
