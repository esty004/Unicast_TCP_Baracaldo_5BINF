package com.mycompany.comunicazionec_s;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
import java.io.*;
import java.util.Scanner;

public class Client {
    
    private String nome;
    private String colore;
    private Socket socket;

    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }

    public void connetti(String nomeS, int portaS) {
        System.out.println("Client "+nome+" in esecuzione\n");
        System.out.println("Client collegato alla porta " + portaS + " in esecuzione\n");
        try {
            this.socket = new Socket(nomeS, portaS); //collegamento alla porta indicata per l'invio di dati, socket(), connect();
        } catch(ConnectException e) {
            System.err.println("server non in ascolto");
            System.err.println(e);
        }
        catch(UnknownHostException ex){ 
            System.err.println("Host sconosciuto");
            System.err.println(ex);
        } catch (IOException e){
            System.err.println("Errore generico nella Creazione del Client");
            System.err.println(e);
        }
        
    }
    
    public void leggi() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            
            System.out.println("Risposta dal server: " + in.readLine());
            
            
        } catch (IOException e) {
            System.err.println("errore nella ricezioni di dati dal server");
            System.err.println(e);
        }
    }
    
    public void scrivi() {
        Scanner s = new Scanner(System.in);
        try {
         OutputStream outputStream = socket.getOutputStream();
         PrintWriter out = new PrintWriter(outputStream, true);
         System.out.println("inserisci l'informazione da dare al server");
         String dato = s.nextLine();
         
         out.println(dato);
                 
        } catch (IOException e) {
            System.err.println("errore nell'invio di dati al server");
        }
    }

    public void chiudi() {
            try {              
                socket.close(); // Chiudo il socket (il client)
                System.out.println("Connessione chiusa.");
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
