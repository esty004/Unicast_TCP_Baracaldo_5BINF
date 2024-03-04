/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicasttcp;

import java.net.*;

/**
 *
 * @author Esty
 */
public class Server {
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    int porta;
    
    public Server(int porta){
        
    }
    
    public Socket attendi(){
        try{
            System.out.println("1 SERVER partito in esecuzione...");
            serverSocket = new ServerSocket(6789);
            clientSocket = serverSocket.accept();
            serverSocket.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
            return clientSocket;
    }
    
    public void scrivi(){
        
    }
    
    public void leggi(){
        
    }
    
    public void chiudi(){
        
    }
}
