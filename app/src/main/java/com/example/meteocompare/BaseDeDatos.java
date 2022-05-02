package com.example.meteocompare;

import android.database.Cursor;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Clase para conectar la base de datos
public class BaseDeDatos extends SQLiteOpenHelper {

    // Constructor con el mismo nombre
    public BaseDeDatos(@Nullable Context context,
                       @Nullable String name,
                       @Nullable SQLiteDatabase.CursorFactory factory,
                       int version) {
        super(context, name, factory, version);
    }

    // Metodo para crear las tablas de la BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable;

        createTable = "CREATE TABLE  usuario (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "email TEXT, " +
                "contraseña TEXT);";
        db.execSQL(createTable);

        createTable = "CREATE TABLE comparacion (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER," +
                "fecha DATE, " +
                "busqueda1_id INTEGER," +
                "busqueda2_id INTEGER" +
                ");";
        db.execSQL(createTable);

        createTable = "CREATE TABLE busqueda (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "maxTemp FLOAT, " +
                "minTemp FLOAT," +
                "avgTemp FLOAT," +
                "precipitacion FLOAT, " +
                "avgViento FLOAT," +
                "uvMax FLOAT, " +
                "fecha DATE, " +
                "cielo TEXT, " +
                "municipio TEXT, " +
                "provincia TEXT" +
                ");";
        db.execSQL(createTable);
    }

    // Metodo para actualizar la BD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Metodo para insertar datos en la BD
    public boolean insertDataUsuario(String nombre, String email, String contrasena){
        SQLiteDatabase db = getWritableDatabase();

        // Check por si el correo ya existe en la BD
        String checkEmail = "SELECT * FROM usuario WHERE email = \"" + email + "\"";
        System.out.println(checkEmail);
        Cursor cursor = db.rawQuery (checkEmail, null);

        if (cursor.getCount() != 0) // Significa que ya hay un usuario registrado con ese correo
        {
            return false;
        }

        // Inserta datos de usuario en la BD
        String insert = "INSERT INTO usuario (nombre, email, contraseña) " +
                "VALUES (\""+ nombre +"\" , \""+ email + "\" , \""+ contrasena + "\" );";
        db.execSQL(insert);
        db.close();

        return true;
    }

    // Metodo para insertar datos de busqueda en la BD
    public int insertDataBusqueda(float maxTemp, float minTemp, float avgTemp, float avgViento,
                                  float uvMax, float precipitacion, String cielo,
                                  Date fecha, String municipio, String provincia){
        SQLiteDatabase db = getWritableDatabase();

        // Inserta datos
        System.out.println("Fecha de la busqueda: " + fecha.toString());

        String insert = "INSERT INTO busqueda (maxTemp, minTemp, avgTemp, precipitacion, avgViento, uvMax, fecha, cielo, municipio, provincia) " +
                "VALUES (\""+ maxTemp +"\" , \""+ minTemp + "\" , \""+ avgTemp + "\" , \""+ precipitacion + "\", \"" +
                avgViento + "\", \"" + uvMax + "\" , \"" + fecha.getTime() + "\" , \"" + cielo +
                "\", \"" + municipio + "\", \"" + provincia +"\")";
        db.execSQL(insert);

        // ID de la ultima busqueda
        Cursor cursor = db.rawQuery ("SELECT last_insert_rowid()", null);
        cursor.moveToFirst();

        int id = cursor.getInt(0);

        return id;
    }

    // Metodo para insertar datos de la comparacion
    public boolean insertDataComparacion(int user_id, Date fecha, Busqueda busqueda1, Busqueda busqueda2){
        SQLiteDatabase db = getWritableDatabase();

        // Insertar datos de ambas busquedas
        int id1 = insertDataBusqueda(
                busqueda1.getMaxTemp(),
                busqueda1.getMinTemp(),
                busqueda1.getAvgTemp(),
                busqueda1.getAvgViento(),
                busqueda1.getUvMax(),
                busqueda1.getPrecipitacion(),
                busqueda1.getCielo(),
                busqueda1.getFecha(),
                busqueda1.getUbicacion(),
                busqueda1.getProvincia()
        );

        int id2 = insertDataBusqueda(
                busqueda2.getMaxTemp(),
                busqueda2.getMinTemp(),
                busqueda2.getAvgTemp(),
                busqueda2.getAvgViento(),
                busqueda2.getUvMax(),
                busqueda2.getPrecipitacion(),
                busqueda2.getCielo(),
                busqueda2.getFecha(),
                busqueda2.getUbicacion(),
                busqueda2.getProvincia()
        );

        // Insertar datos de ambas busquedas en la tabla comparacion
        String insert = "INSERT INTO comparacion (user_id, fecha, busqueda1_id, busqueda2_id) " +
                "VALUES (\""+ user_id +"\" , \""+ fecha.getTime() + "\" , \""+ id1 + "\" , \""+ id2 + "\");";
        db.execSQL(insert);

        db.close();

        return true;
    }

    // Recuperar datos de busqueda
    public Busqueda getDataBusqueda(int id) {
        SQLiteDatabase lectura = getReadableDatabase();
        String query = "SELECT * FROM busqueda WHERE id = " + id;
        Cursor cursor = lectura.rawQuery (query, null);
        cursor.moveToFirst();

        if (cursor.getCount() != 1) // Si no existiera
        {
            lectura.close();
            return new Busqueda();
        }

        System.out.println("Recuperando busqueda con fecha " + cursor.getLong(7));

        Busqueda busqueda = new Busqueda(
                cursor.getInt(0),               // id
                cursor.getString(9),            // ubicacion
                cursor.getString(10),           // provincia
                new Date(cursor.getLong(7)),    // fecha
                cursor.getFloat(3),             // minTemp
                cursor.getFloat(1),             // maxTemp
                cursor.getFloat(2),             // avgTemp
                cursor.getFloat(5),             // avgViento
                cursor.getFloat(6),             // uvMax
                cursor.getFloat(4),             // precipitacion
                cursor.getString(8)             // cielo
        );

        lectura.close();

        return busqueda;
    }

    // Recuperar datos comparacion
    public List<Comparacion> getDataComparacion(int user_id) {
        SQLiteDatabase lectura = getReadableDatabase();
        String query = "SELECT * FROM comparacion WHERE user_id = " + user_id + " ORDER BY fecha DESC LIMIT 6";
        Cursor cursor = lectura.rawQuery (query, null);
        cursor.moveToFirst();
        List<Comparacion> comparacionList = new ArrayList<>();

        if (cursor.getCount() > 0) {
            do {
                System.out.println("Comparacion ID " +
                        cursor.getInt(0) +
                        " entre busqueda:" +
                        cursor.getInt(3) +
                        " y" +
                        cursor.getInt(4) +
                        "\n");

                Busqueda busqueda1 = getDataBusqueda(cursor.getInt(3));
                Busqueda busqueda2 = getDataBusqueda(cursor.getInt(4));

                // Si hay algun error en las busquedas
                if (busqueda1.getId() != 0 && busqueda2.getId() != 0) {
                    System.out.println("Busqueda 1: \n " + busqueda1.toString() + "\nBusqueda 2: \n " + busqueda2.toString());

                    comparacionList.add(new Comparacion(new Date(cursor.getLong(2)), busqueda1, busqueda2));
                } else {
                    System.out.println("Ha ocurrido un error con las busquedas \n");
                }

            } while (cursor.moveToNext());
        }
        lectura.close();

        return comparacionList;
    }

    // Checkeo del login
    public Usuario checkLogin(String email, String contraseña){
        SQLiteDatabase lectura = getReadableDatabase();
        String query = "SELECT * FROM usuario WHERE email = "
                + "\"" + email + "\""
                + " AND contraseña = "
                + "\"" + contraseña + "\"" ;

        System.out.println(query);

        Cursor cursor = lectura.rawQuery (query, null);

        Usuario usuario;
        if (cursor.getCount() == 1) // Ya existe ese usuario
        {
            cursor.moveToFirst();
            usuario = new Usuario(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
        }
        else
        {
            usuario = new Usuario();
        }

        lectura.close();

        return usuario;
    }
}