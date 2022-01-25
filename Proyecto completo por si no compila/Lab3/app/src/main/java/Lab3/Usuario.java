package Lab3;

import Lab3.Documento;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase que representa a un usuario
 * tiene un id unico, la cantidad total de usuarios creados, nombre, contrasegna y una lista de documentos
 * 
 * @author nicov
 */
public class Usuario {
    
    private static int usuariosExistentes = 0;
    private int id;
    private String name;
    private String password;
    private LinkedList<Documento> docs = new LinkedList<Documento>();

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

    public LinkedList<Documento> getDocs() {
        return docs;
    }

    public void setDocs(LinkedList<Documento> docs) {
        this.docs = docs;
    }
    
     
   
    
    /**
    * metodo que comprueba si una contraseña y nombre coincide con el usuario
    */
    public Boolean canLogin(String name, String pass){
        if (this.name.equals(name) && this.password.equals(pass)) {return true;}
        return false;
    }
    
    public void addDocument(Documento document){
        this.docs.add(document);
    }
    
    
    
    
}
