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
    public static final String EXITO_AET = "El alumno en trabajo se agregó correctamente";
    public static final String DUPLICADO_AET = "El alumno en trabajo ya fue creado anteriormente";
    public static final String ERROR_AET = "El alumno en trabajo no pudo ser creado";
    
    public AlumnoEnTrabajo nuevoAlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno);
}
