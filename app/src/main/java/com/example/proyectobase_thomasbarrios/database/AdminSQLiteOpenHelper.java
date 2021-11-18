package com.example.proyectobase_thomasbarrios.database;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    // Constructor para instanciar mi database ..
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Me permite definir mi modelo de trabajo (Crear tablas y campos) ..
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE clases(codigo int primary key, clase, text, intensidad text)");
    }

    // Me permite realizar cambios esquematicos en mi database ..
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
