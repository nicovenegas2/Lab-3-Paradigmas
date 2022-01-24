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
    
    public boolean create(String nombre, String contenido){
        int i = 0;
        Documento doc;
        if (!this.isLogin()) return false;
        while(i < this.usuarios.size()){
            if (this.usuarios.get(i).getName().equals(this.activo.getName())){
                doc = new Documento(nombre, contenido);
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
        int i = 0;
        int posUs, posDoc;
        if (!this.isLogin()) return false;
        posUs = this.getUserPos();
        posDoc = this.getDocumentPosByid(idDoc);
        if (this.usuarios.get(posUs).getDocs().get(posDoc).SetAcceso(acc))
            return true;
        
        return false;
    }
    
    public int getUserPos(){
        int i=0;
        if (!this.isLogin()) return -1;
        while(i < this.usuarios.size()){
            if(this.usuarios.get(i).getName().equals(this.activo.getName()))
                return i;
        }
        return -1;
    }
    
    public int getDocumentPosByid(int id){
        int posU = this.getUserPos();
        if (posU != -1){
            for(int i=0; i<this.usuarios.get(posU).getDocs().size(); i++){
                if(this.usuarios.get(posU).getDocs().get(i).getId() == id) return i;
            }
        }
        return -1;
    }
    
    
    public void printDocsUserAndId(){
        int i = this.getUserPos();
        if (i != -1){
            for(Documento doc: this.usuarios.get(i).getDocs()){
                System.out.println(doc.getId() + " --> " + doc.getNombre());
            }
        }
    }
    
}
