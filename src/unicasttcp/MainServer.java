package com.mycompany.comunicazionec_s;

import java.util.Scanner;

/**
 *
 * @author asuf507zu4lp054w
 */
public class MainServer {

    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String r = "si";
      String b = "si";
      boolean i = true;
      Server server=new Server(4002); //crea il server e apre la porta 4002
       while(b.equals("si")){
           server.attendi();
         while(r.equals("si")){
             if (i == false) {
             System.out.println("in attesa di altri dati...");
             }
            
            server.leggi();
            server.scrivi();
            System.out.println("continuare a ricevere dallo stesso client?");
            r = s.nextLine(); 
            i = false;
         } 
         server.chiudi();
         System.out.println("vuoi ricevere da un altro client?");
         b = s.nextLine();
         r = "si";
         i = true;
          
      } 
       
      server.termina();  //chiude il server
    }
    
}
