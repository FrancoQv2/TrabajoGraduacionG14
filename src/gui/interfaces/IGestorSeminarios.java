/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.interfaces;

import gui.seminarios.modelos.NotaAprobacion;
import java.time.LocalDate;

/**
 *
 * @author gabinete
 */
public interface IGestorSeminarios {
    public static final String EXITO = "Se creo el seminario correctamente";
    public static final String DUPLICADO = "El seminario ya fue creado anteriormente";
    public static final String ERROR = "No se pudo crear el seminario";
    
    public String validarSeminario(LocalDate fechaExposicion, NotaAprobacion nota, String obs);
}
