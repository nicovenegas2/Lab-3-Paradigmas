/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plataforma;

import java.util.LinkedList;

/**
 *
 * @author nicov
 */
class Acceso {
    private String nombre;
    LinkedList<String> accesos = new LinkedList<String>();

    public Acceso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<String> getAccesos() {
        return accesos;
    }

    public void setAccesos(LinkedList<String> accesos) {
        this.accesos = accesos;
    }
    
}
