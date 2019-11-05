package gui.trabajos.modelos;


import gui.areas.modelos.Area;
import gui.interfaces.IGestorTrabajos;
import gui.personas.modelos.Profesor;
import java.time.LocalDate;
import java.util.ArrayList;

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

    private ArrayList<Trabajo> listasTrabajos = new ArrayList<>();
    
    private static GestorTrabajos gestor;
    
    private GestorTrabajos(){
    }
    
    public static GestorTrabajos instanciar(){
        if (gestor == null)
            gestor = new GestorTrabajos();
        return gestor;
    }
    
    
    @Override
    public String nuevoTrabajo (String titulo, ArrayList<Area> area, int duracion, 
                                LocalDate fechaPresentacion, LocalDate fechaAprobacion, 
                                ArrayList<AlumnoEnTrabajo> listaAlumnoEnT, ArrayList<RolEnTrabajo> listaRolEnT) {
        
        if (verificarTrabajo(titulo, area, duracion, fechaPresentacion, fechaAprobacion, listaAlumnoEnT, listaRolEnT) == true) {
            
            Trabajo unTrabajo = new Trabajo(titulo, area, duracion, fechaPresentacion, fechaAprobacion, listaAlumnoEnT, listaRolEnT);
            if (!this.listasTrabajos.contains(unTrabajo)) {
                this.listasTrabajos.add(unTrabajo);
                return EXITO;
            } else
                return DUPLICADO;
        } else
        return ERROR;
    }

    
    @Override
    public void mostrarTrabajos() {
        for(Trabajo t : listasTrabajos)
            System.out.println(t);
    }

    
    @Override
    public Trabajo dameTrabajo(String titulo) {
        for(Trabajo t : listasTrabajos){
            if (t.getTitulo().equalsIgnoreCase(titulo))
                return t;
        }
        return null;
    }

    
    @Override
    public ArrayList<Trabajo> buscarTrabajos(String filtro) {
        if (filtro != null && !filtro.trim().isEmpty()) {
            ArrayList<Trabajo> trabajosBuscadas = new ArrayList<>();
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
    
    
    private static boolean verificarTrabajo (String titulo, ArrayList<Area> area, int duracion, 
                                            LocalDate fechaPresentacion, LocalDate fechaAprobacion, 
                                            ArrayList<AlumnoEnTrabajo> listaAlumnoEnT, 
                                            ArrayList<RolEnTrabajo> listaRolEnT){ 
        
        //VERIFICO EL TITULO
        if (titulo.trim().isEmpty() && titulo.equals(null)) {
            return false;
        }  
      
        
        //VERIFICO LA DURACION 
        if (duracion < 0) {
            return false;
        } 
      
        
        //VERIFICO QUE LA FECHA DE PRESENTACION NO SEA NULA
        if (fechaPresentacion == null){
            return false;
        }
       
        
        //VERIFICO QUE LA FECHA DE APROBACION NO SEA ANTERIOR A LA DE PRESENTACION
        if(fechaAprobacion != null){
            if (!fechaAprobacion.isEqual(fechaPresentacion) && !fechaAprobacion.isAfter(fechaPresentacion)) {
                  return false;
            }
        }
        
            
        //VERIFICO QUE EL TRABAJO TENGA AL MENOS UN AREA (NO SEA NULA Y NO SEA VACIA)
        if ((area == null) || (area.isEmpty())) {
            return false;
        }
        
        
        //VERIFICO QUE HAYA AL MENOS UN ALUMNO
        if ((listaAlumnoEnT == null) || (listaAlumnoEnT.isEmpty())) {
            return false;
        }
        
        
        //VERIFICO QUE SI HAY MAS DE UN ALUMNO SEAN DISTINTOS (EN TEORIA SE SUPONE QUE ANDA)
        //PUEDO USAR UN COMPARATOR DESPUES!!
        if (listaAlumnoEnT.size() >= 1) {
//            AlumnoEnTrabajo aet0 = new AlumnoEnTrabajo();
//            aet0 = listaAlumnoEnT.get(0);
//            if (!listaAlumnoEnT.stream().noneMatch((aet) -> (listaAlumnoEnT.get(0).equals(aet)))) {            
            for(AlumnoEnTrabajo aet : listaAlumnoEnT){
                if (listaAlumnoEnT.get(0).equals(aet)) {
                    return false;
                }
            }
        }
                
        
        //VERIFICO QUE HAYA UN TUTOR Y/O COTUTOR
        if ((listaRolEnT == null) || (listaRolEnT.isEmpty())) {
            return false;
        }
        
        //VERIFICO QUE SI HAY COTUTOR SEA DISTINTO AL TUTOR (BUENO ESO INTENTE AL MENOS)
        //PARECE QUE TAMBIEN CONTEMPLA QUE LOS JURADOS SEAN DISTINTOS DE LOS OTROS
        if (listaRolEnT.size() > 1) {
            RolEnTrabajo ret0 = new RolEnTrabajo();
            ret0 = listaRolEnT.get(0);
            
            for(RolEnTrabajo ret : listaRolEnT){
                if (ret0.equals(ret)) {
                    return false;
                }
            }
        }
        
        
        //VERIFICO LOS JURADOS
        ArrayList<Profesor> listaJurado = new ArrayList<>();
        for(RolEnTrabajo ret : listaRolEnT){
            if (ret.getRol().equals("JURADO") ) {
                listaJurado.add(ret.getUnProfesor());
            }
        }
        
        if (listaJurado.size() != 3) {
            return false;
        }
        
        if (listaJurado.size() == 3) {
            if ((listaJurado.get(0).equals(listaJurado.get(1))) || 
                (listaJurado.get(1).equals(listaJurado.get(2))) || 
                (listaJurado.get(2).equals(listaJurado.get(0)))) {
                
                return false;
            }
        }
        
        if (fechaAprobacion == null) {
            listaJurado.clear();
        }
        
    return true;
    }
    
}
