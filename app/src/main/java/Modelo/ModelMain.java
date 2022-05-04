
package Modelo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ModelMain implements Serializable {

    @SerializedName("probPrecipitacion")
    @Expose
    private List<ProbPrecipitacion> probPrecipitacion = null;

    @SerializedName("cotaNieve")
    @Expose
    private List<CotaNieve> cotaNieve = null;

    @SerializedName("estadoCielo")
    @Expose
    private List<EstadoCielo> estadoCielo = null;

    @SerializedName("viento")
    @Expose
    private List<Viento> viento = null;

    @SerializedName("rachaViento")
    @Expose
    private List<RachaViento> rachaViento = null;

    @SerializedName("temperatura")
    @Expose
    private Temperatura temperatura;

    @SerializedName("sensacionTermica")
    @Expose
    private SensacionTermica sensacionTermica;

    @SerializedName("humedadRelativa")
    @Expose
    private HumedadRelativa humedadRelativa;

    @SerializedName("uvMax")
    @Expose
    private Integer uvMax;

    @SerializedName("fecha")
    @Expose
    private String fecha;

    // Gets & Sets
    public List<ProbPrecipitacion> getProbPrecipitacion() {
        return probPrecipitacion;
    }
    public void setProbPrecipitacion(List<ProbPrecipitacion> probPrecipitacion) { this.probPrecipitacion = probPrecipitacion; }

    public List<CotaNieve> getCotaNieve() {
        return cotaNieve;
    }
    public void setCotaNieve(List<CotaNieve> cotaNieve) {
        this.cotaNieve = cotaNieve;
    }

    public List<EstadoCielo> getEstadoCielo() {
        return estadoCielo;
    }
    public void setCielo(List<EstadoCielo> estadoCielo) {
        this.estadoCielo = estadoCielo;
    }

    public List<Viento> getViento() {
        return viento;
    }
    public void setViento(List<Viento> viento) {
        this.viento = viento;
    }

    public List<RachaViento> getRachaMax() { return rachaViento; }
    public void setRachaMax(List<RachaViento> rachaVientos) {
        this.rachaViento = rachaVientos;
    }

    public Temperatura getTemperatura() { return temperatura; }
    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    public SensacionTermica getSensTermica() {
        return sensacionTermica;
    }
    public void setSensTermica(SensacionTermica sensacionTermica) { this.sensacionTermica = sensacionTermica; }

    public HumedadRelativa getHumedadRelativa() {
        return humedadRelativa;
    }
    public void setHumedadRelativa(HumedadRelativa humedadRelativa) { this.humedadRelativa = humedadRelativa; }

    public Integer getUvMax() { return uvMax; }
    public void setUvMax(Integer uvMax) {
        this.uvMax = uvMax;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @NonNull
    @Override
    public String toString() {
        return "ModelMain{" +
                "probPrecipitacion=" + probPrecipitacion +
                ", cotaNieve=" + cotaNieve +
                ", estadoCielo=" + estadoCielo +
                ", viento=" + viento +
                ", rachaViento=" + rachaViento +
                ", temperatura=" + temperatura +
                ", sensacionTermica=" + sensacionTermica +
                ", humedadRelativa=" + humedadRelativa +
                ", uvMax=" + uvMax +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
