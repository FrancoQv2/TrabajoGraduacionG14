/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.interfaces;

import gui.personas.modelos.Profesor;
import gui.trabajos.modelos.Rol;
import gui.trabajos.modelos.RolEnTrabajo;
import java.time.LocalDate;

/**
 *
 * @author estudiante
 */
public interface IGestorRolEnTrabajo {
    public static final String EXITO = "Se creo el rol en trabajo correctamente";
    public static final String DUPLICADO = "El rol en trabajo ya fue creado";
    public static final String ERROR = "No se pudo crear el rol en trabajo";
    
    public RolEnTrabajo nuevoRolEnTrabajo(LocalDate fechaDesde, Profesor unProfesor, Rol unRol);
}
