/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.principal.controladores;

import gui.areas.modelos.Area;
import gui.areas.modelos.GestorAreas;
import java.util.ArrayList;

/**
 *
 * @author gabinete
 */
public class ControladorPrincipal {
    public static void main (String Args[] ) {
    
    //*****************************AREAS***********************************
    GestorAreas gsAreas = GestorAreas.instanciar();
    System.out.println(gsAreas.nuevaArea("Software")); //EXITO
    System.out.println(gsAreas.nuevaArea("Hardware")); //Area creada correcmente
    System.out.println(gsAreas.nuevaArea("Software"));  //DUPLICADO
    System.out.println(gsAreas.nuevaArea(""));  //ERROR
    System.out.println();
    
    gsAreas.mostrarAreas();
    System.out.println();
    
    System.out.println(gsAreas.dameArea(""));
    System.out.println(gsAreas.dameArea("Software"));
    System.out.println(gsAreas.dameArea(null));
    System.out.println();
    
    ArrayList<Area> buscarArea = new ArrayList<Area>();
    
    buscarArea = gsAreas.buscarAreas(null);
    if (buscarArea == null) 
        System.out.println("No se encontro ningun area");
    else
        for(Area a : buscarArea)
            System.out.println(a);
    
    buscarArea = gsAreas.buscarAreas("Software");
    if (buscarArea == null) 
        System.out.println("No se encontro ningun area");
    else
        for(Area a : buscarArea)
            System.out.println(a);
    //*****************************AREAS***********************************
    
    
    //***************************PERSONAS**********************************
    
    //***************************PERSONAS**********************************
    
    
    //****************************TRABAJO**********************************
    
    //****************************TRABAJO**********************************
    
    }
}
