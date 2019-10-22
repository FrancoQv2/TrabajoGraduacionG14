/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.personas.modelos.Alumno;
import java.time.LocalDate;

/**
 *
 * @author franc
 */
public interface IGestorAlumnosEnTrabajo {
    public static final String EXITOAET = "Se agregó el alumno en trabajo correctamente";
    public static final String DUPLICADOAET = "El alumno en trabajo ya fue creada";
    public static final String ERRORAET = "No se pudo crear el alumno en trabajo";
    
    
    public String nuevoAlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno);
    
    
}
