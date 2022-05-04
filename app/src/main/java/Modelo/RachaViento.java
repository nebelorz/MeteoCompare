
package Modelo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RachaViento implements Serializable {

    @SerializedName("value")
    @Expose
    private int value;

    @SerializedName("periodo")
    @Expose
    private String periodo;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
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
        return "RachaViento{" +
                "value='" + value + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
