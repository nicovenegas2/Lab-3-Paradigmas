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
            System.out.println("4. Restaurar versión de un documento");
            System.out.println("5. Revocar acceso a un documento");
            System.out.println("6. Buscar en los documentos");
            System.out.println("7. Visualizar documentos");
            System.out.println("8. Cerrar sesión");
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
               System.out.println("algo");
           else if(opcion.equals("8"))
               this.logOut();
           else if(opcion.equals("9"))
               this.stop();
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
}
