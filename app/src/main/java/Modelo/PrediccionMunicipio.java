
package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PrediccionMunicipio implements Serializable {

    @SerializedName("origen")
    @Expose
    private Origen origen;

    @SerializedName("elaborado")
    @Expose
    private String elaborado;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("provincia")
    @Expose
    private String provincia;

    @SerializedName("prediccion")
    @Expose
    private Prediccion prediccion;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("version")
    @Expose
    private Double version;

    public Origen getOrigen() {
        return origen;
    }
    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public String getElaborado() {
        return elaborado;
    }
    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Prediccion getPrediccion() {
        return prediccion;
    }
    public void setPrediccion(Prediccion prediccion) {
        this.prediccion = prediccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PrediccionMunicipio{" +
                "origen=" + origen +
                ", elaborado='" + elaborado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", prediccion=" + prediccion +
                ", id=" + id +
                ", version=" + version +
                '}';
    }
}
