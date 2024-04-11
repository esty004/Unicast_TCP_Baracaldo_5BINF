package com.mycompany.comunicazionec_s;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.BindException;
import java.io.*;


public class Server {
    
    private ServerSocket sSocket;
    private Socket cSocket;
    private int porta;
    
    
      public Server(int porta) {
        this.porta=porta;
        try {
           this.sSocket=new ServerSocket(porta);  //socket(), bind(), listen();
           
        } catch (IOException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("errore nella fase di ascolto");
        }
    }
      
        public Socket attendi() {
        //consento l'ingresso di dati dalla porta
        try {
            System.out.println("il server è in attesa di una connessione da un client");
            cSocket = sSocket.accept(); //attende connessioni finche il client non si collega
            System.out.println("Connessione Accettata da " + cSocket);
        } catch (BindException e) {
            System.err.println(e);
            System.out.println("server gia avviato e occupa la porta");
        } catch (IOException e) {
            System.err.println(e);
            System.out.println("Connessione fallita al metodo accept()");
        }
        return cSocket;
    } 
        
    public void leggi() {
        try {
            InputStream inputStream = cSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                       
            System.out.println("Dati ricevuti dal client: " + in.readLine());
            
            
        } catch (IOException e) {
            System.err.println("errore nella ricezione di dati dal client");
        } finally {
            
        }
    }

    public void scrivi() {
        try {
            OutputStream outputStream = cSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            
            out.println("dati inviati correttamente!");
            
           
        } catch (IOException e) {
            System.err.println("errore nell'invio della risposta al client");
            System.err.println(e);
        }
    }

    public void chiudi() {
        try {           
            System.out.println("chiusura connessione col client");
            cSocket.close(); //chiudo la connessione col client
        } catch (IOException e) {
            System.err.println(e);
        } 
      
    }

    public void termina() {
        try {            
            sSocket.close(); //chiudo il server
        } catch (IOException e) {
            System.err.println(e);
        }
    }
      
      
}
