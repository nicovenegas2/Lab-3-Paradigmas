package Lab3;

import java.util.Date;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicov
 */
public class Documento {
    static int documentosTotales = 0;
    private int id;
    private String nombre;
    private String autor;
    private String cont;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private LinkedList<Version> versiones = new LinkedList<Version>();
    private LinkedList<Acceso> accesos = new LinkedList<Acceso>();

    public Documento(String name, String contenido) {
        this.id = Documento.documentosTotales;
        this.nombre = name;
        Documento.documentosTotales++;
        this.cont = contenido;
        this.fechaCreacion = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LinkedList<Version> getVersiones() {
        return versiones;
    }

    public void setVersiones(LinkedList<Version> versiones) {
        this.versiones = versiones;
    }

    public LinkedList<Acceso> getAccesos() {
        return accesos;
    }

    public void setAccesos(LinkedList<Acceso> accesos) {
        this.accesos = accesos;
    }
    
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
    
    
    public int existAcceso(Acceso acc){
        int i=0;
        while (i < this.getAccesos().size()){
            if(this.getAccesos().get(i).getNombre().equals(acc.getNombre()))
                return i;
            i++;
        }
        
        return -1;
    }
    
    
    public boolean SetAcceso(Acceso acc){
        try{
            int i = this.existAcceso(acc);
            if (i != -1){
                this.getAccesos().set(i, acc);
                return true;
            } else {
                this.getAccesos().add(acc);
                return true;
            }
            
        } catch(Error e){
            return false;
        }
        
    }
    
}
