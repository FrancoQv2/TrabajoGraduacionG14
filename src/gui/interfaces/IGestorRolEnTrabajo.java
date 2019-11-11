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
    public static final String EXITO_RET = "El rol en trabajo se agregó correctamente";
    public static final String DUPLICADO_RET = "El rol en trabajo ya fue creado anteriormente";
    public static final String ERROR_RET = "El rol en trabajo no pudo ser creado";
    
    public RolEnTrabajo nuevoRolEnTrabajo(LocalDate fechaDesde, Profesor unProfesor, Rol unRol);
}
