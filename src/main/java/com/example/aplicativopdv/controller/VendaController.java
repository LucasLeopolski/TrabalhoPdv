package com.example.aplicativopdv.controller;

import android.content.Context;

import com.example.aplicativopdv.dao.VendaDao;
import com.example.aplicativopdv.dao.VendedorDao;
import com.example.aplicativopdv.model.Produto;
import com.example.aplicativopdv.model.Venda;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class VendaController {
    private Context context;

    public VendaController(Context context) {
        this.context = context;
    }
    public  String salvarVenda(String idVenda, String vendedor, String produto) {
        try {
            if (idVenda.equals("") || idVenda.isEmpty()) {
                return "INFORME O ID DA VENDA!";
            }

            if (vendedor.equals("") || vendedor.isEmpty()) {
                return "INFORME O NOME DO VENDEDOR!";
            }

            if (produto.equals("") || produto.isEmpty()) {
                return "INFORME O PRODUTO!";
            }


            Vendedor vendedorObj = new Vendedor();
            vendedorObj.setNome(vendedor);
            Produto produto1 = new Produto();
            produto.add(Produto);

            Venda venda = VendaDao.getInstancia(context).getById(Integer.parseInt(idVenda));

            if (venda != null){
                return "O ID("+idVenda+") JÁ ESTÁ CADASTRADO!";
            }else{

                venda = new Venda();
                venda.setId(Integer.parseInt(idVenda));
                venda.setVendedor(Vendedor.parseInt(vendedor));
                venda.setProdutos(produto);

                VendaDao.getInstancia(context).insert(venda);

            }

        }catch (Exception ex){
            return "ERRO AO GRAVAR VENDA";
        }

        return  null;
    }


    public ArrayList<Venda> retornarTodasVendas(){
        return VendaDao.getInstancia(context).getAll();

    }
}
