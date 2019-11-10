/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.personas.modelos;

import gui.interfaces.IGestorPersonas;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.RolEnTrabajo;
import gui.trabajos.modelos.Trabajo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabinete
 */
public class GestorPersonas implements IGestorPersonas{
    
    private List<Persona> listasPersonas = new ArrayList<Persona>();
    
    private static GestorPersonas gestor;
    
    private GestorPersonas(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorPersonas instanciar(){
        if (gestor == null)
            gestor = new GestorPersonas();
        return gestor;
    }

    public List<Persona> getListasPersonas() {
        return listasPersonas;
    }
    
    /**
     *
     * @param apellidos
     * @param nombres
     * @param dni
     * @param cx
     * @return
     */
    @Override
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx) {
        if (validarAlumno(apellidos, nombres, dni, cx) == true) {     //nombre de area no sea una cadena vacia
            Persona alumno = new Alumno(apellidos, nombres, dni, cx);
            if (!this.listasPersonas.contains(alumno)) {
                this.listasPersonas.add(alumno);
                return EXITO_ALUMNO;
            }
            else
                return DUPLICADO_ALUMNO;
        }else
            return ERROR_ALUMNO;
    }

    /**
     *
     * @param apellidos
     * @param nombres
     * @param dni
     * @param cargo
     * @return
     */
    @Override
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo) {
        if (validarProfesor(apellidos, nombres, dni, cargo) == true) {     //nombre de area no sea una cadena vacia
            Persona profesor = new Profesor(apellidos, nombres, dni, cargo);
            if (!this.listasPersonas.contains(profesor)) {
                this.listasPersonas.add(profesor);
                return EXITO_PROFESOR;
            }
            else
                return DUPLICADO_PROFESOR;
        }else
            return ERROR_PROFESOR;
    }
    
    /**
     *
     * @param cx
     * @return
     */
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

    /**
     *
     * @param documento
     * @return
     */
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
    
    /**
     *
     * @param apellidos
     * @return
     */
    @Override
    public List<Alumno> buscarAlumnos(String apellidos) {
        if (validarAlumno(apellidos) == true) {
            List<Alumno> listaAlumnos = new ArrayList<>();
            
            for (Persona p : listasPersonas) {
                if (p instanceof Alumno) {
                    if (p.getApellidos().toUpperCase().contains(apellidos.toUpperCase())){ //otra forma if(a.getNombre().compareToIgnoreCase(nombre) == 0)
                        listaAlumnos.add((Alumno) p);
                    } 
                }
            }
            return listaAlumnos;
        }
        return null;
    }

    /**
     *
     * @param apellidos
     * @return
     */
    @Override
    public List<Profesor> buscarProfesores(String apellidos) {
        if (validarProfesor(apellidos) == true) {
            List<Profesor> listaProfesores = new ArrayList<>();
            
            for (Persona p : listasPersonas) {
                if (p instanceof Profesor) {
                    if (p.getApellidos().toUpperCase().contains(apellidos.toUpperCase())){ //otra forma if(a.getNombre().compareToIgnoreCase(nombre) == 0)
                        listaProfesores.add((Profesor) p);
                    }
                }
            }
            return listaProfesores;
        }
        return null;
    }

    /**
     *
     */
    @Override
    public void mostrarPersonas() {
        for(Persona p : listasPersonas)
            System.out.println(p);
    }

    /**
     *
     */
    @Override
    public void mostrarAlumnos() {
        for(Persona p : listasPersonas){
            if (p instanceof Alumno)
                System.out.println(p);
        }
    }

    /**
     *
     */
    @Override
    public void mostrarProfesores() {
        for(Persona p : listasPersonas){
            if (p instanceof Profesor)
                System.out.println(p);
        }    
    }
    
    private static boolean validarAlumno(String apellidos){
        if (apellidos == null || apellidos.trim().isEmpty()) {
            return false;
        }
        return true;
    }
    
    private static boolean validarProfesor(String apellidos){
        if (apellidos == null || apellidos.trim().isEmpty()) {
            return false;
        }
        return true;
    }
    
    private static boolean validarAlumno(String apellidos, String nombres, int dni, String cx){
        if (apellidos == null || apellidos.trim().isEmpty()) {
            return false;
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            return false;
        }
        if (dni < 0) {
            return false;
        }
        if (cx == null) {
            return false;
        }
        
        return true;
    }

    private static boolean validarProfesor(String apellidos, String nombres, int dni, Cargo cargo){
        if (apellidos == null || apellidos.trim().isEmpty()) {
            return false;
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            return false;
        }
        if (dni < 0) {
            return false;
        }
        if (cargo == null) {
            return false;
        }
        
        return true;
    }

    /**
     *
     * @param alumno
     * @param apellidos
     * @param nombres
     * @param cx
     * @return
     */
    @Override
    public String modificarAlumno(Alumno alumno, String apellidos, String nombres, String cx) {
        
        if (listasPersonas.contains(alumno)) {
            if (!apellidos.trim().isEmpty() && !apellidos.equals(null) && !nombres.trim().isEmpty() && !nombres.equals(null) && (cx != null)) {
                alumno.setApellidos(apellidos);
                alumno.setNombres(nombres);
                alumno.setCx(cx);
                return "Los datos del alumno fueron modificados correctamente\n";
            }else {
                return "Los datos ingresados no son correctos\n";
            }
        }
        return "No se encontro al alumno";
    }

    /**
     *
     * @param profesor
     * @param apellidos
     * @param nombres
     * @param cargo
     * @return
     */
    @Override
    public String modificarProfesor(Profesor profesor, String apellidos, String nombres, Cargo cargo) {
            
        if (listasPersonas.contains(profesor)) {
            if (!apellidos.trim().isEmpty() && !apellidos.equals(null) && !nombres.trim().isEmpty() && !nombres.equals(null) && (cargo != null)) {
                profesor.setApellidos(apellidos);
                profesor.setNombres(nombres);
                profesor.setCargo(cargo);
                return "Los datos del profesor fueron modificados correctamente\n";
            }else {
                return "Los datos profesor no son correctos\n";
            }
        }
        return "No se encontro al profesor";
    }

    /**
     *
     * @param alumno
     * @return
     */
    @Override
    public String borrarAlumno(Alumno alumno) {
        GestorTrabajos gT = GestorTrabajos.instanciar();
        
        //Busco si el alumno se encuentra en algun trabajo
        if (listasPersonas.contains(alumno)) {
            for (Trabajo t : gT.getListasTrabajos()) {
                for( AlumnoEnTrabajo al : t.getAlumnoEnTrabajo() ){
                    if (al.getUnAlumno().equals(alumno)){
                        return "\tEl alumno buscado esta asociado a un trabajo.";
                    }
                }  
            }
            //Si no se encontro en ningun alumnoentrabajo, entonces lo borro de la lista
            listasPersonas.remove(alumno);
            return "\tEl alumno fue borrado exitosamente";       
        }
        return "\t No se encontró al alumno";
    }

    /**
     *
     * @param profesor
     * @return
     */
    @Override
    public String borrarProfesor(Profesor profesor) {
        GestorTrabajos gT = GestorTrabajos.instanciar();
         
        //LO BUSCO EN ROLES EN TRABAJO
        if (listasPersonas.contains(profesor)) {
            for (Trabajo t : gT.getListasTrabajos()) {
                for( RolEnTrabajo ret : t.getRolEnTrabajo()){
                    if (ret.getUnProfesor().equals(profesor)){
                        return "\tEl profesor buscado esta asociado a un trabajo.";
                    }
                }  
            }
            //Si no se encontro en ningun rolentrabajo, entonces lo borro de la lista
            listasPersonas.remove(profesor);
            return "\tEl profesor fue borrado exitosamente";                
        }
        return "\t No se encontró al profesor";
    }
}
