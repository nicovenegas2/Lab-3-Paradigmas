/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.LinkedList;

/**
 *
 * @author nicov
 */
class Acceso {
    private String nombre;
    char tipo;

    public Acceso(String nombre, char type) {
        this.nombre = nombre;
        this.tipo = type;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    
}
