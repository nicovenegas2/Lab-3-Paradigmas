package Lab3;

import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicov
 */
public class Menu {
    
    Scanner input = new Scanner(System.in);
    private boolean runO = false;
    Paradigmadocs para;
    
    
    
    
    public Menu(){
        String nombre;
        Date fecha = new Date();
        System.out.println("Bienvenido a nuestro editor de texto");
        System.out.println("Por favor escriba un nombre para la plataforma: ");
        nombre = this.input.nextLine();
        this.para = new Paradigmadocs(nombre, fecha);
        this.runO = true;
        this.run();

    }
    
    public void mostrarOpciones(){
        System.out.println("Editor colaborativo " + this.para.getNombre());
        if(para.isLogin()){
            System.out.println("Registrado como: " + this.para.getActivo().getName());
            System.out.println("1. Crear Documento");
            System.out.println("2. Compartir documento");
            System.out.println("3. Agregar contenido a un documento");
            System.out.println("4. Restaurar versi�n de un documento");
            System.out.println("5. Revocar acceso a un documento");
            System.out.println("6. Buscar en los documentos");
            System.out.println("7. Visualizar documentos");
            System.out.println("8. Cerrar sesi�n");
            System.out.println("9. Cerrar el programa");
        }
        else {
            System.out.println("USUARIO NO REGISTRADO");
            System.out.println("1. Registrarse");
            System.out.println("2. Logearse");
            System.out.println("3. Cerrar programa");
        }
        System.out.println("Por favor eliga una opcion: ");
    }
    
    
    public void ejecutarOpcion(String opcion){
        
       if(para.isLogin()){
           if(opcion.equals("1"))
               this.create();
           else if(opcion.equals("2"))
               this.share();
           else if(opcion.equals("8"))
               this.logOut();
           else if(opcion.equals("9"))
               this.stop();
           else if(opcion.equals("99"))
               this.para.showDocuments();
       }else {
           if(opcion.equals("1"))
               this.register();
           else if(opcion.equals("2"))
               this.login();
           else if(opcion.equals("3"))
               this.stop();
       }
        
    }
    
    
    public void run(){
        String opcion;
        while(this.runO){
            System.out.println("");
            this.mostrarOpciones();
            opcion = this.input.nextLine();
            System.out.println("");
            this.ejecutarOpcion(opcion);
        }
    }
    
    public void stop(){
        this.runO = false;  
    }
    
    
    
    // Apartados de funciones principales con sus respectivas representaciones visuales
    
    public void register(){
        String user, pass;
        System.out.println("HA ELEGIDO REGISTRARSE");
        System.out.println("Por favor ingresa un nombre para registrarse: ");
        user = this.input.nextLine();
        System.out.println("Por favor ingresa una contrase�a:");
        pass = this.input.nextLine();
        if (this.para.register(user, pass))
            System.out.println("Usuario registrado con exito");
        else
            System.out.println("Nombre de usuario ya ocupado por favor elija otro");
    }
    
    public void login(){
    String user, pass;
        System.out.println("HA ELEGIDO INICIAR SESION");
        System.out.println("Por favor ingresa su nombre de usuario: ");
        user = this.input.nextLine();
        System.out.println("Por favor ingrese su contrase�a:");
        pass = this.input.nextLine();
        if (this.para.login(user, pass))
            System.out.println("Ha logrado iniciar sesion con exito");
        else
            System.out.println("Nombre de usuario o contrase�a incorrectas");
    }

    private void logOut() {
        System.out.println("Sesion cerrada con exito");
        this.para.logOut();
        
    }
    
    private void create(){
        Date fecha;
        String nombre, contenido;
        System.out.println("HA ELEGIDO CREAR UN DOCUMENTO");
        System.out.println("por favor elija el nombre del documento: ");
        nombre = this.input.nextLine();
        System.out.println("indique el contenido inicial: ");
        contenido = this.input.nextLine();
        if (this.para.create(nombre, contenido)){
            System.out.println("documento creado con exito");
        }else {
            System.out.println("hubo algun error por favor intentelo de nuevo");
        }
    }
    
     private void share(){
        int idDoc;
        boolean stop = false;
        String user, opcion;
        char tipo;
        System.out.println("HA ELEGIDO COMPARTIR DOCUMENTOS");
        System.out.println("elija el documento que va a compartir");
        this.para.printDocsUserAndId();
        System.out.println("eleccion: ");
        try{
            idDoc = this.input.nextInt();
            this.input.nextLine();
        } catch(Error e){
            System.out.println("Opcion invalida");
            return;
        }
        while(!stop){
            System.out.println("a que usuario quiere compartir el documento?: ");
            user = this.input.nextLine();
            if (this.para.existUser(user)){
                System.out.println("con que permiso va a compartir el documento?: ");
                System.out.println("1. \"R\" solo permite leer el documento.");
                System.out.println("1. \"C\" Permiso \"R\" + permite comentar el documento.");
                System.out.println("1. \"R\" Permiso \"W\" + permite escribir el documento.");
                opcion = this.input.nextLine();
            }
            
            
        }
     }
    
    
}
