package Modelo;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Temperatura implements Serializable {

    // Atts
    private int maxima;
    private int minima;

    // Gets & Sets
    public int getMaxima() {
        return maxima;
    }
    public void setMaxima(int maxima) {
        this.maxima = maxima;
    }

    public int getMinima() {
        return minima;
    }
    public void setMinima(int minima) {
        this.minima = minima;
    }

    // ToString
    @NonNull
    @Override
    public String toString() {
        return "PrediccionMunicipio{" +
                "maxima=" + maxima +
                ", minima=" + minima +
                '}';
    }
}
