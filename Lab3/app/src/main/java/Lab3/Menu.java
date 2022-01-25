package Lab3;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * clase que hace referencia a un menu interactivo
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
        this.datosPrevios();
        this.run();

    }
    
    public void mostrarOpciones(){
        System.out.println("Editor colaborativo " + this.para.getNombre());
        if(para.isLogin()){
            System.out.println("Registrado como: " + this.para.getActivo().getName());
            System.out.println("1. Crear Documento");
            System.out.println("2. Compartir documento");
            System.out.println("3. Agregar contenido a un documento");
            System.out.println("4. Restaurar versión de un documento");
            System.out.println("5. Revocar acceso a un documento");
            System.out.println("6. Buscar en los documentos");
            System.out.println("7. Cerrar sesión");
            System.out.println("8. Cerrar el programa");
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
           else if(opcion.equals("3"))
               this.add();
           else if(opcion.equals("4"))
               this.rollback();
           else if(opcion.equals("5"))
               this.revokeAllAccess();
           else if(opcion.equals("6"))
               this.search();
           else if(opcion.equals("7"))
               this.logOut();
           else if(opcion.equals("8"))
               this.stop();
           else if(opcion.equals("99"))
               this.para.showDocuments();
           else{
               System.out.println("opcion invalida");
           }
       }else {
           if(opcion.equals("1"))
               this.register();
           else if(opcion.equals("2"))
               this.login();
           else if(opcion.equals("3"))
               this.stop();
           else {
               System.out.println("opcion invalida");
           }
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
    
    public void datosPrevios(){
        this.para.register("nico", "1234");
        this.para.login("nico", "1234");
        this.para.create("doc 1", "contenido 1");
        this.para.create("doc 2", "contenido 2");
        this.para.create("doc 3", "contenido 3");
        this.para.create("doc 4", "contenido 4");
        this.para.logOut();
        
        this.para.register("ale", "1234");
        this.para.login("ale", "1234");
        this.para.create("doc 5", "contenido 5");
        this.para.create("doc 6", "contenido 6");
        this.para.logOut();
        this.para.register("loki", "4321");
        this.para.login("loki", "4321");
        this.para.create("doc 7", "contenido 7");
        this.para.create("doc 8", "contenido 8");
        this.para.logOut();
        
        this.para.register("cody", "1234");
         this.para.login("cody", "1234");
        this.para.create("doc 9", "contenido 9");
        this.para.create("doc 10", "contenido 10");
        this.para.logOut();
        this.para.register("tom", "mot");
        
    }
    
    
    
    
    
    
    // Apartados de funciones principales con sus respectivas representaciones visuales
    
    public void register(){
        String user, pass;
        System.out.println("HA ELEGIDO REGISTRARSE");
        System.out.println("Por favor ingresa un nombre para registrarse: ");
        user = this.input.nextLine();
        System.out.println("Por favor ingresa una contraseña:");
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
        System.out.println("Por favor ingrese su contraseña:");
        pass = this.input.nextLine();
        if (this.para.login(user, pass))
            System.out.println("Ha logrado iniciar sesion con exito");
        else
            System.out.println("Nombre de usuario o contraseña incorrectas");
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
        Acceso acc;
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
                System.out.println("2. \"C\" Permiso \"R\" + permite comentar el documento.");
                System.out.println("3. \"W\" Permiso \"C\" + permite escribir el documento.");
                opcion = this.input.nextLine();
                if (opcion.equals("1"))
                    tipo = 'R';
                else if (opcion.equals("2"))
                    tipo = 'C';
                else if (opcion.equals("3"))
                    tipo = 'W';
                else
                    tipo = 'O';
                if(tipo != 'O'){
                    acc = new Acceso(user,tipo);
                    this.para.share(acc, idDoc);
                }
                else
                    System.out.println("opcion invalida");
                
                    
            }else {
                System.out.println("el usuario no existe");
            }
            System.out.println("desea repetir el proceso?: ");
            System.out.println("1. si    2. no");
            opcion = this.input.nextLine();
            if (opcion.equals("2")) stop = true;

        }
     }
     
     public void add(){
        int idDoc;
        String cont, opcion;
        System.out.println("HA ELEGIDO AGREGAR CONTENIDO A UN DOCUMENTO");
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
        this.para.getDocumentById(idDoc).info();
        System.out.println("Que desea agregar?: ");
        cont = this.input.nextLine();
        if (this.para.add(idDoc, cont)){
            System.out.println("Contenido añadido con exito");
        }
        else{
            System.out.println("ha ocurrido algun error, intentelo de nuevo");
        }
     }
     
     
      public void rollback(){
        int idDoc, idVer;
        System.out.println("HA ELEGIDO HACER UN ROLLBACK A TU DOCUMENTO");
        System.out.println("elija el documento: ");
        this.para.printDocsUserAndIdAutor();
        System.out.println("eleccion: ");
        try{
            idDoc = this.input.nextInt();
            this.input.nextLine();
        } catch(Error e){
            System.out.println("Opcion invalida");
            return;
        }
        this.para.getDocumentById(idDoc).showVersions();
        System.out.println("que version quieres restaurar?");
        System.out.println("eleccion: ");
        try{
            idVer = this.input.nextInt();
            this.input.nextLine();
        } catch(Error e){
            System.out.println("Opcion invalida");
            return;
        }
        this.para.rollback(idDoc, idVer);
        
    }
    
    public void revokeAllAccess(){
        int idDoc, idVer;
           System.out.println("HA ELEGIDO BORRAR LOS ACCESSOS DE UN DOCUMENTO");
           System.out.println("elija el documento: ");
           this.para.printDocsUserAndIdAutor();
           System.out.println("eleccion: ");
           try{
               idDoc = this.input.nextInt();
               this.input.nextLine();
           } catch(Error e){
               System.out.println("Opcion invalida");
               return;
           }
           
           if (this.para.revokeAccess(idDoc)){
               System.out.println("Accessos eliminados con exito");
           } else{
               System.out.println("Ha ocurrido algun error, intentelo de nuevo");
           }
    }
    
    
    public void search(){
       String textoS;
       LinkedList<Documento> docs;
       System.out.println("HA ELEGIDO BUSCAR DOCUMENTOS");
       System.out.println("introduzca un texto para buscar en los documentos que esta relacionado: ");
       textoS = this.input.nextLine();
       docs = this.para.search(textoS);
       if(docs.size() == 0){
           System.out.println("no hay documentos que contengan ese texto");
       } else{
           System.out.println("a continuacion se mostraran los documentos que coiciden con el criterio de busqueda: ");
           for(Documento doc: docs){
               System.out.println("-------------------------");
               doc.info();
           }
       }
    }
}
