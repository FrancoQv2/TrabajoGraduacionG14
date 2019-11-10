/* 
 * Programacion II
 * Caso Practico 2019
 * - Bardin, Pablo Mauricio
 * - Quevedo, Franco
 */
package gui.personas.modelos;

import java.util.Comparator;

/**
 *
 * @author franc
 */
public class CmptApellido implements Comparator<Persona>{

    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getApellidos().compareTo(p2.getApellidos());
    }
    
}
