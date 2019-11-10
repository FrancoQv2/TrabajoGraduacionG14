/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.seminarios.modelos;

/**
 *
 * @author estudiante
 */
public enum NotaAprobacion {
    APROBADO_SINOBS, APROBADO_CONOBS, DESAPROBADO;
    
    @Override
    public String toString() {
        
        if(this == this.APROBADO_CONOBS || this == this.APROBADO_SINOBS){
            return "Aprobado";
        }
        
        return "Desaprobado";
    }
}
