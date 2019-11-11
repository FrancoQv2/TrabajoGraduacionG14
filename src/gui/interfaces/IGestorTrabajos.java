/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.interfaces;

import gui.areas.modelos.Area;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.Profesor;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.RolEnTrabajo;
import gui.trabajos.modelos.Trabajo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gabinete
 */
public interface IGestorTrabajos {
    public static final String EXITO_TRABAJO = "- El trabajo se creó correctamente\n";
    public static final String DUPLICADO_TRABAJO = "- El trabajo ya fue creado anteriormente\n";
    public static final String ERROR_TRABAJO = "- El trabajo no pudo ser creado\n";
    
    public String nuevoTrabajo (String titulo, List<Area> area, int duracion, LocalDate fechaPresentacion, 
                                LocalDate fechaAprobacion, List <AlumnoEnTrabajo> listaAlumnoEnT, 
                                List <RolEnTrabajo> listaRolEnT);
    public void mostrarTrabajos();
    public Trabajo dameTrabajo(String titulo);
    public List<Trabajo> buscarTrabajos(String filtro);
    
    public String finalizarTrabajo(Trabajo trabajo, LocalDate fechaExposicion);
    public String borrarTrabajo(Trabajo trabajo);
    
    public String reemplazarProfesor(Trabajo trabajo, Profesor profesorReemplazado, LocalDate fechaHasta, String razon, Profesor nuevoProfesor);
    public String finalizarAlumno(Trabajo trabajo, Alumno alumno, LocalDate fechaHasta, String razon);
    
}
