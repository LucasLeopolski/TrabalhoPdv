package com.example.aplicativopdv.controller;

import android.content.Context;

import com.example.aplicativopdv.dao.VendedorDao;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class VendedorController {

    private Context context;

    public VendedorController(Context context) {
        this.context = context;
    }
    public  String salvarVendedor(String idVendedor, String nome, String senha) {
        try {
            if (idVendedor.equals("") || idVendedor.isEmpty()) {
                return "INFORME O ID DO VENDEDOR!";
            }

            if (nome.equals("") || nome.isEmpty()) {
                return "INFORME O NOME DO VENDEDOR!";
            }

            if (senha.equals("") || senha.isEmpty()) {
                return "INFORME A SENHA DO VENDEDOR!";
            }


            Vendedor vendedor = VendedorDao.getInstancia(context).getById(Integer.parseInt(idVendedor));

            if (vendedor != null){
                return "O ID("+idVendedor+") JÁ ESTÁ CADASTRADO!";
            }else{

                vendedor = new Vendedor();
                vendedor.setId(Integer.parseInt(idVendedor));
                vendedor.setNome(nome);
                vendedor.setSenha(senha);

                VendedorDao.getInstancia(context).insert(vendedor);

            }

        }catch (Exception ex){
            return "ERRO AO GRAVAR VENDEDOR";
        }

        return  null;
    }


    public ArrayList<Vendedor> retornarTodosVendedores(){
        return VendedorDao.getInstancia(context).getAll();

    }
}

