
package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dato implements Serializable {

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("hora")
    @Expose
    private Integer hora;

    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getHora() {
        return hora;
    }
    public void setHora(Integer hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Dato{" +
                "value=" + value +
                ", hora=" + hora +
                '}';
    }
}
