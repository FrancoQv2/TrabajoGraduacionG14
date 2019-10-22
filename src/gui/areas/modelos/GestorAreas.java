/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.areas.modelos;

import gui.interfaces.IGestorAreas;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public class GestorAreas implements IGestorAreas{
    
    private ArrayList<Area> listasAreas = new ArrayList<Area>();
    
    private static GestorAreas gestor;
    
    //Constructor privado
    private GestorAreas(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorAreas instanciar(){
        if (gestor == null)
            gestor = new GestorAreas();
        return gestor;
    }
    
    @Override
    public String nuevaArea(String nombre){
        if (!nombre.trim().isEmpty() && !nombre.equals(null)) {     //nombre de area no sea una cadena vacia
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
    
    @Override
    public void mostrarAreas(){
        for(Area a : listasAreas)
            System.out.println(a);
    }
    
    @Override
    public Area dameArea(String nombre){
        for(Area a : listasAreas){
            if (a.getNombre().equalsIgnoreCase(nombre))
                return a;
        }
        return null;  
    }
    
    @Override
    public ArrayList<Area> buscarAreas(String nombre){
        if (nombre != null && !nombre.trim().isEmpty()) {
            ArrayList<Area> areasBuscadas = new ArrayList<>();
            for(Area a : listasAreas){
                if (a.getNombre().toUpperCase().contains(nombre.toUpperCase())) //otra forma if(a.getNombre().compareToIgnoreCase(nombre) == 0)
                    areasBuscadas.add(a);
            }
            return areasBuscadas;
        }else
//            return listasAreas;  //DEVUELVE LA LISTA COMPLETA, NO UNA VACIA
            return new ArrayList<Area>();  //PARA QUE DEVUELVA UNA LISTA VACIA COMO PIDE EL ENUNCIADO
    }
    
    
}
