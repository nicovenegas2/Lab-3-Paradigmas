package Plataforma;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicov
 */
public class Main {
    
    public static void main(String[] args){
        Usuario us1 = new Usuario("nico", "1234"), us2 = new Usuario("loki", "4321");
        System.out.println(us1.canLogin("nico", "1234"));
        System.out.println(us2.canLogin("loki", "4321"));
    }
    
}
