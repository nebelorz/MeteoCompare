package com.example.meteocompare;

import java.io.Serializable;
import java.util.Date;

public class Comparacion implements Serializable {
    // Atts
    private final Date fecha;
    private final Busqueda busqueda1;
    private final Busqueda busqueda2;

    // Const
    public Comparacion(Date fecha, Busqueda busqueda1, Busqueda busqueda2) {
        this.fecha = fecha;
        this.busqueda1 = busqueda1;
        this.busqueda2 = busqueda2;
    }

    // Plantilla constructor
    public Comparacion() {
        this.fecha = new Date();
        this.busqueda1 = new Busqueda();
        this.busqueda2 = new Busqueda();
    }

    // Gets
    public Date getFecha() {
        return fecha;
    }

    public Busqueda getBusqueda1() {
        return busqueda1;
    }

    public Busqueda getBusqueda2() {
        return busqueda2;
    }

    // ToString
    @Override
    public String toString() {
        return "Comparacion{" +
                "fecha=" + fecha +
                ", busqueda1=" + busqueda1 +
                ", busqueda2=" + busqueda2 +
                '}';
    }
}
