/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.principal.controladores;

import gui.areas.modelos.Area;
import gui.areas.modelos.GestorAreas;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.GestorPersonas;
import gui.personas.modelos.Profesor;
import gui.seminarios.modelos.GestorSeminarios;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.GestorAlumnosEnTrabajo;
import gui.trabajos.modelos.GestorRolEnTrabajo;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.Rol;
import gui.trabajos.modelos.RolEnTrabajo;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class PrincipalTP6{
    public static void main(String Args[]) {
        GestorAreas gsAreas = GestorAreas.instanciar();
        GestorTrabajos gsTrabajos = GestorTrabajos.instanciar();
        GestorPersonas gsPersonas = GestorPersonas.instanciar();
        GestorSeminarios gsSeminarios = GestorSeminarios.instanciar();
        GestorRolEnTrabajo gsRET = GestorRolEnTrabajo.instanciar();
        GestorAlumnosEnTrabajo gsAET = GestorAlumnosEnTrabajo.instanciar();

        System.out.println("***************************AREAS**********************************");
        //***************************AREAS**********************************
        System.out.println(gsAreas.nuevaArea("Software"));
        System.out.println(gsAreas.nuevaArea("Hardware"));
        System.out.println(gsAreas.nuevaArea("Sistemas Embebidos"));
        System.out.println(gsAreas.nuevaArea("Redes"));
        System.out.println(gsAreas.nuevaArea("Redes")); //nombre repetido
        System.out.println(gsAreas.nuevaArea(null)); //nombre nulo
        System.out.println(gsAreas.nuevaArea("")); //nombre vacío

        
        System.out.println("***************************PERSONAS**********************************");
        //***************************PERSONAS**********************************
        System.out.println("---Profesores---");
        System.out.println(gsPersonas.nuevoProfesor("Juárez", "Juan José", 1, Cargo.ASOCIADO));
        System.out.println(gsPersonas.nuevoProfesor("Díaz", "Juan Pablo", 2, Cargo.JTP));
        System.out.println(gsPersonas.nuevoProfesor("Juárez", "Ana María", 3, Cargo.ADJUNTO));
        System.out.println(gsPersonas.nuevoProfesor("San Martín", "José Manuel", 4, Cargo.ADG));
        System.out.println(gsPersonas.nuevoProfesor("Ortega", "Laura", 5, Cargo.ASOCIADO));
        System.out.println(gsPersonas.nuevoProfesor("Rodríguez", "Juliana", 4, Cargo.TITULAR)); //dni repetido con otro profesor 
        System.out.println(gsPersonas.nuevoProfesor(null, "Juliana", 6, Cargo.TITULAR)); //apellido nulo
        System.out.println(gsPersonas.nuevoProfesor("", "Juliana", 6, Cargo.TITULAR)); //apellido vacío
        System.out.println(gsPersonas.nuevoProfesor("Rodríguez",null , 6, Cargo.TITULAR)); //nombre nulo
        System.out.println(gsPersonas.nuevoProfesor("Rodríguez", "", 6, Cargo.TITULAR)); //nombre vacío
        System.out.println(gsPersonas.nuevoProfesor("Rodríguez", "Juliana", 0, Cargo.TITULAR)); //dni <=0
        System.out.println(gsPersonas.nuevoProfesor("Rodríguez", "Juliana", 6, (Cargo) null)); //cargo nulo

        System.out.println("---Alumnos---");
        System.out.println(gsPersonas.nuevoAlumno("Musa", "Ezequiel", 101, "A1"));//EXITO
        System.out.println(gsPersonas.nuevoAlumno("Martinez", "Ricardo Juan", 102, "A9"));//EXITO
        System.out.println(gsPersonas.nuevoAlumno("Gimenez", "María José", 103, "A2"));//EXITO
        System.out.println(gsPersonas.nuevoAlumno("Flores", "Mauricio José", 104, "A3"));//EXITO
        System.out.println(gsPersonas.nuevoAlumno("Campos", "Juan Pablo", 105, "A4"));//EXITO
        System.out.println(gsPersonas.nuevoAlumno("Campos", "Augusto", 104, "A6")); //dni repetido con otro alumno
        System.out.println(gsPersonas.nuevoAlumno("Rodriguez", "Miguel Angel", 106, "A4")); //cx repetido con otro alumno
        System.out.println(gsPersonas.nuevoAlumno("Alvarez", "Ezequiel", 1, "A7")); //dni repetido con un profesor
        System.out.println(gsPersonas.nuevoAlumno(null, "Luciana", 107, "A7")); //apellido nulo
        System.out.println(gsPersonas.nuevoAlumno("", "Luciana", 107, "A7")); //apellido vacío
        System.out.println(gsPersonas.nuevoAlumno("Pérez", null, 107, "A7")); //nombre nulo
        System.out.println(gsPersonas.nuevoAlumno("Pérez", "", 107, "A7")); //nombre vacío
        System.out.println(gsPersonas.nuevoAlumno("Pérez", "Luciana", 0, "A7")); //dni <= 0
        System.out.println(gsPersonas.nuevoAlumno("Pérez", "Luciana", 107, (String) null)); //cx nulo
        System.out.println(gsPersonas.nuevoAlumno("Pérez", "Luciana", 107, "")); //cx vacío

        System.out.println();

//        gsPersonas.mostrarAlumnos());
        gsPersonas.mostrarPersonas();
//       gsPersonas.dameProfesor(1).mostrar();
        
        System.out.println("***************************TRABAJOS**********************************");
        //***************************TRABAJOS**********************************
        LocalDate fechaPresentacion = LocalDate.of(2019, 10, 1);
        LocalDate fechaAprobacion = LocalDate.of(2019, 10, 10);

        RolEnTrabajo RET1 = gsRET.nuevoRolEnTrabajo( fechaAprobacion, (Profesor) gsPersonas.getListasPersonas().get(0), Rol.TUTOR);
        RolEnTrabajo RET2 = gsRET.nuevoRolEnTrabajo( fechaAprobacion,(Profesor) gsPersonas.getListasPersonas().get(1), Rol.COTUTOR);
        RolEnTrabajo RET3 = gsRET.nuevoRolEnTrabajo( fechaAprobacion, (Profesor) gsPersonas.getListasPersonas().get(2), Rol.JURADO);
        RolEnTrabajo RET4 = gsRET.nuevoRolEnTrabajo( fechaAprobacion, (Profesor) gsPersonas.getListasPersonas().get(3), Rol.JURADO);
        RolEnTrabajo RET5 = gsRET.nuevoRolEnTrabajo( fechaAprobacion, (Profesor) gsPersonas.getListasPersonas().get(4), Rol.JURADO);
        
        LocalDate fecha1 = LocalDate.of(2017, 10, 2);
        LocalDate fecha2 = null; 
        LocalDate fecha3 = LocalDate.of(2017, 11, 2);
        LocalDate fecha4= LocalDate.of(2017, 8, 12);
        LocalDate fecha5= LocalDate.of(2017, 9, 12);
        LocalDate fecha6= LocalDate.of(2017, 10, 2);
              
        AlumnoEnTrabajo aET11 = gsAET.nuevoAlumnoEnTrabajo(fecha1, gsPersonas.dameAlumno("A1"));
        AlumnoEnTrabajo aET12 = new AlumnoEnTrabajo(fecha1, gsPersonas.dameAlumno("A2"));
        
        
        
        
//        System.out.println(gsTrabajos.nuevoTrabajo("Protocolos de comunicación", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos()));//Exito
//        System.out.println(gsTrabajos.nuevoTrabajo("", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //título vacío
//        System.out.println(gsTrabajos.nuevoTrabajo(null, 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //sin título
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, null, gsRET.getListaRoles(), gsAET.getListaAlumnos())); //sin áreas
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, new ArrayList<Area>(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //sin áreas
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales",0 , fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //duración <= 0
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, null, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //sin fecha de presentación
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, null, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //sin fecha de aprobación
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaAprobacion, fechaPresentacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //fecha de aprobación anterior a la de presentación
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), null, gsAET.getListaAlumnos())); //sin alumnos
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), new ArrayList<AlumnoEnTrabajo>())); //sin alumnos
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //sin tutor
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //tutor y cotutor iguales
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //jurado con menos de 3 profesores
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //jurado con profesores repetidos
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //el tutor es jurado
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //el cotutor es jurado
//        System.out.println(gsTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 6, fechaPresentacion, fechaAprobacion, gsAreas.getListasAreas(), gsRET.getListaRoles(), gsAET.getListaAlumnos())); //el cotutor es jurado

        gsTrabajos.mostrarTrabajos();

    }
}
