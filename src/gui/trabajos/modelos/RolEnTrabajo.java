/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.trabajos.modelos;

import gui.personas.modelos.Profesor;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author estudiante
 */
public class RolEnTrabajo {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String razon;
    
    private Profesor unProfesor;
    private Rol rol;

    //CREO QUE NO LO USAMOS
    public RolEnTrabajo(LocalDate fechaDesde, LocalDate fechaHasta, String razon) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.razon = razon;
    }

    //SE LO LLAMA DESDE EL MAIN     
    public RolEnTrabajo(LocalDate fechaDesde, Profesor unProfesor, Rol rol) {
        this.fechaDesde = fechaDesde;
        this.unProfesor = unProfesor;
        this.rol = rol;
    }

    RolEnTrabajo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.unProfesor);
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
        final RolEnTrabajo other = (RolEnTrabajo) obj;
        if (!Objects.equals(this.unProfesor, other.unProfesor)) {
            return false;
        }
        return true;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Profesor getUnProfesor() {
        return unProfesor;
    }

    public void setUnProfesor(Profesor unProfesor) {
        this.unProfesor = unProfesor;
    }
}
