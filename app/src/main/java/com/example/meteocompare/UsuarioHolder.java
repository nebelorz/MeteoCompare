package com.example.meteocompare;

// Mantiene al usuario loggeado
public class UsuarioHolder {

    private Usuario usuario;

    public Usuario getUsuarioLogueado() {return usuario;}
    public void setUsuarioLogueado(Usuario usuario) {this.usuario = usuario;}

    private static final UsuarioHolder holder = new UsuarioHolder();
    public static UsuarioHolder getInstance() {return holder;}
}
