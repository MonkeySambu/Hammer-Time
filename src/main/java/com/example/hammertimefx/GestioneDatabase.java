package com.example.hammertimefx;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestioneDatabase {

    private static final String URL = "jdbc:sqlite:identifier.sqlite";

    // Metodo per connettersi al database
    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
            System.out.println("Connessione al database SQLite avvenuta con successo!");
        } catch (SQLException e) {
            System.out.println("Errore di connessione: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    // Metodo per creare una tabella se non esiste
    public static void createTable() {

    }

    // Metodo per inserire un nuovo record nella tabella
    public static void insertData(Prodotto p) {
        String sql = "INSERT INTO prodotti(nome, descrizione,data,prezzo,foto,user) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getDescrizione());
            pstmt.setString(3, p.getData().toString());
            pstmt.setString(4, p.getPrezzo());
            pstmt.setString(5, p.getFoto());
            pstmt.setString(6,p.getUtente());

            pstmt.executeUpdate();
            System.out.println("Dati inseriti con successo!");
        } catch (SQLException e) {
            System.out.println("Errore durante l'inserimento dei dati: " + e.getMessage());
        }
    }

    // Metodo per leggere tutti i dati dalla tabella
//    public static void readData() {
//
//
//        try (Connection conn = connect();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("id"));
//                System.out.println("Name: " + rs.getString("name"));
//                System.out.println("Email: " + rs.getString("email"));
//                System.out.println("----------");
//            }
//        } catch (SQLException e) {
//            System.out.println("Errore durante la lettura dei dati: " + e.getMessage());
//        }
//    }

    public static ArrayList<Prodotto> readProdotti() {
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        String sql = "SELECT * FROM prodotti";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                String nome =(rs.getString("nome"));
                String descrizione =(rs.getString("descrizione"));
                String dataS =(rs.getString("data"));
                String prezzo =(rs.getString("prezzo"));
                String foto =(rs.getString("foto"));
                String utente =(rs.getString("user"));
                int id = rs.getInt("id");

                LocalDate data=LocalDate.parse(dataS);
                Prodotto p= new Prodotto(nome,descrizione,prezzo,utente,foto,data,id);
                System.out.println(p);
                prodotti.add(p);
            }
        }catch (SQLException e) {
            System.out.println("Errore durante la lettura dei dati: " + e.getMessage());
        }
            return prodotti;
    }

    public static void updateData(String d,int n) {
        String sql = "UPDATE prodotti SET prezzo=? WHERE id=?";
        try (Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, d);
            pstmt.setInt(2, n);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Errore durante la lettura dei dati: " + e.getMessage());
        }
    }
}



