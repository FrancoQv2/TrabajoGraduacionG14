/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.areas.modelos;

import gui.interfaces.IGestorAreas;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.Trabajo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabinete
 */
public class GestorAreas implements IGestorAreas{
    
    private List<Area> listasAreas = new ArrayList<>();
    
    private static GestorAreas gestor;
    
    private GestorAreas(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorAreas instanciar(){
        if (gestor == null)
            gestor = new GestorAreas();
        return gestor;
    }
    
    public List<Area> getListasAreas(){
        return listasAreas;
    }

    public void setListasAreas(List<Area> listasAreas) {    
        this.listasAreas = listasAreas;
    }

    /**
     *Verifica que el nombre del area no sea nulo ni vacio
     * @param nombre
     * @return true si es valido, false si no lo es
     */
    private boolean verificarNombreArea(String nombre){
        return nombre != null && !nombre.trim().isEmpty();
    }
    
    /**
     *Crea una nueva area si y solo si el area no se ha creado anteriormente
     * @param nombre la cadena a pasar no puede ser vacio ni nulo
     * @return Correspondiente mensaje si el area se creo exitosamente, esta duplicada o
     * si no se la pudo crear
     */
    @Override
    public String nuevaArea(String nombre) {
        if (verificarNombreArea(nombre) == true) {     //nombre de area no sea una cadena vacia
            Area area = new Area(nombre);
            if (!this.listasAreas.contains(area)) {
                this.listasAreas.add(area);
                return EXITO;
            }
            else
                return DUPLICADO;
        }else
            return ERROR;
    }
    
    /**
     *Muestra la lista completa de Areas
     */
    @Override
    public void mostrarAreas(){
        for(Area a : listasAreas)
            System.out.println(a);
    }
    
    /**
     *
     * @param nombre
     * @return el area especificada si la encuentra, sino retorna null
     * 
     */
    @Override
    public Area dameArea(String nombre){
        for(Area a : listasAreas){
            if (a.getNombre().equalsIgnoreCase(nombre))
                return a;
        }
        return null;  
    }
    
    /**
     *
     * @param nombre
     * @return
     */
    @Override
    public List<Area> buscarAreas(String nombre){
        if (verificarNombreArea(nombre) == true) {
            List<Area> areasBuscadas = new ArrayList<>();
            
            for(Area a : listasAreas){
                if (a.getNombre().toUpperCase().contains(nombre.toUpperCase())){ //otra forma if(a.getNombre().compareToIgnoreCase(nombre) == 0)
                    areasBuscadas.add(a);
                } else
                   return null;
                return areasBuscadas;
            }
        }
        return listasAreas;
    }
    
    /**
     *Borra el area indicada si no se encuentra asociada a algun trabajo
     * @param area
     * @return mensaje correspondiente si se realizo o no la accion
     */
    @Override
    public String borrarArea(Area area) {
        GestorTrabajos gT = GestorTrabajos.instanciar();
        
        if (listasAreas.contains(area)) {
            for (Trabajo t : gT.getListasTrabajos()) {
                if (t.getAreas().contains(area)) {         //esto no estaria mal porque la remueve antes de buscar en todas?????
                    return "\tEl area buscada ya esta asociada a un trabajo.";
                } 
            }
            listasAreas.remove(area);
            return "\tEl area fue borrada exitosamente";
        }
        return "\tNo se encontro el area.";
    }
}
