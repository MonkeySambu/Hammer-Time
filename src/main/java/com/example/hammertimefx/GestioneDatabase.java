package com.example.hammertimefx;

import java.sql.*;

public class GestioneDatabase {

    private static final String URL = "jdbc:sqlite:database_name.db";

    // Metodo per connettersi al database
    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Connessione al database SQLite avvenuta con successo!");
        } catch (SQLException e) {
            System.out.println("Errore di connessione: " + e.getMessage());
        }
        return connection;
    }

    // Metodo per creare una tabella se non esiste
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "name TEXT NOT NULL,"
                   + "email TEXT NOT NULL UNIQUE);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabella creata con successo!");
        } catch (SQLException e) {
            System.out.println("Errore durante la creazione della tabella: " + e.getMessage());
        }
    }

    // Metodo per inserire un nuovo record nella tabella
    public static void insertData(String name, String email) {
        String sql = "INSERT INTO users(name, email) VALUES(?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Dati inseriti con successo!");
        } catch (SQLException e) {
            System.out.println("Errore durante l'inserimento dei dati: " + e.getMessage());
        }
    }

    // Metodo per leggere tutti i dati dalla tabella
    public static void readData() {
        String sql = "SELECT * FROM users";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("----------");
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la lettura dei dati: " + e.getMessage());
        }
    }

    // Metodo principale per eseguire il programma
    public static void main(String[] args) {
        createTable(); // Crea la tabella se non esiste
        insertData("Mario Rossi", "mario.rossi@example.com"); // Inserisce i dati
        insertData("Luca Bianchi", "luca.bianchi@example.com");
        readData(); // Legge tutti i dati
    }
  
}



