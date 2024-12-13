package com.example.hammertimefx;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Server {

    public static void main(String[] args) throws Exception{

        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server in ascolto sulla porta: " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Accettata connessione dal client: " + clientSocket.getInetAddress());

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        //Riceve il nome del client
        String nomeClient = in.readUTF();
        System.out.println("Nome del cliente: " + nomeClient);

        //Riceve il prodotto come stringa delimitata
        String infoProdotto = in.readUTF();
        String[] dettagliProdotto = infoProdotto.split(";"); //Divide la stringa in base al delimitatore

        if(dettagliProdotto.length == 3) {
            String nome = dettagliProdotto[0];
            String descrizione = dettagliProdotto[1];
            String prezzo = dettagliProdotto[2];

            Prodotto prodotto = new Prodotto(nome, descrizione, prezzo);
            System.out.println("Ricevuto: " + prodotto.toString());
            out.writeUTF("Risposta a " + nomeClient + ": " + prodotto.toString());
        } else {
            System.out.println("Dati del prodotto no validi");
            out.writeUTF("Dati del prodotto non validi");
        }

        System.out.println("Chiusura connessione");
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
    /*private static void loginUser(Scanner scanner) {
        System.out.println("Inserisci il tuo nome");
        String username = scanner.nextLine();
        try{
            ServerSocket serverSocket = new ServerSocket(12345);
            while(true){
                Socket s = serverSocket.accept();
                ClientThread client = new ClientThread(s);
                ClientThread.lista_client.add(client);
                client.start();
                System.out.println("client connesso");
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

    }*/

}


/*class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private int offerta;
    private float prezzo;
    private boolean venduto = false;
    public static ArrayList<ClientThread> lista_client = new ArrayList();

    public ClientThread(Socket s){
        socket = s;
        try{
            System.out.println("inserire un'offerta");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void run(){
        if(offerta>prezzo){
            System.out.println("hai superato il prezzo e la tua offerta e un lista");
        }
        else{
            System.out.println("aumenta l'offerta");
            try {
                System.out.println("inserisci la nuova offerta");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(venduto = true) {
            System.out.println("Complimenti hai acquistato il prodotto");
            try {
                this.socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}*/