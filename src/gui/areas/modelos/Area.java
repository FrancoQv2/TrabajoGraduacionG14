/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.areas.modelos;

import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Area implements Comparable<Area>{
    private String nombre;

    
    public Area(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void mostrarAreas(){
        System.out.println("\tArea: " + this.nombre);
    }

    @Override
    public String toString() {
        return "Area: " + this.nombre;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Area other = (Area) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    //IMPLEMENTO EL COMPARABLE EN AREA PARA QUE EL
    //COLLECTIONS.SORT() ORDENE LAS AREAS SEGUN EL NOMBRE CUANDO SE LO LLAME
    @Override
    public int compareTo(Area a) {
        return this.nombre.compareTo(a.nombre);
    }
    
}
