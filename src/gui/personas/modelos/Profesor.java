/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

/**
 *
 * @author gabinete
 */
public class Profesor extends Persona{
    
    private Cargo cargo;

    public Profesor(String apellidos, String nombres, int dni, Cargo cargo) {
        super(apellidos, nombres, dni);
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + cargo;
    }
    
        
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print("\t" + cargo);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


      
}

