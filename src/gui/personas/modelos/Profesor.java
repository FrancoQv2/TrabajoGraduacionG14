/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
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
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print("\t" + this.cargo);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t" + this.cargo;
    }
}

