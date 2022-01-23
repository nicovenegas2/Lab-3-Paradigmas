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
public class Paradigmadocs {
    private String nombre;
    private Date creacion;
    LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
    private Usuario activo;

    public Paradigmadocs(String nombre, Date creacion) {
        this.nombre = nombre;
        this.creacion = creacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getActivo() {
        return activo;
    }

    public void setActivo(Usuario activo) {
        this.activo = activo;
    }
    
    public Boolean isLogin(){
        return this.activo != null;
    }
    
    public void logOut(){
        this.setActivo(null);
    }
    public boolean register(String user, String pass){
        for(Usuario usuario: this.usuarios){
            if (usuario.getName().equals(user))
                return false;
        }
        Usuario newUser;
        newUser = new Usuario(user, pass);
        this.usuarios.add(newUser);
        return true;
    }
    
    public boolean login(String user, String pass){
        for(Usuario usuario: this.usuarios){
            if (usuario.canLogin(user, pass)){
                this.setActivo(usuario);
                return true;
            }
        }
        return false;
    }
    
    
    
    
}
