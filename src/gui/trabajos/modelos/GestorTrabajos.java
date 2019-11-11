/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.trabajos.modelos;


import gui.areas.modelos.Area;
import gui.interfaces.IGestorTrabajos;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.Profesor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabinete
 */
public class GestorTrabajos implements IGestorTrabajos{

    private List<Trabajo> listasTrabajos = new ArrayList<>();
    
    private static GestorTrabajos gestor;
    
    private GestorTrabajos(){
    }
    
    public static GestorTrabajos instanciar(){
        if (gestor == null)
            gestor = new GestorTrabajos();
        return gestor;
    }

    public List<Trabajo> getListasTrabajos() {
        return listasTrabajos;
    }

    public void setListasTrabajos(List<Trabajo> listasTrabajos) {
        this.listasTrabajos = listasTrabajos;
    }
    
    
    @Override
    public String nuevoTrabajo (String titulo, List<Area> area, int duracion, 
                                LocalDate fechaPresentacion, LocalDate fechaAprobacion, 
                                List<AlumnoEnTrabajo> listaAlumnoEnT, List<RolEnTrabajo> listaRolEnT) {
        
        if (verificarTrabajo(titulo, area, duracion, fechaPresentacion, fechaAprobacion, listaAlumnoEnT, listaRolEnT) == true) {
            
            Trabajo unTrabajo = new Trabajo(titulo, area, duracion, fechaPresentacion, fechaAprobacion, listaAlumnoEnT, listaRolEnT);
            if (!this.listasTrabajos.contains(unTrabajo)) {
                this.listasTrabajos.add(unTrabajo);
                return EXITO_TRABAJO;
            } else
                return DUPLICADO_TRABAJO;
        } 
        return ERROR_TRABAJO;
    }

    
    @Override
    public void mostrarTrabajos() {
        for(Trabajo t : listasTrabajos)
            System.out.println(t);
    }

    
    @Override
    public Trabajo dameTrabajo(String titulo) {
//        if (titulo != null && !titulo.trim().isEmpty()) {
        for(Trabajo t : listasTrabajos){
//            if (titulo != null && !titulo.trim().isEmpty()) {
                if (t.getTitulo().equalsIgnoreCase(titulo))
                    return t;
//                }
            }
//        } else
        return null;
    }

    
    @Override
    public List<Trabajo> buscarTrabajos(String filtro) {
        if (filtro != null && !filtro.trim().isEmpty()) {
            List<Trabajo> trabajosBuscadas = new ArrayList<>();
            for(Trabajo t : listasTrabajos){
                if (t.getTitulo().toUpperCase().contains(filtro.toUpperCase())){ //otra forma if(a.getNombre().compareToIgnoreCase(nombre) == 0)
                    trabajosBuscadas.add(t);
                } //else
//                   return new ArrayList<Area>(); 
            }
            return trabajosBuscadas;
        }
        return listasTrabajos;
    }
    
    
    private boolean verificarTrabajo (String titulo, List<Area> area, int duracion, 
                                            LocalDate fechaPresentacion, LocalDate fechaAprobacion, 
                                            List<AlumnoEnTrabajo> listaAlumnoEnT, 
                                            List<RolEnTrabajo> listaRolEnT){ 
        
        //VERIFICO EL TITULO
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("\tERROR - El titulo del trabajo es incorrecto");
            return false;
        }  
      
        
        //VERIFICO LA DURACION 
        if (duracion <= 0) {
            System.out.println("\tERROR - La duracion del trabajo es incorrecta");
            return false;
        } 
      
        
        //VERIFICO QUE LA FECHA DE PRESENTACION NO SEA NULA
        if (fechaPresentacion == null){
            System.out.println("\tERROR - La fecha de presentacion del trabajo es incorrecta");
            return false;
        }
       
        if (fechaAprobacion == null) {
            System.out.println("\tERROR - La fecha de aprobacion del trabajo es incorrecta");
            return false;
        }
        
        //VERIFICO QUE LA FECHA DE APROBACION NO SEA ANTERIOR A LA DE PRESENTACION
//        if(fechaAprobacion != null){
            if (!fechaAprobacion.isEqual(fechaPresentacion) && !fechaAprobacion.isAfter(fechaPresentacion)) {
                System.out.println("\tERROR - La fecha de aprobacion del trabajoes incorrecta");  
                return false;
            }
//        }
        
            
        //VERIFICO QUE EL TRABAJO TENGA AL MENOS UN AREA (NO SEA NULA Y NO SEA VACIA)
        if (area == null || area.isEmpty()) {
            System.out.println("\tERROR - El area del trabajo es incorrecta");
            return false;
        }
        
        
        //VERIFICO QUE HAYA AL MENOS UN ALUMNO
        if (listaAlumnoEnT == null || listaAlumnoEnT.isEmpty()) {
            System.out.println("\tERROR - La lista de alumnos en trabajo es incorrecta");
            return false;
        }
        
        
        //VERIFICO QUE SI HAY MAS DE UN ALUMNO SEAN DISTINTOS (EN TEORIA SE SUPONE QUE ANDA)
        if (listaAlumnoEnT.size() > 1) {
            for (AlumnoEnTrabajo aet1 : listaAlumnoEnT) {
                int contador = 0;
                for (AlumnoEnTrabajo aet2 : listaAlumnoEnT) {
                    if (aet1.equals(aet2)){
                       contador++;
                    }
                    if (contador > 1) {
                        System.out.println("\tERROR - Dos alumnos en trabajo no pueden ser iguales");
                        return false;
                    }
                }
            }
        }
                
        //VERIFICO QUE AUNQUE SEA HAYA UN TUTOR
        if ((listaRolEnT == null) || (listaRolEnT.isEmpty())) {
            System.out.println("\tERROR - La lista de roles en trabajo es incorrecta");
            return false;
        }
            
        Profesor tutor = null;
      
        for (RolEnTrabajo ret :listaRolEnT){
            if( ret.getRol().name().equals(Rol.TUTOR.name()) ){
                tutor = ret.getUnProfesor();
            }
        }

        if (tutor == null) {
            System.out.println("\tERROR - No hay tutor");
            return false;
        }
        
        for (RolEnTrabajo ret1 : listaRolEnT){
            for (RolEnTrabajo ret2 : listaRolEnT){
                if (ret1.getRol().name().equals(Rol.TUTOR.name()) && ret2.getRol().name().equals(Rol.TUTOR.name())) {
                }else{
                    if (ret1.getRol().name().equals(Rol.TUTOR.name())) {
                        if (ret2.getRol().name().equals(Rol.COTUTOR.name())) {
                            if (ret1.getUnProfesor().equals(ret2.getUnProfesor())) {
                                System.out.println("\tERROR - El cotutor no puede ser el mismo que el tutor");
                                return false;
                            }
                        }
                    }
                }
            }
        }
    

        //VERIFICO LOS JURADOS
        List<Profesor> listaJurado = new ArrayList<>();
        
        for(RolEnTrabajo ret : listaRolEnT){
            if (ret.getRol().name().equals(Rol.JURADO.name())) {
                listaJurado.add(ret.getUnProfesor());
            }
        }
//        
        if (listaJurado.size() != 3) {
            System.out.println("\tERROR - El jurado debe tener tres integrantes");
            return false;
        }
        
        if (listaJurado.size() == 3) {
            if ((listaJurado.get(0).equals(listaJurado.get(1))) || 
                (listaJurado.get(1).equals(listaJurado.get(2))) || 
                (listaJurado.get(2).equals(listaJurado.get(0)))) {
                
                System.out.println("\tERROR - Los integrantes del jurado deben ser distintos entre si");
                return false;
            }
        }
        
    return true;
    }

    
    @Override
    public String finalizarTrabajo(Trabajo trabajo, LocalDate fechaExposicion) {
        
        if (fechaExposicion.isAfter(trabajo.getFechaAprobacion())){
            if (listasTrabajos.contains(trabajo)) {
                trabajo.setFechaFinalizacion(fechaExposicion);
                
                for(RolEnTrabajo ret : trabajo.getRolEnTrabajo()){
                    ret.setFechaHasta(fechaExposicion);
                }
                
                for(AlumnoEnTrabajo aet : trabajo.getAlumnoEnTrabajo()){
                    aet.setFechaHasta(fechaExposicion);
                }
                
                return "El trabajo se finalizo con exito\n";  
            }
        }
        return "La fecha es invalida\n";
    }

        
    @Override
    public String borrarTrabajo(Trabajo trabajo) {
        if(trabajo.getSeminario().isEmpty()){
            listasTrabajos.remove(trabajo);
            return "El trabajo se elimino con exito\n";
        }
        return "El trabajo no se puede eliminar porque hay un seminario vinculado a el\n";
    }

    @Override
    public String reemplazarProfesor(Trabajo trabajo, Profesor profesorReemplazado, LocalDate fechaHasta, String razon, Profesor nuevoProfesor) {
        if (listasTrabajos.contains(trabajo)) {
            //SE FIJA QUE EL PROFESOR NUEVO NO ESTE CUMPLIENDO YA UN ROL EN TRABAJO
            for(RolEnTrabajo ret1 : trabajo.getRolEnTrabajo()){
                if (ret1.getUnProfesor().equals(nuevoProfesor)) {
                    return "El nuevo profesor ya se encuentra cumpliendo un rol en el trabajo";
                }
            }
            //REEMPLAZA UN PROFESOR POR UNO NUEVO SI LA FECHA HASTA ES VALIDA
            for (RolEnTrabajo ret : trabajo.getRolEnTrabajo()) {
                if (ret.getUnProfesor().equals(profesorReemplazado)) {
                    if(fechaHasta.isAfter(ret.getFechaDesde())){
                        ret.setFechaHasta(fechaHasta);
                        ret.setRazon(razon);
                        trabajo.getRolEnTrabajo().add(new RolEnTrabajo(fechaHasta, nuevoProfesor, ret.getRol() ));
                        return "El profesor fue reemplazado exitosamente\n";
                    } else { 
                        return "La fecha no es valida\n";
                    }
                }
            }  
        }
        return "No se encontro el trabajo \n";
    }

    @Override
    public String finalizarAlumno(Trabajo trabajo, Alumno alumno, LocalDate fechaHasta, String razon) {
        if (listasTrabajos.contains(trabajo)) {
            //BUSCA AL ALUMNO DENTRO DEL TRABAJO
            for(AlumnoEnTrabajo aet : trabajo.getAlumnoEnTrabajo()){
                if (aet.getUnAlumno().equals(alumno)) {
                    //ENCONTRADO EL ALUMNO, FINALIZA SU PARTICIPACION EN EL TRABAJO SI LA FECHA ES VALIDA
                    if (fechaHasta.isAfter(aet.getFechaDesde())) {
                        aet.setFechaHasta(fechaHasta);
                        aet.setRazon(razon);
                        return "El alumno fue dado de baja exitosamente\n";
                    } else {
                        return "La fecha es invalida\n";
                    }
                }
            }
        }
        return "No se encontro el trabajo\n";
    }
    
}
