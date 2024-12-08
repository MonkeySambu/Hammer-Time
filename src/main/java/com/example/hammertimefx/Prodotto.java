package com.example.hammertimefx;

import java.time.LocalDate;

public class Prodotto {
    private String nome;
    private String descrizione;
    private String prezzo;
    //private String foto;    //percorso relativo
    //private LocalDate termine;

    public Prodotto(String nome, String descrizione, String prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        //this.foto = foto;
        //this.termine = termine;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPrezzo(){
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString(){
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo='" + prezzo + '\'' +
                '}';
    }
}