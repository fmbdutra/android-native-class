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
    static int VERSION_BANCO_DADOS = 1;

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

        if(newVersion == 2) {
            String sql = "create table carro (chave INTEGER primary key," +
                    " nome text, placa text, cor text, marca text)";
            sqLiteDatabase.execSQL(sql);
        }else if(newVersion == 3){
            String sql = "create table cor (chave INTEGER primary key ," +
                    " cor text)";
            sqLiteDatabase.execSQL(sql);
            sql = "create table marcas (chave INTEGER primary key," +
                    " marca text)";
            sqLiteDatabase.execSQL(sql);
             sql = "create table carro (chave INTEGER primary key," +
                    " nome text, placa text, cor text, marca text)";
            sqLiteDatabase.execSQL(sql);


            // inserindo cores
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
            Log.i("SENAI","ON_UPGRADE_version 2");

        }else if(newVersion == 4){
            String sql = "create table cor (chave INTEGER primary key ," +
                    " cor text)";
            sqLiteDatabase.execSQL(sql);
            sql = "create table marcas (chave INTEGER primary key," +
                    " marca text)";
            sqLiteDatabase.execSQL(sql);
            sql = "create table carro (chave INTEGER primary key," +
                    " nome text, placa text, cor text, marca text)";
            sqLiteDatabase.execSQL(sql);
        }else if(newVersion == 5){
            // inserindo marcas

            String sql = "insert into marcas values(null,'vw')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into marcas values(null,'ford')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into marcas values(null,'gm')";
            sqLiteDatabase.execSQL(sql);
            sql = "insert into marcas values(null,'fiat')";
            sqLiteDatabase.execSQL(sql);
        }
    }


    public long cadastrarCarro(Carro carro){

        ContentValues values = new ContentValues();
        values.put("nome",carro.nome);
        values.put("placa",carro.placa);
        values.put("cor",carro.cor);
        values.put("marca",carro.marca);
        long ret = getWritableDatabase().insert("carro",null,values);
        return ret;
    }

    public long cadastrarCor(String cor){
        ContentValues values = new ContentValues();
        values.put("cor",cor);
        long ret = getWritableDatabase().insert("cor",null,values);
        return ret;
    }

    public List<Usuario> buscaUsuarios(){
        List<Usuario> lista = new ArrayList<>();
        String sql = "select login, senha from usuario";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        for(int i=0; i < cursor.getCount(); i++){
            Usuario usuario = new Usuario();
            usuario.login = cursor.getString(0);
            usuario.senha = cursor.getString(1);
            lista.add(usuario);
            cursor.moveToNext();
        }

        cursor.close();
        return lista;
    }

    public Usuario login(String login,String senha){

        String sql = "select login, senha from usuario " +
                " where login = '" + login + "' and  senha = '" + senha+"'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        Usuario usuario = null;
        for(int i=0; i < cursor.getCount(); i++){
            usuario = new Usuario();
            usuario.login = cursor.getString(0);
            usuario.senha = cursor.getString(1);

            cursor.moveToNext();
        }

        cursor.close();
        return  usuario;
    }


    public List<String> buscaMarcas(){
        ArrayList<String> lista = new ArrayList<>();
        String sql = "select marca from marcas";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            String marca = cursor.getString(0);
            lista.add(marca);
            cursor.moveToNext();
        }
        cursor.close();

        return lista;
    }

    public ArrayList<Carro> buscaCarros(){
        ArrayList<Carro> lista = new ArrayList<>();
        String sql = "select * from carro";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();


        for(int i=0; i < cursor.getCount(); i++){
            int id = cursor.getInt(0);
            String nome = cursor.getString(1);
            String placa = cursor.getString(2);
            String cor = cursor.getString(3);
            String marca = cursor.getString(4);
            Carro carro = new Carro();
            carro.placa = placa;
            carro.nome = nome;
            carro.marca = marca;
            carro.cor = cor;
            carro.id = id;
            lista.add(carro);
            cursor.moveToNext();
        }
        cursor.close();

        return lista;
    }


    public void  deletaCarro(int idCarro){
        // 1 forma
//        String sql = "delete from carro where chave  =  " + idCarro;
//        getWritableDatabase().execSQL(sql);

        // 2 forma
        String sql = "delete from carro where chave = ?";
        getWritableDatabase().execSQL(sql,new Object[]{idCarro});

    }





}
