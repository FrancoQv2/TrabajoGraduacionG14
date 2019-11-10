/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.interfaces;

import gui.personas.modelos.Alumno;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.Profesor;
import java.util.List;

/**
 *
 * @author gabinete
 */
public interface IGestorPersonas {
    
    public static final String EXITO_ALUMNO = "El alumno se creó correctamente";
    public static final String DUPLICADO_ALUMNO = "El alumno ya fue creado anteriormente";
    public static final String ERROR_ALUMNO = "El alumno no pudo ser creado";

    public static final String EXITO_PROFESOR = "El profesor se creó correctamente";
    public static final String DUPLICADO_PROFESOR = "El profesor ya fue creado anteriormente";
    public static final String ERROR_PROFESOR = "El profesor no pudo ser creado";
    
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx);    
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo);

    public Alumno dameAlumno(String cx);    
    public Profesor dameProfesor(int documento);
       
    public List<Alumno> buscarAlumnos(String apellidos);    
    public List<Profesor> buscarProfesores(String apellidos);
   
    public void mostrarPersonas();
    public void mostrarAlumnos();
    public void mostrarProfesores();
    
    public String modificarAlumno(Alumno alumno, String apellidos, String nombres, String cx);
    public String modificarProfesor(Profesor profesor, String apellidos, String nombres, Cargo cargo);
    
    public String borrarAlumno(Alumno alumno);
    public String borrarProfesor(Profesor profesor);
}
