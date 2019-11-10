/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
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
