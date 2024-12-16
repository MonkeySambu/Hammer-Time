package com.example.hammertimefx;

import java.time.LocalDate;

public class Prodotto {
    private String nome;
    private String descrizione;
    private String prezzo;
    private LocalDate data;

    public Prodotto(String nome, String descrizione, String prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo='" + prezzo + '\'' +
                '}';
    }
}