
package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EstadoCielo implements Serializable {

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("periodo")
    @Expose
    private String periodo;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EstadoCielo{" +
                "value='" + value + '\'' +
                ", periodo='" + periodo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
