package com.example.meteocompare;

import java.io.Serializable;
import java.util.Date;

public class Busqueda implements Serializable {
    // Atts
    private int id;
    private final String ubicacion;
    private final String provincia;
    private final String cielo;
    private final Date fecha;
    private final int maxTemp;
    private final int minTemp;
    private final int avgTemp;
    private final int avgViento;
    private final int uvMax;
    private final int precipitacion;


    // Const
    public Busqueda(int id, String ubicacion, String provincia, Date fecha, int minTemp, int maxTemp, int avgTemp, int avgViento, int uvMax, int precipitacion, String cielo) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.provincia = provincia;
        this.fecha = fecha;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.avgTemp = avgTemp;
        this.avgViento = avgViento;
        this.uvMax = uvMax;
        this.precipitacion = precipitacion;
        this.cielo = cielo;
    }

    // Plantilla del constructor
    public Busqueda() {
        this.id = 0;
        this.ubicacion = "";
        this.provincia = "";
        this.fecha = new Date();
        this.minTemp = 0;
        this.maxTemp = 0;
        this.avgTemp = 0;
        this.avgViento = 0;
        this.uvMax = 0;
        this.precipitacion = 0;
        this.cielo = "";
    }

    // Gets y Sets
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getProvincia() { return provincia; }

    public Date getFecha() {
        return fecha;
    }

    public int getMinTemp() { return minTemp; }

    public int getMaxTemp() { return maxTemp; }

    public int getAvgTemp() { return avgTemp; }

    public int getAvgViento() { return avgViento; }

    public int getUvMax() { return uvMax; }

    public int getPrecipitacion() {
        return precipitacion;
    }

    public String getCielo() {
        return cielo;
    }

    // ToString
    @Override
    public String toString() {
        return "Busqueda{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", fecha=" + fecha +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", avgTemp=" + avgTemp +
                ", avgViento=" + avgViento +
                ", uxMax=" + uvMax +
                ", precipitacion=" + precipitacion +
                ", cielo=" + cielo +
                '}';
    }
}
