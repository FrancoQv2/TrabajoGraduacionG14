/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.areas.modelos.Area;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public interface IGestorAreas {
    public static final String EXITO = "Se creo el area correctamente";
    public static final String DUPLICADO = "El area ya fue creada";
    public static final String ERROR = "No se pudo crear el area";
    
    
    public String nuevaArea(String nombre);
    
    public void mostrarAreas();
    
    public Area dameArea(String nombre);
    
    public ArrayList<Area> buscarAreas(String nombre);
}
