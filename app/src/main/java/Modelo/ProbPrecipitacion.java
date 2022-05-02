
package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProbPrecipitacion implements Serializable {

    @SerializedName("value")
    @Expose
    private Integer value;

    @SerializedName("periodo")
    @Expose
    private String periodo;

    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "ProbPrecipitacion{" +
                "value=" + value +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
