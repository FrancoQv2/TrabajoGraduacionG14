/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.principal.controladores;

import gui.areas.modelos.Area;
import gui.areas.modelos.GestorAreas;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.GestorPersonas;
import gui.personas.modelos.Profesor;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public class ControladorPrincipal {
    public static void main (String Args[] ) {
    
    //*****************************AREAS***********************************
    GestorAreas gsAreas = GestorAreas.instanciar();
    System.out.println(gsAreas.nuevaArea("Software")); //EXITO
    System.out.println(gsAreas.nuevaArea("Hardware")); //Area creada correcmente
    System.out.println(gsAreas.nuevaArea("Software"));  //DUPLICADO
    System.out.println(gsAreas.nuevaArea(""));  //ERROR
    System.out.println();
    
    gsAreas.mostrarAreas();
    System.out.println();
    
    System.out.println(gsAreas.dameArea(""));
    System.out.println(gsAreas.dameArea("Software"));
    System.out.println(gsAreas.dameArea(null));
    System.out.println();
    
    ArrayList<Area> buscarArea = new ArrayList<Area>();
    
    buscarArea = gsAreas.buscarAreas(null);
    if (buscarArea == null) 
        System.out.println("No se encontro ningun area");
    else
        for(Area a : buscarArea)
            System.out.println(a);
    
    buscarArea = gsAreas.buscarAreas("Software");
    if (buscarArea == null) 
        System.out.println("No se encontro ningun area");
    else
        for(Area a : buscarArea)
            System.out.println(a);
    //*****************************AREAS***********************************
    
    
    
    //***************************PERSONAS**********************************
//    GestorPersonas gsPersonas = GestorPersonas.instanciar();
//    System.out.println(gsPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345")); //EXITO
//    System.out.println(gsPersonas.nuevoAlumno("Martinez", "Ricardo Juan", 34567891, "16343")); //EXITO
//    System.out.println(gsPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345"));  //DUPLICADO
//    System.out.println(gsPersonas.nuevoAlumno("", "", 0, ""));  //ERROR
//    System.out.println();
//    
//    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Juan José", 12345678, Cargo.ASOCIADO)); //EXITO
//    System.out.println(gsPersonas.nuevoProfesor("Diaz", "Juan Pablo", 13345678, Cargo.JTP)); //EXITO
//    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Ana María", 14345678, Cargo.ADJUNTO)); //EXITO
//    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Juan José", 12345678, Cargo.ASOCIADO));  //DUPLICADO
//    System.out.println(gsPersonas.nuevoProfesor("", "", 0, Cargo.ASOCIADO));  //ERROR
//    System.out.println();
//    
//    
//    System.out.println(gsPersonas.dameAlumno(""));
//    System.out.println(gsPersonas.dameAlumno("16345"));
//    System.out.println(gsPersonas.dameAlumno(null));
//    System.out.println();
//    
//    System.out.println(gsPersonas.dameProfesor(0));
//    System.out.println(gsPersonas.dameProfesor(12345678));
//    System.out.println();
//    
//    
//    ArrayList<Alumno> buscarAlumnos = new ArrayList<>();
//    ArrayList<Profesor> buscarProfesores = new ArrayList<>();
//    //
//    buscarAlumnos = gsPersonas.buscarAlumnos("");
//    if (buscarAlumnos == null) 
//        System.out.println("No se encontro ningun area");
//    else
//        for(Alumno a : buscarAlumnos)
//            System.out.println(a);
//    
//    buscarAlumnos = gsPersonas.buscarAlumnos("Software");
//    if (buscarAlumnos == null) 
//        System.out.println("No se encontro ningun area");
//    else
//        for(Alumno a : buscarAlumnos)
//            System.out.println(a);
//    //
//    buscarProfesores = gsPersonas.buscarProfesores("");
//    if (buscarProfesores == null) 
//        System.out.println("No se encontro ningun area");
//    else
//        for(Profesor a : buscarProfesores)
//            System.out.println(a);
//    
//    buscarProfesores = gsPersonas.buscarProfesores("Software");
//    if (buscarProfesores == null) 
//        System.out.println("No se encontro ningun area");
//    else
//        for(Profesor a : buscarProfesores)
//            System.out.println(a);
////    
////        
//    gsPersonas.mostrarPersonas();
//    gsPersonas.mostrarAlumnos();
//    gsPersonas.mostrarProfesores();
//    System.out.println();
//    //***************************PERSONAS**********************************
    
    
    
    //****************************TRABAJO**********************************
    
    //****************************TRABAJO**********************************
    
    }
}
