package com.example.meteocompare;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Historial implements Serializable {
    // Atts
    private final List<Comparacion> historial;

    public Historial() {
        historial = new ArrayList<>();
    }
    public Historial(List<Comparacion> historial) {
        this.historial = historial;
    }

    // ToString
    @Override
    public String toString() {
        return "Historial";
    }
}
