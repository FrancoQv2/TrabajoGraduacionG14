/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.personas.modelos.Profesor;
import gui.trabajos.modelos.Rol;
import gui.trabajos.modelos.RolEnTrabajo;
import java.time.LocalDate;

/**
 *
 * @author estudiante
 */
public interface IGestorRolEnTrabajo {
    public static final String EXITO = "Se creo el rol en trabajo correctamente";
    public static final String DUPLICADO = "El rol en trabajo ya fue creado";
    public static final String ERROR = "No se pudo crear el rol en trabajo";
    
    public RolEnTrabajo nuevoRolEnTrabajo(LocalDate fechaDesde, Profesor unProfesor, Rol unRol);
}
