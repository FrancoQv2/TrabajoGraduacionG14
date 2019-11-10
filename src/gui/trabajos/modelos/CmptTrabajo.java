/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.trabajos.modelos;

import java.util.Comparator;

/**
 *
 * @author franc
 */
public class CmptTrabajo  implements Comparator<Trabajo>{

    @Override
    public int compare(Trabajo t1, Trabajo t2) {
        if(t1.getFechaPresentacion() == t2.getFechaPresentacion()){
            return t1.getTitulo().compareTo(t2.getTitulo());
        }
        else if(t1.getFechaPresentacion().isAfter(t2.getFechaPresentacion()))
            return -1;
        else
            return 1;
    }
    
}
