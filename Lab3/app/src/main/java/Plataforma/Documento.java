package Plataforma;

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
    private Date fechaCreacion;
    private Date fechaModificacion;
    private LinkedList<Version> versiones = new LinkedList<Version>();
    private LinkedList<Acceso> accesos = new LinkedList<Acceso>();

    public Documento(String name, Date creacion) {
        this.id = Documento.documentosTotales;
        Documento.documentosTotales++;
        this.fechaCreacion = creacion;
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
    
    
    
    
    
}
