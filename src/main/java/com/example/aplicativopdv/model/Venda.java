package com.example.aplicativopdv.model;

import java.util.ArrayList;

public class Venda {
    private int id;
    private Vendedor vendedor;
    private ArrayList<Produto> produtos;

    public Venda(int id, Vendedor vendedor, ArrayList<Produto> produtos) {
        this.id = id;
        this.vendedor = vendedor;
        this.produtos = produtos;
    }

    public Venda() {
    }

    public Venda(int id, Vendedor vendedor) {
        this.id = id;
        this.vendedor = vendedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
