package com.example.hammertimefx;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            
            //inserimento nome
            System.out.println("Inserisci il tuo nome: ");
            String nomeClient = userInput.readLine();
            out.println(nomeClient); //invia il nome del client al server


            //inserimento prodotto
            System.out.println("Inserisci il nome del prodotto: ");
            String nome = userInput.readLine();
            System.out.println("Inserisci la descrizione del prodotto: ");
            String descrizione = userInput.readLine();
            System.out.println("Inserisci il prezzo del prodotto: ");
            String prezzo = userInput.readLine();

            out.println(nome + ";" + descrizione + ";" + prezzo); //invia le informazioni sul prodotto

            //risposta ricevuta da parte del server
            String risposta = in.readLine();
            System.out.println("Risposta dal server: " + risposta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
