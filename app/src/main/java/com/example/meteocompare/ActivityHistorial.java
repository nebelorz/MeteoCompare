package com.example.meteocompare;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.text.SimpleDateFormat;

public class ActivityHistorial extends AppCompatActivity {

    // Atts
    TextView textoHistorial;
    TextView historial1;
    TextView historial2;
    TextView historial3;
    TextView historial4;
    TextView historial5;

    String separador = " || ";
    String vs = " <-> ";

    List<Comparacion> comparacionLista;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        textoHistorial = findViewById(R.id.TextoHistorial);
        historial1 = findViewById(R.id.H1);
        historial2 = findViewById(R.id.H2);
        historial3 = findViewById(R.id.H3);
        historial4 = findViewById(R.id.H4);
        historial5 = findViewById(R.id.H5);

        // Click no permitido
        historial1.setEnabled(false);
        historial2.setEnabled(false);
        historial3.setEnabled(false);
        historial4.setEnabled(false);
        historial5.setEnabled(false);

        // Datos de las ultimas comparaciones
        BaseDeDatos bd = new BaseDeDatos(this, "android", null, 1);
        comparacionLista = bd.getDataComparacion(UsuarioHolder.getInstance().getUsuarioLogueado().getId());

        // Guardamos datos en el historial
        UsuarioHolder.getInstance().getUsuarioLogueado().setHistorial(new Historial(comparacionLista));

        // DateFormat para la fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Muestra las comparaciones
        for (Comparacion comparacion : comparacionLista)
        {
            System.out.println("Comparacion: " + comparacion.toString());
        }

        if (comparacionLista.size() > 0) {
            historial1.setText(
                    dateFormat.format(comparacionLista.get(0).getFecha()) +
                    separador +
                    comparacionLista.get(0).getBusqueda1().getUbicacion() +
                    vs +
                    comparacionLista.get(0).getBusqueda2().getUbicacion() +
                    separador);
            historial1.setEnabled(true);

            if (comparacionLista.size() > 1) {
                historial2.setText(
                        dateFormat.format(comparacionLista.get(0).getFecha()) +
                        separador +
                        comparacionLista.get(1).getBusqueda1().getUbicacion() +
                        vs +
                        comparacionLista.get(1).getBusqueda2().getUbicacion() +
                        separador);
                historial2.setEnabled(true);
            }
            if (comparacionLista.size() > 2) {
                historial3.setText(
                        dateFormat.format(comparacionLista.get(0).getFecha()) +
                        separador +
                        comparacionLista.get(2).getBusqueda1().getUbicacion() +
                        vs +
                        comparacionLista.get(2).getBusqueda2().getUbicacion() +
                        separador);
                historial3.setEnabled(true);
            }
            if (comparacionLista.size() > 3) {
                historial4.setText(
                        dateFormat.format(comparacionLista.get(3).getFecha()) +
                        separador +
                        comparacionLista.get(3).getBusqueda1().getUbicacion() +
                        vs +
                        comparacionLista.get(3).getBusqueda2().getUbicacion() +
                        separador);
                historial4.setEnabled(true);
            }
            if (comparacionLista.size() > 4) {
                historial5.setText(
                        dateFormat.format(comparacionLista.get(4).getFecha()) +
                        separador +
                        comparacionLista.get(4).getBusqueda1().getUbicacion() +
                        vs +
                        comparacionLista.get(4).getBusqueda2().getUbicacion() +
                        separador);
                historial5.setEnabled(true);
            }
        } else {
            historial1.setText("No has hecho comparaciones aún");
        }

        historial1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHistorial.this, ResultadoHistorial.class);
                intent.putExtra("comparacion", comparacionLista.get(0));
                startActivity(intent);
            }
        });

        historial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHistorial.this, ResultadoHistorial.class);
                intent.putExtra("comparacion", comparacionLista.get(1));
                startActivity(intent);

            }
        });

        historial3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHistorial.this, ResultadoHistorial.class);
                intent.putExtra("comparacion", comparacionLista.get(2));
                startActivity(intent);
            }
        });

        historial4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHistorial.this, ResultadoHistorial.class);
                intent.putExtra("comparacion", comparacionLista.get(3));
                startActivity(intent);
            }
        });

        historial5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHistorial.this, ResultadoHistorial.class);
                intent.putExtra("comparacion", comparacionLista.get(4));
                startActivity(intent);
            }
        });

    }
}