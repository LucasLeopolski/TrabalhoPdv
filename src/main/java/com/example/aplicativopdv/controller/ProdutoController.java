package com.example.aplicativopdv.controller;

import android.content.Context;

import com.example.aplicativopdv.dao.ProdutoDao;
import com.example.aplicativopdv.dao.VendedorDao;
import com.example.aplicativopdv.model.Produto;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class ProdutoController {

    private Context context;

    public ProdutoController(Context context) {
        this.context = context;
    }
    public  String salvarProduto(String idProduto, String nome, String preco) {
        try {
            if (idProduto.equals("") || idProduto.isEmpty()) {
                return "INFORME O ID DO PRODUTO!";
            }

            if (nome.equals("") || nome.isEmpty()) {
                return "INFORME O NOME DO PRODUTO!";
            }

            if (preco.equals("") || preco.isEmpty()) {
                return "INFORME O PREÇO DO PRODUTO!";
            }


            Produto produto = ProdutoDao.getInstancia(context).getById(Integer.parseInt(idProduto));

            if (produto != null){
                return "O ID("+idProduto+") JÁ ESTÁ CADASTRADO!";
            }else{

                produto = new Produto();
                produto.setId(Integer.parseInt(idProduto));
                produto.setNome(nome);
                produto.setPreco(Double.parseDouble(preco));

                ProdutoDao.getInstancia(context).insert(produto);

            }

        }catch (Exception ex){
            return "ERRO AO GRAVAR PRODUTO";
        }

        return  null;
    }


    public ArrayList<Produto> retornarTodosProdutos(){
        return ProdutoDao.getInstancia(context).getAll();

    }
}

