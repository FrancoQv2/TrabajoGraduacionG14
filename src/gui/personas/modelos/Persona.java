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
public abstract class Persona {
    protected String apellidos;
    protected String nombres;
    protected int dni;

    public Persona(String apellidos, String nombres, int dni) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.dni = dni;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void mostrar(){
        System.out.print("\n\t[" + this.dni + "] " + this.apellidos.toUpperCase() + ", " + this.nombres);
    }
    
    @Override
    public String toString() {
        return "[" + this.dni + "] " + this.apellidos + ", " + this.nombres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.dni;
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
        final Persona other = (Persona) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }
}
