/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.seminarios.modelos;

import gui.interfaces.IGestorSeminarios;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabinete
 */
public class GestorSeminarios implements IGestorSeminarios{
    
    private List<Seminario> listasSeminarios = new ArrayList<>();
    
    private static GestorSeminarios gestor;
    
    //Constructor privado
    private GestorSeminarios(){
    }
    
    //Metodo estatico para crear una unica instancia de gestorAreas
    public static GestorSeminarios instanciar(){
        if (gestor == null)
            gestor = new GestorSeminarios();
        return gestor;
    }

    public List<Seminario> getListasSeminarios() {
        return listasSeminarios;
    }

    public void setListasSeminarios(List<Seminario> listasSeminarios) {
        this.listasSeminarios = listasSeminarios;
    }
    
    @Override
    public String validarSeminario(LocalDate fechaExposicion, NotaAprobacion nota, String obs) {
        if (fechaExposicion == null) {
            return ERROR;
        }
        if ((nota == NotaAprobacion.APROBADO_CONOBS) || (nota == NotaAprobacion.DESAPROBADO)) {
            if(obs == null || obs.isEmpty()) {
                return ERROR;
            }
        }
        return EXITO;
    }
    
}
