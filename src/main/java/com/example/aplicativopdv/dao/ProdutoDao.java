package com.example.aplicativopdv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.aplicativopdv.helper.SQLiteDataHelper;
import com.example.aplicativopdv.model.Produto;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class ProdutoDao implements GenericDao<Produto> {
    private SQLiteDataHelper openHelper;
    private SQLiteDatabase bd;

    private String nomeTabela = "PRODUTO";

    private String[] colunas = {"ID", "NOME", "PRECO"};

    private Context context;

    private static ProdutoDao instancia;

    public static ProdutoDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new ProdutoDao(context);
        } else {
            return instancia;
        }

    }

    private ProdutoDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "APPVENDAS", null, 1);

        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Produto obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("ID", obj.getId());
            valores.put("NOME", obj.getNome());
            valores.put("PRECO", obj.getPreco());

            return bd.insert(nomeTabela, null, valores);
        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.insert(): " + ex.getMessage());
        }

        return 0;
    }

    @Override
    public long update(Produto obj) {
        try {

            ContentValues valores = new ContentValues();

            String[]identificador = {String.valueOf(obj.getId())};
            valores.put("NOME", obj.getNome());
            valores.put("PRECO", obj.getPreco());

            return bd.update(nomeTabela,valores,colunas[0], identificador);

        }catch (SQLException ex){
            Log.e("ERRO","ProdutoDao.update(): "+ex.getMessage());
        }

        return 0;
    }

    @Override
    public long delete(Produto obj){
        try {

            String[]identificador = {String.valueOf(obj.getId())};
            return bd.delete(nomeTabela, colunas[0]+"= ?",identificador);

        }catch (SQLException ex){
            Log.e("ERRO", "ProdutoDao.delete(): "+ex.getMessage());
        }

        return 0;
    }

    @Override
    public ArrayList<Produto> getAll(){
        ArrayList<Produto> lista =new ArrayList<>();
        try {
            Cursor cursor = bd.query(nomeTabela,colunas,null,null,null,null,colunas[0]);

            if(((Cursor) cursor).moveToFirst()){
                do{
                    Produto produto =new Produto();
                    produto.setId(cursor.getInt(0));
                    produto.setNome(cursor.getString(1));
                    produto.setPreco(cursor.getDouble(2));

                    lista.add(produto);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("ERRO", "ProdutoDao.getAll(): "+ ex.getMessage());
        }

        return  null;
    }

    @Override
    public Produto getById(int id){
        try {
            String[]identificador = {String .valueOf(id)};
            Cursor cursor = bd.query(nomeTabela, colunas, colunas[0]+" = ?", identificador, null,
                    null, null);

            if (cursor.moveToFirst()){
                Produto produto = new Produto();
                produto.setId(cursor.getInt(0));
                produto.setNome(cursor.getString(1));
                produto.setPreco(cursor.getDouble(2));

                return produto;
            }

        }catch (SQLException ex){
            Log.e("ERRO", "ProdutoDao.getAll(): "+ex.getMessage());
        }

        return null;
    }
}
