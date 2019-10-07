/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Alumno extends Persona{

    private String cx;
    
    public Alumno(String apellidos, String nombres, int dni, String cx){
        super(apellidos, nombres, dni);
        this.cx = cx;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.getCx(); 
    }

    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print("\t" + this.getCx());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cx);
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
        
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()){
            return false;
        }
        
        
        if (obj.getClass() == Profesor.class) {
            final Persona other1 = (Persona) obj ;
            if (this.getDni() != other1.getDni()) {
               return false;
            }
        }
        else {
        final Alumno other = (Alumno) obj;
            if (!Objects.equals(this.cx, other.cx) && this.getDni() != other.getDni()) {
                return false;
            }
        }
        return true;
    }

 
}
