package com.example.aplicativopdv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.aplicativopdv.helper.SQLiteDataHelper;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class VendedorDao implements GenericDao<Vendedor> {

    private SQLiteDataHelper openHelper;
    private SQLiteDatabase bd;

    private String nomeTabela = "VENDEDOR";

    private String[] colunas = {"ID", "NOME", "SENHA"};

    private Context context;

    private static VendedorDao instancia;

    public static VendedorDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new VendedorDao(context);
        } else {
            return instancia;
        }

    }

    private VendedorDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "APPVENDAS", null, 1);

        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Vendedor obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("ID",obj.getId());
            valores.put("NOME", obj.getNome());
            valores.put("SENHA", obj.getSenha());

            return bd.insert(nomeTabela, null, valores);
        } catch (SQLException ex) {
            Log.e("ERRO", "VendedorDao.insert(): " + ex.getMessage());
        }

        return 0;
    }

    @Override
    public long update(Vendedor obj) {
        try {

        ContentValues valores = new ContentValues();

            String[]identificador = {String.valueOf(obj.getId())};
            valores.put("NOME", obj.getNome());
            valores.put("SENHA", obj.getSenha());

        return bd.update(nomeTabela,valores,colunas[0], identificador);

        }catch (SQLException ex){
            Log.e("ERRO","VendedorDao.update(): "+ex.getMessage());
        }

        return 0;
    }

@Override
    public long delete(Vendedor obj){
        try {

            String[]identificador = {String.valueOf(obj.getId())};
            return bd.delete(nomeTabela, colunas[0]+"= ?",identificador);

        }catch (SQLException ex){
            Log.e("ERRO", "VendedorDao.delete(): "+ex.getMessage());
        }

        return 0;
}

@Override
    public ArrayList<Vendedor> getAll(){
        ArrayList<Vendedor> lista =new ArrayList<>();
        try {
            Cursor cursor = bd.query(nomeTabela,colunas,null,null,null,null,colunas[0]);

            if(((Cursor) cursor).moveToFirst()){
                do{
                    Vendedor vendedor =new Vendedor();
                        vendedor.setId(cursor.getInt(0));
                        vendedor.setNome(cursor.getString(1));
                        vendedor.setSenha(cursor.getString(2));

                        lista.add(vendedor);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("ERRO", "VendedorDao.getAll(): "+ ex.getMessage());
        }

        return  null;
}

@Override
    public Vendedor getById(int id){
    try {
        String[]identificador = {String .valueOf(id)};
        Cursor cursor = bd.query(nomeTabela, colunas, colunas[0]+" = ?", identificador, null,
                null, null);

        if (cursor.moveToFirst()){
            Vendedor vendedor = new Vendedor();
            vendedor.setId(cursor.getInt(0));
            vendedor.setNome(cursor.getString(1));
            vendedor.setSenha(cursor.getString(2));

            return vendedor;
        }

    }catch (SQLException ex){
        Log.e("ERRO", "ProdutoDao.getAll(): "+ex.getMessage());
    }

    return null;
}
}

