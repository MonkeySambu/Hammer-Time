package com.example.hammertimefx;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Server {

    private static void loginUser(Scanner scanner) {
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

    }

}


class ClientThread extends Thread{
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
}