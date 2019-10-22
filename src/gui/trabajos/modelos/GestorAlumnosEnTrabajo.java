/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.interfaces.IGestorAlumnosEnTrabajo;
import gui.personas.modelos.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class GestorAlumnosEnTrabajo implements IGestorAlumnosEnTrabajo{
      //NO HACE FALTA AGREGAR EL AET CREADO A UNA LISTA??
//    private ArrayList<AlumnoEnTrabajo> listasAlumnosEnTrabajo = new ArrayList<>();
    
    private static GestorAlumnosEnTrabajo gestor;
    
    //Constructor privado
    private GestorAlumnosEnTrabajo(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorAlumnosEnTrabajo instanciar(){
        if (gestor == null)
            gestor = new GestorAlumnosEnTrabajo();
        return gestor;
    }

    @Override
    public String nuevoAlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno) {
        if (fechaDesde != null && !unAlumno.equals(null)) {
            AlumnoEnTrabajo unAET = new AlumnoEnTrabajo(fechaDesde, unAlumno);
            return EXITOAET;
        }else
            return null;
    }
    
    //ES NECESARIO??
//    private static boolean validarFecha(LocalDate fecha){
//        if (fecha != null) {
//           return true; 
//        }        
//        return false;
//    }
    
}
