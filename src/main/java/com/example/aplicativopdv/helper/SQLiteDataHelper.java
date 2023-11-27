package com.example.aplicativopdv.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {
    private static final String bd = "app_database";
    private static final int DATABASE_VERSION = 1;

    public SQLiteDataHelper(@Nullable Context context, @Nullable String nome, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nome, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE VENDEDOR (ID INTEGER, NOME VARCHAR(100), SENHA VARCHAR(100))");
        db.execSQL("CREATE TABLE PRODUTO(ID INTEGER, NOME VARCHAR(100), PRECO DOUBLE)");
        db.execSQL("CREATE TABLE VENDA (ID INTEGER, VENDEDOR VENDEDOR, PRODUTOS PRODUTOS)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
