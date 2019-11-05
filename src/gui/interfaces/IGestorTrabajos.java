/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.areas.modelos.Area;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.RolEnTrabajo;
import gui.trabajos.modelos.Trabajo;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public interface IGestorTrabajos {
    public static final String EXITO = "Se creo el trabajo correctamente";
    public static final String DUPLICADO = "El trabajo ya fue creado";
    public static final String ERROR = "No se pudo crear el trabajo";
    
    public String nuevoTrabajo (String titulo, ArrayList<Area> area, int duracion, LocalDate fechaPresentacion, 
                                LocalDate fechaAprobacion, ArrayList <AlumnoEnTrabajo> listaAlumnoEnT, 
                                ArrayList <RolEnTrabajo> listaRolEnT);
    public void mostrarTrabajos();
    public Trabajo dameTrabajo(String titulo);
    public ArrayList<Trabajo> buscarTrabajos(String filtro);
    
}
