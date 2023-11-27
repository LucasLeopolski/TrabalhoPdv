package com.example.aplicativopdv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.aplicativopdv.helper.SQLiteDataHelper;
import com.example.aplicativopdv.model.Produto;
import com.example.aplicativopdv.model.Venda;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class VendaDao implements GenericDao<Venda>{
    private SQLiteDataHelper openHelper;
    private SQLiteDatabase bd;

    private String nomeTabela = "VENDA";

    private String[] colunas = {"VENDEDOR", "PRODUTOS"};

    private Context context;

    private static VendaDao instancia;

    public static VendaDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new VendaDao(context);
        } else {
            return instancia;
        }

    }

    private VendaDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "APPVENDAS", null, 1);

        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Venda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("VENDEDOR", obj.getVendedor());
            valores.put("PRODUTOS", obj.getProdutos());

            return bd.insert(nomeTabela, null, valores);
        } catch (SQLException ex) {
            Log.e("ERRO", "VendaDao.insert(): " + ex.getMessage());
        }

        return 0;
    }

    @Override
    public long update(Venda obj) {
        try {

            ContentValues valores = new ContentValues();

            String[]identificador = {String.valueOf(obj.getId())};
            valores.put("VENDEDOR", obj.getVendedor());
            valores.put("PRODUTOS", obj.getProdutos());

            return bd.update(nomeTabela,valores,colunas[0], identificador);

        }catch (SQLException ex){
            Log.e("ERRO","VendaDao.update(): "+ex.getMessage());
        }

        return 0;
    }

    @Override
    public long delete(Venda obj){
        try {

            String[]identificador = {String.valueOf(obj.getId())};
            return bd.delete(nomeTabela, colunas[0]+"= ?",identificador);

        }catch (SQLException ex){
            Log.e("ERRO", "VendaDao.delete(): "+ex.getMessage());
        }

        return 0;
    }

    @Override
    public ArrayList<Venda> getAll(){
        ArrayList<Venda> lista =new ArrayList<>();
        try {
            Cursor cursor = bd.query(nomeTabela,colunas,null,null,null,null,colunas[0]);

            if(((Cursor) cursor).moveToFirst()){
                do{
                    Venda venda = new Venda();
                    venda.setId(cursor.getInt(0));

                    int vendedorId = cursor.getInt(1);
                    Vendedor vendedor = recuperarVendedorDoBancoDeDados(vendedorId); // Recupere o Vendedor do banco de dados

                    int produtosId = cursor.getInt(2);
                    ArrayList<Produto> produtos = recuperarProdutosDoBancoDeDados(produtosId); // Recupere a lista de Produtos do banco de dados

                    venda.setVendedor(vendedor); // Atribua o Vendedor à Venda
                    venda.setProdutos(produtos);

                    lista.add(venda);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("ERRO", "VendaDao.getAll(): "+ ex.getMessage());
        }

        return  null;
    }

    @Override
    public Venda getById(int id){
        try {
            String[]identificador = {String .valueOf(id)};
            Cursor cursor = bd.query(nomeTabela, colunas, colunas[0]+" = ?", identificador, null,
                    null, null);

            if (cursor.moveToFirst()){
                Venda venda = new Venda();
                venda.setId(cursor.getInt(0));


                return venda;
            }

        }catch (SQLException ex){
            Log.e("ERRO", "VendaDao.getAll(): "+ex.getMessage());
        }

        return null;
    }
}

