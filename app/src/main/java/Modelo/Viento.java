
package Modelo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Viento implements Serializable {

    @SerializedName("direccion")
    @Expose
    private String direccion;

    @SerializedName("velocidad")
    @Expose
    private Integer velocidad;

    @SerializedName("periodo")
    @Expose
    private String periodo;

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @NonNull
    @Override
    public String toString() {
        return "Viento{" +
                "direccion='" + direccion + '\'' +
                ", velocidad=" + velocidad +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
