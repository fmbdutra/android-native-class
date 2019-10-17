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
    static int VERSION_BANCO_DADOS = 3;

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

        if (newVersion == 1) {
            String sql = "create table carro (chave INTEGER primary key," +
                    " nome text, placa text, cor text, marca text)";
            sqLiteDatabase.execSQL(sql);
        } else if (newVersion == 3) {
            String sql = "create table cor (chave INTEGER primary key ," +
                    " cor text)";
            sqLiteDatabase.execSQL(sql);
            sql = "create table marcas (chave INTEGER primary key," +
                    " marca text)";
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
            Log.i("SENAI", "ON_UPGRADE_version 2");

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

    public List<Usuario> buscaUsuario() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT login, senha FROM usuario";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++){
            Usuario u = new Usuario();
            u.setLogin(cursor.getString(0));
            u.setSenha(cursor.getString(1));
            lista.add(u);
            cursor.moveToNext();
        }

        cursor.close();

        return  lista;
    }

}
