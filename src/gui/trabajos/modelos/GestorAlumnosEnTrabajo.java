/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.trabajos.modelos;

import gui.interfaces.IGestorAlumnosEnTrabajo;
import gui.personas.modelos.Alumno;
import java.time.LocalDate;

/**
 *
 * @author franc
 */
public class GestorAlumnosEnTrabajo implements IGestorAlumnosEnTrabajo{
    
    private static GestorAlumnosEnTrabajo gestor;
    
    private GestorAlumnosEnTrabajo(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorAlumnosEnTrabajo instanciar(){
        if (gestor == null)
            gestor = new GestorAlumnosEnTrabajo();
        return gestor;
    }

    @Override
    public AlumnoEnTrabajo nuevoAlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno) {
        if (validarAET(fechaDesde, unAlumno) == true) {
            AlumnoEnTrabajo unAET = new AlumnoEnTrabajo(fechaDesde, unAlumno);
            System.out.println(EXITO_AET);
            return unAET;
        }else{
            System.out.println(ERROR_AET);
            return null;
        }
    }
    
    //NO ES NECESARIO CONTROLAR EL ALUMNO PORQUE YA SE CONTROLO AL MOMENTO DE CREARSE EL MISMO
    private static boolean validarAET(LocalDate fechaDesde, Alumno unAlumno){
        if (fechaDesde == null) {
            return false;
        }
        return true;
    }
    
}
