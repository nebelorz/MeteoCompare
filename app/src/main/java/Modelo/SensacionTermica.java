
package Modelo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SensacionTermica implements Serializable {

    @SerializedName("maxima")
    @Expose
    private Integer maxima;

    @SerializedName("minima")
    @Expose
    private Integer minima;

    @SerializedName("dato")
    @Expose
    private List<Dato> dato = null;

    public Integer getMaxima() {
        return maxima;
    }
    public void setMaxima(Integer maxima) {
        this.maxima = maxima;
    }

    public Integer getMinima() {
        return minima;
    }
    public void setMinima(Integer minima) {
        this.minima = minima;
    }

    public List<Dato> getDato() {
        return dato;
    }
    public void setDato(List<Dato> dato) {
        this.dato = dato;
    }

    @NonNull
    @Override
    public String toString() {
        return "SensacionTermica{" +
                "maxima=" + maxima +
                ", minima=" + minima +
                ", dato=" + dato +
                '}';
    }
}
