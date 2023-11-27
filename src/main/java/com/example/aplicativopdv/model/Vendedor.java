package com.example.aplicativopdv.model;

public class Vendedor {

    public Vendedor() {
    }

    private String nome;
    private String senha;
    private int id;

    public Vendedor(String nome, String senha, int id) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
