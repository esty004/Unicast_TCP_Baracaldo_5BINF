/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicasttcp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Esty
 */
public class Client {

    String nome;
    String colore;
    
    public Client(String nomeDefault, String coloreDefault){
        this.nome = nomeDefault;
        this.colore = coloreDefault;
    }
    public void connetti(String nomeServer, int portaServer) throws IOException {
        Socket socket = new Socket(nomeServer, portaServer);
        BufferedReader inDalServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream outVersoIlServer = new DataOutputStream(socket.getOutputStream());
        
    }
    
    public void scrivi(){
        
    }
    
    public void leggi(){
        
    }
    
    public void chiudi(){
        
    }
}
