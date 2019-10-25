package com.senai.exemplopratico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {

    static String BANCO_DADOS = "aula";
    static int VERSION_BANCO_DADOS = 8;

    public BancoDados(Context context) {
        super(context, BANCO_DADOS, null, VERSION_BANCO_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table usuario (login text primary key, senha text)";
        sqLiteDatabase.execSQL(sql);

        String insertUsuario = "insert into usuario values('marcelo','123456')";
        sqLiteDatabase.execSQL(insertUsuario);
        Log.i("SENAI", "ON_CREATE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        if (newVersion == 6) {
            String sql = "create table carro (chave INTEGER primary key," +
                    " nome text, placa text, cor text, marca text)";
            sqLiteDatabase.execSQL(sql);

            sql = "insert into carro values(null,'exemplo', 'FAB1234', 'amarelo', 'vw')";
            sqLiteDatabase.execSQL(sql);

        } else if (newVersion == 7) {
            String sql = "create table cor (chave INTEGER primary key ," +
                    " cor text)";
            sqLiteDatabase.execSQL(sql);
            sql = "create table marcas (chave INTEGER primary key," +
                    " marca text)";
            sqLiteDatabase.execSQL(sql);

            // inserindo marcas
            sql = "insert into cor values(null,'amarelo')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into cor values(null,'preto')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into cor values(null,'vermelho')";
            sqLiteDatabase.execSQL(sql);

            // inserindo marcas
            sql = "insert into marcas values(null,'vw')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into marcas values(null,'ford')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into marcas values(null,'gm')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into marcas values(null,'fiat')";
            sqLiteDatabase.execSQL(sql);
            Log.i("SENAI", "ON_UPGRADE_version 2");

        }else if (newVersion ==8) {
            String insertUsuario = "insert into usuario values('fabiano','123456')";
            sqLiteDatabase.execSQL(insertUsuario);
            Log.i("SENAI", "Criar Fabiano");
        }

    }

    public long cadastrarCarro(Carro carro) {

        ContentValues values = new ContentValues();
        values.put("nome", carro.nome);
        values.put("placa", carro.placa);
        values.put("cor", carro.cor);
        values.put("marca", carro.marca);
        long ret = getWritableDatabase().insert("carro", null, values);
        return ret;
    }

    public long cadastrarCor(String cor) {
        ContentValues values = new ContentValues();
        values.put("cor", cor);
        long ret = getWritableDatabase().insert("cor", null, values);
        return ret;
    }

    public Usuario login(String login, String senha) {
        String sql = "SELECT login, senha FROM usuario WHERE login='" + login + "' AND senha='" + senha + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        Usuario u = null;

        for (int i = 0; i < cursor.getCount(); i++) {
            u = new Usuario();
            u.setLogin(cursor.getString(0));
            u.setSenha(cursor.getString(1));
            cursor.moveToNext();
        }

        cursor.close();

        return u;
    }

    public List<String> marcas(){
        List<String> lista = new ArrayList<>();

        String sql = "SELECT marca FROM marcas";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            String marca = cursor.getString(0); //É 1 PORQUE A POSIÇÃO 0 É O ID (PRIMARY KEY)
            lista.add(marca);
            cursor.moveToNext();
        }

        cursor.close();
        return lista;
    }

    public List<String> cores(){
        List<String> lista = new ArrayList<>();

        String sql = "SELECT cor FROM cor";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            String cor = cursor.getString(0); //É 1 PORQUE A POSIÇÃO 0 É O ID (PRIMARY KEY)
            lista.add(cor);
            cursor.moveToNext();
        }

        cursor.close();
        return lista;
    }

    public ArrayList<Carro> retornaCarros(){
        ArrayList<Carro> lista = new ArrayList<>();

        String sql = "SELECT * FROM carro";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            Carro c = new Carro();
            c.id = cursor.getInt(0);
            c.nome = cursor.getString(1); //É 1 PORQUE A POSIÇÃO 0 É O ID (PRIMARY KEY)
            c.placa = cursor.getString(2);
            c.cor = cursor.getString(3);
            c.marca = cursor.getString(4);
            lista.add(c);
            cursor.moveToNext();
        }

        cursor.close();
        return lista;
    }

//    public boolean delete(int idCarro){
//        String sql  = "delete from carro where chave = ?";
//        getWritableDatabase().execSQL(sql, new Object[]{idCarro});
//
//        return
//    }


}
