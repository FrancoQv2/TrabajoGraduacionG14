/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.interfaces;

import gui.areas.modelos.Area;
import java.util.List;

/**
 *
 * @author gabinete
 */
public interface IGestorAreas {
    public static final String EXITO = "El area se creó correctamente";
    public static final String DUPLICADO = "El area ya fue creada anteriormente";
    public static final String ERROR = "El area no pudo ser creada";
    
    
    public String nuevaArea(String nombre);
    
    public void mostrarAreas();
    
    public Area dameArea(String nombre);
    
    public List<Area> buscarAreas(String nombre);
    
    public String borrarArea(Area area);
}
