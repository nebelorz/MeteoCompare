package com.example.meteocompare;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Modelo.PrediccionMunicipio;
import Modelo.ProbPrecipitacion;
import Modelo.Viento;

public class ActivityResultadoComparacion extends AppCompatActivity {

    // Atts
    private TextView tvFecha;
    private TextView tvLocalidad1;
    private TextView tvLocalidad2;
    private TextView tvMaxTemp1;
    private TextView tvMaxTemp2;
    private TextView tvMinTemp1;
    private TextView tvMinTemp2;
    private TextView tvAvgTemp1;
    private TextView tvAvgTemp2;
    private TextView tvUvMax1;
    private TextView tvUvMax2;
    private TextView tvAvgViento1;
    private TextView tvAvgViento2;
    private TextView tvPrecipitacion1;
    private TextView tvPrecipitacion2;
    private TextView tvCielo1;
    private TextView tvCielo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadocomparacion);

        // TextView con el layout
        tvFecha = findViewById(R.id.tvFecha);
        tvLocalidad1 = findViewById(R.id.tvLocalidad1);
        tvLocalidad2 = findViewById(R.id.tvLocalidad2);
        tvMaxTemp1 = findViewById(R.id.tvMaxTemp1);
        tvMaxTemp2 = findViewById(R.id.tvMaxTemp2);
        tvMinTemp1 = findViewById(R.id.tvMinTemp1);
        tvMinTemp2 = findViewById(R.id.tvMinTemp2);
        tvAvgTemp1 = findViewById(R.id.tvAvgTemp1);
        tvAvgTemp2 = findViewById(R.id.tvAvgTemp2);
        tvUvMax1 = findViewById(R.id.tvUvMax1);
        tvUvMax2 = findViewById(R.id.tvUvMax2);
        tvAvgViento1 = findViewById(R.id.tvAvgViento1);
        tvAvgViento2 = findViewById(R.id.tvAvgViento2);
        tvPrecipitacion1 = findViewById(R.id.tvPrecipitacion1);
        tvPrecipitacion2 = findViewById(R.id.tvPrecipitacion2);
        tvCielo1 = findViewById(R.id.tvCielo1);
        tvCielo2 = findViewById(R.id.tvCielo2);

        PrediccionMunicipio prediccion1 = (PrediccionMunicipio) getIntent().getExtras().getSerializable("prediccionMunicipio1");
        PrediccionMunicipio prediccion2 = (PrediccionMunicipio) getIntent().getExtras().getSerializable("prediccionMunicipio2");

        // Obtencion datos de la prediccion 1
        int maxTemp1 = prediccion1.getPrediccion().getDia().get(1).getTemperatura().getMaxima();
        int minTemp1 = prediccion1.getPrediccion().getDia().get(1).getTemperatura().getMinima();
        float avgTemp1 = (maxTemp1+minTemp1)/2;
        int precipitacion1 = getProbPrecMax(prediccion1);
        int uvMax1 = prediccion1.getPrediccion().getDia().get(1).getUvMax();
        int maxViento1 = getVientoMax(prediccion1);
        int minViento1 = getVientoMin(prediccion1);
        int avgViento1 = (maxViento1+minViento1)/2;
        String cielo1 = prediccion1.getPrediccion().getDia().get(1).getEstadoCielo().get(0).getDescripcion();
        String municipio1 = prediccion1.getNombre();
        String provincia1 = prediccion1.getProvincia();

        // Obtencion datos de la prediccion 2
        int maxTemp2 = prediccion2.getPrediccion().getDia().get(1).getTemperatura().getMaxima();
        int minTemp2 = prediccion2.getPrediccion().getDia().get(1).getTemperatura().getMinima();
        float avgTemp2 = (maxTemp2+minTemp2)/2;
        int precipitacion2 = getProbPrecMax(prediccion2);
        int uvMax2 = prediccion2.getPrediccion().getDia().get(1).getUvMax();
        int maxViento2 = getVientoMax(prediccion2);
        int minViento2 = getVientoMin(prediccion2);
        int avgViento2 = (maxViento2+minViento2)/2;
        String cielo2 = prediccion2.getPrediccion().getDia().get(1).getEstadoCielo().get(0).getDescripcion();
        String municipio2 = prediccion2.getNombre();
        String provincia2 = prediccion2.getProvincia();

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date fecha1 = new Date();
        try {
            fecha1 = dateFormat1.parse(prediccion1.getPrediccion().getDia().get(1).getFecha());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date fechaComparacion = Calendar.getInstance().getTime();

        System.out.println(fechaComparacion.toString());

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");

        tvFecha.setText("Prediccion del " + dateFormat2.format(fecha1));
        tvLocalidad1.setText(prediccion1.getNombre());
        tvLocalidad2.setText( prediccion2.getNombre());
        tvMaxTemp1.setText(""+maxTemp1+"°C");
        tvMaxTemp2.setText(""+maxTemp2+"°C");
        tvMinTemp1.setText(""+minTemp1+"°C");
        tvMinTemp2.setText(""+minTemp2+"°C");
        tvAvgTemp1.setText(""+avgTemp1+"°C");
        tvAvgTemp2.setText(""+avgTemp2+"°C");
        tvUvMax1.setText(""+uvMax1+" IUV");
        tvUvMax2.setText(""+uvMax2+" IUV");
        tvAvgViento1.setText(""+avgViento1+"km/h");
        tvAvgViento2.setText(""+avgViento2+"km/h");
        tvPrecipitacion1.setText(""+precipitacion1+"%");
        tvPrecipitacion2.setText(""+precipitacion2+"%");
        tvCielo1.setText(cielo1);
        tvCielo2.setText(cielo2);

        Busqueda busqueda1 = new Busqueda(0, municipio1, provincia1, fecha1, minTemp1, maxTemp1, avgTemp1, avgViento1, uvMax1, precipitacion1, cielo1);
        Busqueda busqueda2 = new Busqueda(0, municipio2, provincia2, fecha1, minTemp2, maxTemp2, avgTemp2, avgViento2, uvMax2, precipitacion2, cielo2);

        // Instancia de la BD
        BaseDeDatos bd = new BaseDeDatos(this, "android", null, 1);

        // Call del metodo para insertar comparacion en la BD
        bd.insertDataComparacion(
                UsuarioHolder.getInstance().getUsuarioLogueado().getId(),   // user_id
                fechaComparacion,                                           // fecha
                busqueda1,                                                  // busqueda1
                busqueda2);                                                 // busqueda2
    }

    private int getVientoMax(PrediccionMunicipio prediccion){
        List<Viento> vientoList = prediccion.getPrediccion().getDia().get(0).getViento();
        int vientoMax = vientoList.get(0).getVelocidad();

        for(Viento viento : vientoList)
        {
            if (viento.getVelocidad() > vientoMax)
            {
                vientoMax = viento.getVelocidad();
            }
        }
        return vientoMax;
    }

    private int getVientoMin(PrediccionMunicipio prediccion) {
        List<Viento> vientoList = prediccion.getPrediccion().getDia().get(0).getViento();
        int vientoMin = vientoList.get(0).getVelocidad();

        for(Viento viento : vientoList)
        {
            if (viento.getVelocidad() < vientoMin)
            {
                vientoMin = viento.getVelocidad();
            }
        }
        return vientoMin;
    }

    private int getProbPrecMax(PrediccionMunicipio prediccion){
        List<ProbPrecipitacion> probPrecipitacionList = prediccion.getPrediccion().getDia().get(0).getProbPrecipitacion();
        int probPrecipitacion = probPrecipitacionList.get(0).getValue();

        for(ProbPrecipitacion precipitacion : probPrecipitacionList)
        {
            if (precipitacion.getValue() > probPrecipitacion)
            {
                probPrecipitacion = precipitacion.getValue();
            }
        }
        return probPrecipitacion;
    }
}