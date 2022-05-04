package com.example.meteocompare;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;

public class ResultadoHistorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadocomparacion);

        // Atts
        TextView tvFecha;
        TextView tvLocalidad1;
        TextView tvLocalidad2;
        TextView tvMaxTemp1;
        TextView tvMaxTemp2;
        TextView tvMinTemp1;
        TextView tvMinTemp2;
        TextView tvAvgTemp1;
        TextView tvAvgTemp2;
        TextView tvUvMax1;
        TextView tvUvMax2;
        TextView tvAvgViento1;
        TextView tvAvgViento2;
        TextView tvPrecipitacion1;
        TextView tvPrecipitacion2;
        TextView tvCielo1;
        TextView tvCielo2;

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

        // Obtencion datos
        Comparacion comparacion = (Comparacion) getIntent().getExtras().getSerializable("comparacion");

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");

        tvFecha.setText("Comparación para el " + dateFormat2.format(comparacion.getBusqueda1().getFecha()));
        tvLocalidad1.setText(comparacion.getBusqueda1().getUbicacion());
        tvMaxTemp1.setText(""+comparacion.getBusqueda1().getMaxTemp()+"°C");
        tvMinTemp1.setText(""+comparacion.getBusqueda1().getMinTemp()+"°C");
        tvAvgTemp1.setText(""+comparacion.getBusqueda1().getAvgTemp()+"°C");
        tvUvMax1.setText(""+comparacion.getBusqueda1().getUvMax()+" IUV");
        tvAvgViento1.setText(""+comparacion.getBusqueda1().getAvgViento()+"km/h");
        tvPrecipitacion1.setText(""+comparacion.getBusqueda1().getPrecipitacion()+"%");
        tvCielo1.setText(""+comparacion.getBusqueda1().getCielo());

        tvLocalidad2.setText(comparacion.getBusqueda2().getUbicacion());
        tvMaxTemp2.setText(""+comparacion.getBusqueda2().getMaxTemp()+"°C");
        tvMinTemp2.setText(""+comparacion.getBusqueda2().getMinTemp()+"°C");
        tvAvgTemp2.setText(""+comparacion.getBusqueda2().getAvgTemp()+"°C");
        tvUvMax2.setText(""+comparacion.getBusqueda2().getUvMax()+" IUV");
        tvAvgViento2.setText(""+comparacion.getBusqueda2().getAvgViento()+"km/h");
        tvPrecipitacion2.setText(""+comparacion.getBusqueda2().getPrecipitacion()+"%");
        tvCielo2.setText(""+comparacion.getBusqueda2().getCielo());
    }
}
