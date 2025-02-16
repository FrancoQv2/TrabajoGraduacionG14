/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.trabajos.modelos;

import gui.areas.modelos.Area;
import gui.seminarios.modelos.GestorSeminarios;
import gui.seminarios.modelos.NotaAprobacion;
import gui.seminarios.modelos.Seminario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static gui.interfaces.IGestorTrabajos.EXITO_TRABAJO;
import static gui.interfaces.IGestorTrabajos.DUPLICADO_TRABAJO;
import static gui.interfaces.IGestorTrabajos.ERROR_TRABAJO;
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
    
    private List<Area> areas;
    private List<AlumnoEnTrabajo> alumnoEnTrabajo;
    private List<Seminario> seminario = new ArrayList<>();
    private List<RolEnTrabajo> rolEnTrabajo;

    
//    //NO LO USAMOS CREO
//    public Trabajo(String titulo, String area, int duracion, 
//            LocalDate fechaPresentacion, 
//            LocalDate fechaAprobacion, LocalDate fechaFinalizacion) {
//        this.titulo = titulo;
//        this.area = area;
//        this.duracion = duracion;
//        this.fechaPresentacion = fechaPresentacion;
//        this.fechaAprobacion = fechaAprobacion;
//        this.fechaFinalizacion = fechaFinalizacion;
//    }

    //SE LO LLAMA DESDE EL MAIN
    public Trabajo(String titulo, List<Area> areas, int duracion, 
                    LocalDate fechaPresentacion, LocalDate fechaAprobacion, 
                    List<AlumnoEnTrabajo> alumnoEnTrabajo, 
                    List<RolEnTrabajo> rolEnTrabajo) {
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

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<AlumnoEnTrabajo> getAlumnoEnTrabajo() {
        return alumnoEnTrabajo;
    }

    public void setAlumnoEnTrabajo(List<AlumnoEnTrabajo> alumnoEnTrabajo) {
        this.alumnoEnTrabajo = alumnoEnTrabajo;
    }

    public List<RolEnTrabajo> getRolEnTrabajo() {
        return rolEnTrabajo;
    }

    public void setRolEnTrabajo(List<RolEnTrabajo> rolEnTrabajo) {
        this.rolEnTrabajo = rolEnTrabajo;
    }

    public List<Seminario> getSeminario() {
        return seminario;
    }

    public void setSeminario(List<Seminario> seminario) {
        this.seminario = seminario;
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
            } else { 
                System.out.println("\t\tFecha Aprobacion: - ");
            }
            
            if (this.getFechaFinalizacion() != null){
                System.out.println("\t\tFecha Finalizacion: " + this.getFechaFinalizacion() + "\n" );
            } else { 
                System.out.println("\t\tFecha Finalizacion: - \n");
            }
    }

//    @Override
//    public String toString() {
//        return "\t\tTitulo: " + this.getTitulo()) + "\t\tDuracion: " + this.getDuracion()) + "\t\tArea: " + this.getAreas() + "\t\tFecha Presentacion: " + this.getFechaPresentacion() + "\t\tFecha Aprobacion: " + this.getFechaAprobacion() + "\t\tFecha Finalizacion: " + this.getFechaFinalizacion() + "\n";    
//    }
    
    

    public String agregarProfesor(RolEnTrabajo rolEnTrabajooo){
        if(!rolEnTrabajo.contains(rolEnTrabajooo)) {
            rolEnTrabajo.add(rolEnTrabajooo);
            return "Se agregó un profesor jurado" ; 
        }
        else
            return "No se agregó un profesor jurado";
    }

    //
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
    
    
    //VER COMO HACER QUE RETORNE EXITO_TRABAJO Y LAS OTRAS CONSTANTES
    public String nuevoSeminario(LocalDate fechaExposicion, NotaAprobacion nota, String observaciones){
        GestorSeminarios gS = GestorSeminarios.instanciar();
        
        if (!gS.validarSeminario(fechaExposicion, nota, observaciones).equals(EXITO_TRABAJO)) {
            return ERROR_TRABAJO;
        }
        
        if (!fechaExposicion.isAfter(fechaAprobacion)) {
            return ERROR_TRABAJO;
        }
        
//        for (Seminario s : gS.getListasSeminarios()){
//            if (!s.equals(gS.getListasSeminarios().get(0))) {
//                gS.getListasSeminarios().add(new Seminario(fechaExposicion, nota, observaciones));
//                return "Se agrego el seminario correctamente";
//            } else
//                return "El seminario ya existe";
//        }
        Seminario sem = new Seminario(fechaExposicion, nota, observaciones);
        
         //Valido que no se haya creado ya este seminario
        if (!gS.getListasSeminarios().contains(sem)) {
            gS.getListasSeminarios().add(sem);
            
            return EXITO_TRABAJO;
        } else {
            return DUPLICADO_TRABAJO;
        }
    }
}
