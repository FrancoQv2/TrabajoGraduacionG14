/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.personas.modelos.Persona;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.Profesor;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public interface IGestorPersonas {
    
    //MODIFICAR PARA PERSONA O PROFESOR//ALUMNO !!!???
    public static final String EXITOAL = "Se creo el alumno correctamente";
    public static final String DUPLICADOAL = "El alumno ya fue creada";
    public static final String ERRORAL = "No se pudo crear el alumno";

    public static final String EXITOPRO = "Se creo el profesor correctamente";
    public static final String DUPLICADOPRO = "El profesor ya fue creada";
    public static final String ERRORPRO = "No se pudo crear el profesor";
    
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx);    
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo);
   
    public ArrayList<Alumno> buscarAlumnos(String apellidos);    
    public ArrayList<Profesor> buscarProfesores(String apellidos);
    
    public Alumno dameAlumno(String cx);    
    public Profesor dameProfesor(int documento);
   
    public void mostrarPersonas();
    public void mostrarAlumnos();
    public void mostrarProfesores();
}
