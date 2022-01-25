package Lab3;

import java.util.Date;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * clase que representa una plataforma
 *  que contiene un nombre, fecha de creacion, lista de usuarios y un usuario activo
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
    
    public boolean create(String nombre, String contenido){
        int i = 0;
        Documento doc;
        if (!this.isLogin()) return false;
        while(i < this.usuarios.size()){
            if (this.usuarios.get(i).getName().equals(this.activo.getName())){
                doc = new Documento(nombre, contenido, this.activo.getName());
                this.usuarios.get(i).addDocument(doc);
                this.setActivo(this.usuarios.get(i));
                return true;
            }
            i++;
        }
        
        return false;
    }
    
    public void showDocuments(){
        for(Usuario usuario: this.usuarios){
            System.out.println(usuario.getName());
            for(Documento doc: usuario.getDocs()){
                System.out.println(doc.getAccesos());
            }
        }
    }
    
    public boolean existUser(String user){
        for(Usuario usuario: this.usuarios){
            if (usuario.getName().equals(user))
                return true;
        }
        return false;
    }
    
    public boolean share(Acceso acc, int idDoc){
        if (!this.isLogin()) return false;
        Documento doc = this.getDocumentById(idDoc);
        if(doc.canEdit(this.activo.getName())) return false;
        if(doc.SetAcceso(acc)) return true;
        return false;
    }

    
    public boolean add(int idDoc, String content){
        Documento doc = this.getDocumentById(idDoc);
        doc.addContent(content);
        return true;
    }
    
    public Documento getDocumentById(int idDoc){
        for(int i=0; i < this.usuarios.size(); i++){
            for(int j=0; j < this.usuarios.get(i).getDocs().size(); j++){
                if(this.usuarios.get(i).getDocs().get(j).getId() == idDoc) return this.usuarios.get(i).getDocs().get(j);
            }
        }
        return null;
    }
    
    public void printDocsUserAndId(){
        for(Usuario user: this.usuarios){
            for (Documento doc: user.getDocs()){
                if(doc.canEdit(this.getActivo().getName())){
                    System.out.println(doc.getId() + " --> " + doc.getNombre());
                }
            }
        }
    }
    
    public void printDocsUserAndIdAutor(){
        for(Usuario user: this.usuarios){
            for (Documento doc: user.getDocs()){
                if(doc.getAutor().equals(this.getActivo().getName())){
                    System.out.println(doc.getId() + " --> " + doc.getNombre());
                }
            }
        }
    }
    
    public void rollback(int idDoc, int idVersion){
        Documento doc = this.getDocumentById(idDoc);
        Version newVer;
        Version ver = doc.getVersionById(idVersion);
        newVer = new Version(doc.getVersiones().size(), doc.getCont());
        doc.setCont(ver.getContenido());
        
    }
    
    public boolean revokeAccess(int idDoc){
        if(!this.isLogin()) return false;
        Documento doc = this.getDocumentById(idDoc);
        doc.revokeAccess(this.activo.getName());
        return true;
    }
    
    public void printInvolucratedDocs(){
        for(Usuario user: this.usuarios){
            for (Documento doc: user.getDocs()){
                if(doc.isInvolucrated(this.getActivo().getName())){
                    System.out.println(doc.getId() + " --> " + doc.getNombre());
                }
            }
        }
    }
    
    public LinkedList search(String searchCont){
        LinkedList<Documento> docs = new LinkedList<Documento>();
        if (!this.isLogin()) return docs;
        for(Usuario user: this.usuarios){
            for (Documento doc: user.getDocs()){
                if(doc.getCont().contains(searchCont) && doc.isInvolucrated(this.activo.getName())){
                    docs.add(doc);
                }
            }
        }
        return docs;
    }
}
