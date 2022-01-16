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
    Paradigmadocs para;
    
    public Menu(){
        String nombre;
        Date fecha = new Date();
        System.out.println("Bienvenido a nuestro editor de texto");
        System.out.println("Por favor escriba un nombre para la plataforma: ");
        nombre = this.input.nextLine();
        para = new Paradigmadocs(nombre, fecha);

    }
    
}
