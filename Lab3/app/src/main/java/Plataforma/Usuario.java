package Editor;

import Plataforma.Documento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicov
 */
public class Usuario {
    
    private static int usuariosExistentes = 0;
    private int id;
    private String name;
    private String password;
    private Documento[] documentos;

    public Usuario(String name, String pass) {
        this.id = Usuario.usuariosExistentes;
        Usuario.usuariosExistentes++;
        this.name = name;
        this.password = pass;
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Documento[] getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documento[] documentos) {
        this.documentos = documentos;
    }
    
    // metodo que comprueba si una contraseña y nombre coincide con el usuario
    public Boolean canLogin(String name, String pass){
        if (this.name.equals(name) && this.password.equals(pass)) {return true;}
        return false;
    }
    
    
    
    
}
