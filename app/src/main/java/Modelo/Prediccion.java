
package Modelo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Prediccion implements Serializable {

    @SerializedName("dia")
    @Expose
    private List<ModelMain> dia = null;

    public List<ModelMain> getDia() {
        return dia;
    }

    public void setDia(List<ModelMain> dia) {
        this.dia = dia;
    }

    @NonNull
    @Override
    public String toString() {
        return "Prediccion{" +
                "dia=" + dia +
                '}';
    }
}
