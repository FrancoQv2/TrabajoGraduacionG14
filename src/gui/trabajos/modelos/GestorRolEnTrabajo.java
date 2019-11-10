/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.trabajos.modelos;

import gui.interfaces.IGestorRolEnTrabajo;
import gui.personas.modelos.Profesor;
import java.time.LocalDate;

/**
 *
 * @author estudiante
 */
public class GestorRolEnTrabajo implements IGestorRolEnTrabajo{

    private static GestorRolEnTrabajo gestor;
    
    
    private GestorRolEnTrabajo(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorRolEnTrabajo instanciar(){
        if (gestor == null)
            gestor = new GestorRolEnTrabajo();
        return gestor;
    }
    
    @Override
    public RolEnTrabajo nuevoRolEnTrabajo(LocalDate fechaDesde, Profesor unProfesor, Rol unRol) {
        if (fechaDesde != null && !unProfesor.equals(null) && !unRol.equals(null)) {
            RolEnTrabajo unRET = new RolEnTrabajo(fechaDesde, unProfesor, unRol);
            System.out.println(EXITO);
            return unRET;
        }else
            return null;
    }
    
}
