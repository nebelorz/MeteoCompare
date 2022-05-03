package Modelo;

import java.io.Serializable;

// Clase para almacenar el resultado de la peticion
public class Model200 implements Serializable {

    // Atts
    private int estado;
    private String datos;
    private String metadatos;
    private String descripcion;

    // Gets & Sets
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDatos() {
        return datos;
    }
    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getMetadatos() {
        return metadatos;
    }
    public void setMetadatos(String metadatos) {
        this.metadatos = metadatos;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // ToString
    @Override
    public String toString() {
        return "Model200{" +
                "descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", datos='" + datos + '\'' +
                ", metadatos='" + metadatos + '\'' +
                '}';
    }
}
