package com.example.meteocompare;

import java.io.Serializable;

public class Usuario implements Serializable {

    // Atts
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private com.example.meteocompare.Historial historial;

    // Constructors
    public Usuario()
    {
        this.id = 0;
        this.nombre = "";
        this.correo = "";
        this.password = "";
        this.historial = new com.example.meteocompare.Historial();
    }

    public Usuario(int id, String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.historial = new com.example.meteocompare.Historial();
    }
    public Usuario(int id, String nombre, String correo, String password, com.example.meteocompare.Historial historial) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.historial = historial;
    }

    // Gets & Sets
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public com.example.meteocompare.Historial getHistorial() {
        return historial;
    }

    public void setHistorial(com.example.meteocompare.Historial historial) {
        this.historial = historial;
    }

    // ToString
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", historial='" + historial.toString() + '\'' +
                '}';
    }
}
