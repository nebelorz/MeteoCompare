package com.example.meteocompare;

import java.io.Serializable;
import java.util.Date;

public class Busqueda implements Serializable {
    // Atts
    private int id;
    private String ubicacion;
    private String provincia;
    private Date fecha;
    private float maxTemp;
    private float minTemp;
    private float avgTemp;
    private float avgViento;
    private float uvMax;
    private String cielo;
    private float precipitacion;


    // Const
    public Busqueda(int id, String ubicacion, String provincia, Date fecha, float minTemp, float maxTemp, float avgTemp, float avgViento, float uvMax, float precipitacion, String cielo) {
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

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getProvincia() { return provincia; }

    public void setProvincia(String provincia) { this.provincia = provincia; }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(float avgTemp) {
        this.avgTemp = avgTemp;
    }

    public float getAvgViento() {
        return avgViento;
    }

    public void setAvgViento(float avgViento) {
        this.avgViento = avgViento;
    }

    public float getUvMax() {
        return uvMax;
    }

    public void setUvMax(float uvMax) {
        this.uvMax = uvMax;
    }

    public float getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(float precipitacion) {
        this.precipitacion = precipitacion;
    }

    public String getCielo() {
        return cielo;
    }

    public void setCielo(String cielo) {
        this.cielo = cielo;
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
