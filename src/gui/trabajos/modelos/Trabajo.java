/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.areas.modelos.Area;
import gui.seminarios.modelos.Seminario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Trabajo {
    private String titulo;
    private String area;
    private int duracion;
    private LocalDate fechaPresentacion;
    private LocalDate fechaAprobacion;
    private LocalDate fechaFinalizacion;
    
    private ArrayList<Area> areas;
    private ArrayList<AlumnoEnTrabajo> alumnoEnTrabajo;
    private ArrayList<Seminario> seminario = new ArrayList<>();
    private ArrayList<RolEnTrabajo> rolEnTrabajo;

    
    //NO LO USAMOS CREO
    public Trabajo(String titulo, String area, int duracion, 
            LocalDate fechaPresentacion, 
            LocalDate fechaAprobacion, LocalDate fechaFinalizacion) {
        this.titulo = titulo;
        this.area = area;
        this.duracion = duracion;
        this.fechaPresentacion = fechaPresentacion;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    //SE LO LLAMA DESDE EL MAIN
    public Trabajo(String titulo, ArrayList<Area> areas, int duracion, 
            LocalDate fechaPresentacion, LocalDate fechaAprobacion, ArrayList<AlumnoEnTrabajo> alumnoEnTrabajo, 
            ArrayList<RolEnTrabajo> rolEnTrabajo) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.fechaPresentacion = fechaPresentacion;
        this.areas = areas;
        this.alumnoEnTrabajo = alumnoEnTrabajo;
        this.rolEnTrabajo = rolEnTrabajo;
    }

    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public LocalDate getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDate fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void mostrar(){
    
            System.out.println("\t\tTitulo: " + this.getTitulo());
            System.out.println("\t\tDuracion: " + this.getDuracion());
            
            
            for (Area A : areas) {
            System.out.println("\t\tArea: " + A);
            }
            
            System.out.println("\t\tFecha Presentacion: " + this.getFechaPresentacion());
            
            if ( this.getFechaAprobacion() != null){
            System.out.println("\t\tFecha Aprobacion: " + this.getFechaAprobacion());
            } else 
                    { System.out.println("\t\tFecha Aprobacion: - ");
                }
            
            if ( this.getFechaFinalizacion() != null){
            System.out.println("\t\tFecha Finalizacion: " + this.getFechaFinalizacion() + "\n" );
            } else 
                    { System.out.println("\t\tFecha Finalizacion: - \n");
                }
            
    }
    
    

    public String agregarProfesor(RolEnTrabajo rolEnTrabajooo){
        if(!rolEnTrabajo.contains(rolEnTrabajooo)) {
            rolEnTrabajo.add(rolEnTrabajooo);
            return "Se agregó un profesor jurado" ; 
        }
        else
            return "No se agregó un profesor jurado";
    }

        public String agregarSeminario(Seminario unSeminario){
        if(!seminario.contains(unSeminario)) {
            seminario.add(unSeminario);
            return "Se agregó un seminario" ; 
        }
        else
            return "No se agregó un seminario";
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.titulo);
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
        final Trabajo other = (Trabajo) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }
    
    
    
}
