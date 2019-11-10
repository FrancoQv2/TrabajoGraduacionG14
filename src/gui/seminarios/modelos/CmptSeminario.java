/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.seminarios.modelos;

import java.util.Comparator;

/**
 *
 * @author franc
 */
public class CmptSeminario implements Comparator<Seminario>{

    @Override
    public int compare(Seminario s1, Seminario s2) {
        if(s1.getFechaExposicion().equals(s2.getFechaExposicion()))
            return 0;
        else if(s1.getFechaExposicion().isAfter(s2.getFechaExposicion()))
            return -1;
        else
            return 1;
    }
    
}
