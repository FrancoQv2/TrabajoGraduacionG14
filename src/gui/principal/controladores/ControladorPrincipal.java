/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.principal.controladores;

import gui.areas.modelos.Area;
import gui.areas.modelos.GestorAreas;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.GestorPersonas;
import gui.personas.modelos.Profesor;
import gui.seminarios.modelos.GestorSeminarios;
import gui.trabajos.modelos.GestorAlumnosEnTrabajo;
import gui.trabajos.modelos.GestorRolEnTrabajo;
import gui.trabajos.modelos.GestorTrabajos;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gabinete
 */
public class ControladorPrincipal {
    public static void main (String Args[] ) {
        
    //----------------------INSTANCIO LOS GESTORES----------------------------
    GestorAreas gsAreas = GestorAreas.instanciar();
    GestorPersonas gsPersonas = GestorPersonas.instanciar();
//    GestorTrabajos gsTrabajos = GestorTrabajos.instanciar();
//    GestorSeminarios gsSeminarios = GestorSeminarios.instanciar();
//    GestorRolEnTrabajo gsRET = GestorRolEnTrabajo.instanciar();
//    GestorAlumnosEnTrabajo gsAET = GestorAlumnosEnTrabajo.instanciar();
        
    
    //*****************************AREAS***********************************
    System.out.println("*****************************AREAS***********************************");
    System.out.println();
    
    System.out.println("**  nuevaArea(String nombre)");
    System.out.println(gsAreas.nuevaArea("Software")); //EXITO
    System.out.println(gsAreas.nuevaArea("Hardware")); //EXITO
    System.out.println(gsAreas.nuevaArea("Sistemas Embebidos")); //EXITO
    System.out.println(gsAreas.nuevaArea("Redes")); //EXITO
    System.out.println(gsAreas.nuevaArea("Redes"));  //DUPLICADO
    System.out.println(gsAreas.nuevaArea(""));  //ERROR
    System.out.println(gsAreas.nuevaArea(null));  //ERROR
    System.out.println();
    
    System.out.println("**  mostrarAreas()");
    gsAreas.mostrarAreas();
    System.out.println();
    
    System.out.println("**  dameArea(String nombre)");
    System.out.println(gsAreas.dameArea("Software"));
    System.out.println(gsAreas.dameArea(""));
    System.out.println(gsAreas.dameArea(null));
    System.out.println();
    
    List<Area> buscarArea = new ArrayList<>();
    
    System.out.println("**  buscarAreas(String nombre)");
    buscarArea = gsAreas.buscarAreas(null);
    if (buscarArea == null) 
        System.out.println("No se encontro ningun area");
    else
        for(Area a : buscarArea)
            System.out.println(a);
    System.out.println();
    
    buscarArea = gsAreas.buscarAreas("Mecánica");
    if (buscarArea == null) 
        System.out.println("No se encontro ningun area");
    else
        for(Area a : buscarArea)
            System.out.println(a);
    System.out.println();
    
    buscarArea = gsAreas.buscarAreas("Software");
    if (buscarArea == null) 
        System.out.println("No se encontro ningun area");
    else
        for(Area a : buscarArea)
            System.out.println(a);
    System.out.println();
    System.out.println();
    //*****************************AREAS***********************************
    
    
    
    //***************************PERSONAS**********************************
    System.out.println("***************************PERSONAS**********************************");
    System.out.println();
    
    System.out.println("**  nuevoAlumno(String apellidos, String nombres, int dni, String cx)");
    System.out.println(gsPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345")); //EXITO
    System.out.println(gsPersonas.nuevoAlumno("Martinez", "Ricardo Juan", 34567891, "16343")); //EXITO
    System.out.println(gsPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345"));  //DUPLICADO
    System.out.println(gsPersonas.nuevoAlumno("", "", 0, ""));  //ERROR
    System.out.println();
    
    System.out.println("**  nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo)");
    System.out.println(gsPersonas.nuevoProfesor("Molina", "Juan José", 12345678, Cargo.ASOCIADO)); //EXITO
    System.out.println(gsPersonas.nuevoProfesor("Diaz", "Juan Pablo", 13345678, Cargo.JTP)); //EXITO
    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Ana María", 14345678, Cargo.ADJUNTO)); //EXITO
    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Juan José", 12345678, Cargo.ASOCIADO));  //DUPLICADO
    System.out.println(gsPersonas.nuevoProfesor("", "", 0, Cargo.ASOCIADO));  //ERROR
    System.out.println();
    
    
    System.out.println("**  dameAlumno(String cx)");
    System.out.println(gsPersonas.dameAlumno("16345"));
    System.out.println(gsPersonas.dameAlumno(""));
    System.out.println(gsPersonas.dameAlumno(null));
    System.out.println();
    
    System.out.println("**  dameProfesor(int documento)");
    System.out.println(gsPersonas.dameProfesor(12345678));
    System.out.println(gsPersonas.dameProfesor(0));
    System.out.println();
    
    
    System.out.println("**  buscarAlumnos(int documento)");
    List<Alumno> buscarAlumnos = new ArrayList<>();
    
    buscarAlumnos = gsPersonas.buscarAlumnos("Musa");
    if (buscarAlumnos == null) 
        System.out.println("No se encontro ningun alumno");
    else
        for(Alumno a : buscarAlumnos)
            System.out.println(a);
    
    buscarAlumnos = gsPersonas.buscarAlumnos("");
    if (buscarAlumnos == null) 
        System.out.println("No se encontro ningun alumno");
    else
        for(Alumno a : buscarAlumnos)
            System.out.println(a);
    System.out.println();
    
    
    System.out.println("**  buscarProfesores(int documento)");
    List<Profesor> buscarProfesores = new ArrayList<>();
    
    buscarProfesores = gsPersonas.buscarProfesores("Molina");
    if (buscarProfesores == null) 
        System.out.println("No se encontro ningun profesor");
    else
        for(Profesor p : buscarProfesores)
            System.out.println(p);
    
    buscarProfesores = gsPersonas.buscarProfesores("");
    if (buscarProfesores == null) 
        System.out.println("No se encontro ningun profesor");
    else
        for(Profesor p : buscarProfesores)
            System.out.println(p);
    System.out.println();
    
    
    System.out.println("**  mostrarPersonas()");
    gsPersonas.mostrarPersonas();
    System.out.println();
    System.out.println("**  mostrarAlumnos()");
    gsPersonas.mostrarAlumnos();
    System.out.println();
    System.out.println("**  mostrarProfesores()");
    gsPersonas.mostrarProfesores();
    System.out.println();
    System.out.println();
//    //***************************PERSONAS**********************************
    
    
    
    //****************************TRABAJO**********************************
    
    //****************************TRABAJO**********************************
    
    }
}
