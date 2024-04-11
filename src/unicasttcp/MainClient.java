package com.mycompany.comunicazionec_s;

import java.util.Scanner;

/**
 *
 * @author asuf507zu4lp054w
 */
public class MainClient {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String r = "si";
        Client client= new Client("LucaTadd.com","Blu");
        client.connetti("127.0.0.1",4002);
         while(r.equals("si")){
           client.scrivi();
           client.leggi();
           System.out.println("continuare a mandare dati?");
           r = s.nextLine(); 
         }
        client.chiudi();
    }
}
