/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import gui.interfaces.IGestorPersonas;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public class GestorPersonas implements IGestorPersonas{
    
    private ArrayList<Persona> listasPersonas = new ArrayList<Persona>();
    
    private static GestorPersonas gestor;
    
    private GestorPersonas(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorPersonas instanciar(){
        if (gestor == null)
            gestor = new GestorPersonas();
        return gestor;
    }

    @Override
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx) {
        if (validarAlumno(apellidos, nombres, dni, cx) == true) {     //nombre de area no sea una cadena vacia
            Persona alumno = new Alumno(apellidos, nombres, dni, cx);
            if (!this.listasPersonas.contains(alumno)) {
                this.listasPersonas.add(alumno);
                return EXITOAL;
            }
            else
                return DUPLICADOAL;
        }else
            return ERRORAL;
    }

    @Override
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo) {
        if (validarProfesor(apellidos, nombres, dni, cargo) == true) {     //nombre de area no sea una cadena vacia
            Persona profesor = new Profesor(apellidos, nombres, dni, cargo);
            if (!this.listasPersonas.contains(profesor)) {
                this.listasPersonas.add(profesor);
                return EXITOPRO;
            }
            else
                return DUPLICADOPRO;
        }else
            return ERRORPRO;
    }

    @Override
    public ArrayList<Alumno> buscarAlumnos(String apellidos) {
        if (!apellidos.trim().isEmpty() && !apellidos.equals(null)) {
            ArrayList<Alumno> listaAlumnos = new ArrayList<>();
            
            for (Persona p : listasPersonas) {
                if (p instanceof Alumno) {
                    if (p.getApellidos().toUpperCase().contains(apellidos.toUpperCase())) //otra forma if(a.getNombre().compareToIgnoreCase(nombre) == 0)
                        listaAlumnos.add((Alumno) p);
                }
            }
            return listaAlumnos;
        } else
            return new ArrayList<Alumno>();  //SIRVE?????? PARA DEVOLVER UNA LISTA VACIA
    }

    @Override
    public ArrayList<Profesor> buscarProfesores(String apellidos) {
        if (!apellidos.trim().isEmpty() && !apellidos.equals(null)) {
            ArrayList<Profesor> listaProfesores = new ArrayList<>();
            
            for (Persona p : listasPersonas) {
                if (p instanceof Profesor) {
                    if (p.getApellidos().toUpperCase().contains(apellidos.toUpperCase())) //otra forma if(a.getNombre().compareToIgnoreCase(nombre) == 0)
                        listaProfesores.add((Profesor) p);
                }
            }
            return listaProfesores;
        }
        else
            return new ArrayList<Profesor>();  //SIRVE?????? PARA DEVOLVER UNA LISTA VACIA
    }

    @Override
    public Alumno dameAlumno(String cx) {
        for(Persona p : listasPersonas){
            if (p instanceof Alumno){
                if (((Alumno) p).getCx().equals(cx)){
                    return (Alumno) p;
                }
            }
        }    
        return null;
    }

    @Override
    public Profesor dameProfesor(int documento) {
        for(Persona p : listasPersonas){
            if (p instanceof Profesor) {
                if (((Profesor) p).getDni() == documento) //EL EQUALS COMPARA STRING, EL == COMPARA INT
                    return (Profesor) p;
            }
        }
        return null;
    }

    @Override
    public void mostrarPersonas() {
        for(Persona p : listasPersonas)
            System.out.println(p);
    }

    @Override
    public void mostrarAlumnos() {
        for(Persona p : listasPersonas){
            if (p instanceof Alumno)
                System.out.println(p);
        }
    }

    @Override
    public void mostrarProfesores() {
        for(Persona p : listasPersonas){
            if (p instanceof Profesor)
                System.out.println(p);
        }    
    }
    
    private static boolean validarAlumno(String apellidos, String nombres, int dni, String cx){ //(Alumno alumno)
//        if (!alumno.getApellidos().trim().isEmpty() && !alumno.getApellidos().equals(null) && !alumno.getNombres().trim().isEmpty() && !alumno.getNombres().equals(null) && (alumno.getDni() > 0) && (alumno.getCx() != null)) {
            if (!apellidos.trim().isEmpty() && !apellidos.equals(null) && !nombres.trim().isEmpty() && !nombres.equals(null) && (dni > 0) && (cx != null)) {
            return true;
        }
        return false;
    }
    

    private static boolean validarProfesor(String apellidos, String nombres, int dni, Cargo cargo){ //Profesor profesor){
//        if (!profesor.getApellidos().trim().isEmpty() && !profesor.getApellidos().equals(null) && !profesor.getNombres().trim().isEmpty() && !profesor.getNombres().equals(null) && (profesor.getDni() > 0) && (profesor.getCargo() != null)) {
        if (!apellidos.trim().isEmpty() && !apellidos.equals(null) && !nombres.trim().isEmpty() && !nombres.equals(null) && (dni > 0) && (cargo != null)) {
            return true;
        }
        return false;
    }
    
}
