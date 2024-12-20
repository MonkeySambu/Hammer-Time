package com.example.hammertimefx;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Prodotto implements Serializable {
    private String nome;
    private String descrizione;
    private String prezzo;
    private String utente;
    private String foto;
    private LocalDate data;
    private int ID_P;
    

    public Prodotto() {}

    public Prodotto(String nome, String descrizione, String prezzo, String utente, String foto, LocalDate data, int ID_P) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.utente = utente;
        this.foto = foto;
        this.data = data;
        this.ID_P = ID_P;
    }

    public Prodotto(String nome, String descrizione, String prezzo, String utente, String foto, LocalDate data) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.utente = utente;
        this.foto = foto;
        this.data = data;
    }



    @Override
    public String toString() {
        return "Prodotto{" +
                "ID='" + ID_P +'\''+
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo='" + prezzo + '\'' +
                ", data fine='" + data + '\'' +
                ", foto='" + foto + '\'' +
                ", utente='" + utente + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public String getUtente() {
        return utente;
    }

    public String getFoto() {
        return foto;
    }

    public LocalDate getData() {
        return data;
    }

    public int getID_P() {
        return ID_P;
    }

    public void setID_P(int ID_P) {
        this.ID_P = ID_P;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }



}