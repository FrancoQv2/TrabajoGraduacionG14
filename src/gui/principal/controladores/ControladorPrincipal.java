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
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.GestorAlumnosEnTrabajo;
import gui.trabajos.modelos.GestorRolEnTrabajo;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.Rol;
import gui.trabajos.modelos.RolEnTrabajo;
import gui.trabajos.modelos.Trabajo;
import java.time.LocalDate;
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
    GestorTrabajos gsTrabajos = GestorTrabajos.instanciar();
    GestorSeminarios gsSeminarios = GestorSeminarios.instanciar();
    GestorRolEnTrabajo gsRET = GestorRolEnTrabajo.instanciar();
    GestorAlumnosEnTrabajo gsAET = GestorAlumnosEnTrabajo.instanciar();
        
    
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
//    
//    System.out.println("**  mostrarAreas()");
//    gsAreas.mostrarAreas();
//    System.out.println();
//    
//    System.out.println("**  dameArea(String nombre)");
//    System.out.println(gsAreas.dameArea("Software"));
//    System.out.println(gsAreas.dameArea(""));
//    System.out.println(gsAreas.dameArea(null));
//    System.out.println();
//    
//    List<Area> buscarArea = new ArrayList<>();
//    
//    System.out.println("**  buscarAreas(String nombre)");
//    buscarArea = gsAreas.buscarAreas(null);
//    if (buscarArea == null) 
//        System.out.println("No se encontro ningun area");
//    else
//        for(Area a : buscarArea)
//            System.out.println(a);
//    System.out.println();
//    
//    buscarArea = gsAreas.buscarAreas("Mecánica");
//    if (buscarArea == null) 
//        System.out.println("No se encontro ningun area");
//    else
//        for(Area a : buscarArea)
//            System.out.println(a);
//    System.out.println();
//    
//    buscarArea = gsAreas.buscarAreas("Software");
//    if (buscarArea == null) 
//        System.out.println("No se encontro ningun area");
//    else
//        for(Area a : buscarArea)
//            System.out.println(a);
//    System.out.println();
//    System.out.println();
//    //*****************************AREAS***********************************
//    
//    
//    
//    //***************************PERSONAS**********************************
    System.out.println("***************************PERSONAS**********************************");
    System.out.println();
    
    System.out.println("**  nuevoAlumno(String apellidos, String nombres, int dni, String cx)");
    System.out.println(gsPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345")); //EXITO
    System.out.println(gsPersonas.nuevoAlumno("Martinez", "Ricardo Juan", 34567891, "16343")); //EXITO
//    System.out.println(gsPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345"));  //DUPLICADO
//    System.out.println(gsPersonas.nuevoAlumno("", "", 0, ""));  //ERROR
    System.out.println();
    
    System.out.println("**  nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo)");
    System.out.println(gsPersonas.nuevoProfesor("Molina", "Juan José", 123, Cargo.ASOCIADO)); //EXITO
    System.out.println(gsPersonas.nuevoProfesor("Diaz", "Juan Pablo", 234, Cargo.JTP)); //EXITO
    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Ana María", 345, Cargo.ADJUNTO)); //EXITO
    System.out.println(gsPersonas.nuevoProfesor("San Martín","José Manuel", 456, Cargo.ADG)); //EXITO
    System.out.println(gsPersonas.nuevoProfesor("Ortega", "Laura", 567, Cargo.ASOCIADO)); //EXITO
    
    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Pedro", 678, Cargo.JTP)); //EXITO
//    System.out.println(gsPersonas.nuevoProfesor("Juarez", "Juan José", 1, Cargo.ASOCIADO));  //DUPLICADO
//    System.out.println(gsPersonas.nuevoProfesor("", "", 0, Cargo.ASOCIADO));  //ERROR
//    System.out.println();
//    
//    
//    System.out.println("**  dameAlumno(String cx)");
//    System.out.println(gsPersonas.dameAlumno("16345"));
//    System.out.println(gsPersonas.dameAlumno(""));
//    System.out.println(gsPersonas.dameAlumno(null));
//    System.out.println();
//    
//    System.out.println("**  dameProfesor(int documento)");
//    System.out.println(gsPersonas.dameProfesor(12345678));
//    System.out.println(gsPersonas.dameProfesor(0));
//    System.out.println();
//    
//    
//    System.out.println("**  buscarAlumnos(int documento)");
//    List<Alumno> buscarAlumnos = new ArrayList<>();
//    
//    buscarAlumnos = gsPersonas.buscarAlumnos("Musa");
//    if (buscarAlumnos == null) 
//        System.out.println("No se encontro ningun alumno");
//    else
//        for(Alumno a : buscarAlumnos)
//            System.out.println(a);
//    
//    buscarAlumnos = gsPersonas.buscarAlumnos("");
//    if (buscarAlumnos == null) 
//        System.out.println("No se encontro ningun alumno");
//    else
//        for(Alumno a : buscarAlumnos)
//            System.out.println(a);
//    System.out.println();
//    
//    
//    System.out.println("**  buscarProfesores(int documento)");
//    List<Profesor> buscarProfesores = new ArrayList<>();
//    
//    buscarProfesores = gsPersonas.buscarProfesores("Molina");
//    if (buscarProfesores == null) 
//        System.out.println("No se encontro ningun profesor");
//    else
//        for(Profesor p : buscarProfesores)
//            System.out.println(p);
//    
//    buscarProfesores = gsPersonas.buscarProfesores("");
//    if (buscarProfesores == null) 
//        System.out.println("No se encontro ningun profesor");
//    else
//        for(Profesor p : buscarProfesores)
//            System.out.println(p);
//    System.out.println();
//    
//    
//    System.out.println("**  mostrarPersonas()");
//    gsPersonas.mostrarPersonas();
//    System.out.println();
//    System.out.println("**  mostrarAlumnos()");
//    gsPersonas.mostrarAlumnos();
//    System.out.println();
//    System.out.println("**  mostrarProfesores()");
//    gsPersonas.mostrarProfesores();
//    System.out.println();
    System.out.println();
//    //***************************PERSONAS**********************************
    
    
    
    //****************************TRABAJO**********************************
    System.out.println("****************************TRABAJO**********************************");
    System.out.println();
    
    LocalDate fechaPresentacion = LocalDate.of(2019, 10, 1);
    LocalDate fechaAprobacion = LocalDate.of(2019, 10, 10);
    
    
//    Alumno unAlumno1 = (Alumno)listaPersonas.get(1);
//    Profesor unProfesor = (Profesor)listaPersonas.get(2);

    List<Area> listaAreas = new ArrayList<>();
    listaAreas.add(gsAreas.dameArea("Software"));
    listaAreas.add(gsAreas.dameArea("Redes"));
    
    Alumno unAlumno1 = gsPersonas.dameAlumno("16345");
    Alumno unAlumno2 = gsPersonas.dameAlumno("16343");
//    Alumno unAlumno3 = gsPersonas.dameAlumno("16343");
    List<AlumnoEnTrabajo> listaAET = new ArrayList<>();
    
    listaAET.add(gsAET.nuevoAlumnoEnTrabajo(fechaAprobacion, unAlumno1));
    listaAET.add(gsAET.nuevoAlumnoEnTrabajo(fechaAprobacion, unAlumno2));
//    listaAET.add(gsAET.nuevoAlumnoEnTrabajo(fechaAprobacion, unAlumno3));//NO VERIFICA QUE YA SE ENCUENTRE EN LA LIST
//    listaAET.add(gsAET.nuevoAlumnoEnTrabajo(null, unAlumno1));
    System.out.println();
    
    
    Profesor unProfesor1 = gsPersonas.dameProfesor(123);
    Profesor unProfesor2 = gsPersonas.dameProfesor(234);
    Profesor unProfesor3 = gsPersonas.dameProfesor(345);
    Profesor unProfesor4 = gsPersonas.dameProfesor(456);
    Profesor unProfesor5 = gsPersonas.dameProfesor(567);
//    Profesor unProfesor6 = gsPersonas.dameProfesor(678); //
    List<RolEnTrabajo> listaRET = new ArrayList<>();
//    
    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor1, Rol.TUTOR));
//    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor1, Rol.COTUTOR));
    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor2, Rol.COTUTOR));
    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor3, Rol.JURADO));
//    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor3, Rol.JURADO));
    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor4, Rol.JURADO));
    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor5, Rol.JURADO));
//    listaRET.add(gsRET.nuevoRolEnTrabajo(null, unProfesor1, Rol.TUTOR));
//    listaRET.add(gsRET.nuevoRolEnTrabajo(fechaAprobacion, unProfesor6, Rol.JURADO));
    System.out.println();


    System.out.println("**  nuevoTrabajo (String titulo, List<Area> area, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobacion, List<AlumnoEnTrabajo> listaAlumnoEnT, List<RolEnTrabajo> listaRolEnT)");
    System.out.println();
    System.out.println(gsTrabajos.nuevoTrabajo("Protocolos de comunicación", listaAreas, 6, fechaPresentacion, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("", listaAreas, 6, fechaPresentacion, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo(null, listaAreas, 6, fechaPresentacion, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, fechaPresentacion, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Protocolos de comunicación", listaAreas, 6, fechaPresentacion, fechaAprobacion, listaAET, listaRET));

//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 0, fechaPresentacion, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, null, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, fechaPresentacion, null, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, fechaAprobacion, fechaPresentacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", null, 6, fechaPresentacion, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", new ArrayList<>(), 6, fechaPresentacion, fechaAprobacion, listaAET, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, fechaPresentacion, fechaAprobacion, null, listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, fechaPresentacion, fechaAprobacion, new ArrayList<>(), listaRET));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, fechaPresentacion, fechaAprobacion, listaAET, null));
//    System.out.println(gsTrabajos.nuevoTrabajo("Gestión de TF", listaAreas, 6, fechaPresentacion, fechaAprobacion, listaAET, new ArrayList<>()));
    
    gsTrabajos.dameTrabajo("Protocolos de comunicación").mostrar();
    gsTrabajos.dameTrabajo("").mostrar();
    gsTrabajos.dameTrabajo(null).mostrar();
    
    List<Trabajo> listaTrabajo = new ArrayList<>();
    

    System.out.println();
    System.out.println();
    //****************************TRABAJO**********************************
    
    
    //****************************SEMINARIO**********************************
    System.out.println("****************************SEMINARIO**********************************");
    System.out.println();
    
    LocalDate fechaExposicion = LocalDate.of(2019, 11, 1);
    
    
//    System.out.println(gsSeminarios.);
    
    
    //****************************SEMINARIO**********************************
    }
}
