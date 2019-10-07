/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seminarios.modelos;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author estudiante
 */
public class Seminario {
    private LocalDate fechaExposicion;
    private String observaciones;
    
    private NotaAprobacion notaAprobacion;

    public Seminario(LocalDate fechaExposicion, String observaciones) {
        this.fechaExposicion = fechaExposicion;
        this.observaciones = observaciones;
    }

    public Seminario(LocalDate fechaExposicion, NotaAprobacion notaAprobacion, String observaciones) {
        this.fechaExposicion = fechaExposicion;
        this.notaAprobacion = notaAprobacion;
        this.observaciones = observaciones;
    }
    


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFechaExposicion() {
        return fechaExposicion;
    }

    public void setFechaExposicion(LocalDate fechaExposicion) {
        this.fechaExposicion = fechaExposicion;
    }
    
    public void mostrar(){
        System.out.println("\t\tFecha de exposicion: " + this.getFechaExposicion());
        System.out.println("\t\tObservaciones: " + this.getObservaciones());        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.fechaExposicion);
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
        final Seminario other = (Seminario) obj;
        if (!Objects.equals(this.fechaExposicion, other.fechaExposicion)) {
            return false;
        }
        return true;
    }
    
    
}
