package com.impuestos.model;

/**
 * Representa un vehículo con los datos necesarios para calcular impuestos.
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cilindraje;
    private double avaluo;
    private String tipoUso; // "particular" o "publico"

    public Vehiculo(String marca, String modelo, int anioFabricacion, int cilindraje, double avaluo, String tipoUso) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.cilindraje = cilindraje;
        this.avaluo = avaluo;
        this.tipoUso = tipoUso;
    }

    // Getters y setters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnioFabricacion() { return anioFabricacion; }
    public int getCilindraje() { return cilindraje; }
    public double getAvaluo() { return avaluo; }
    public String getTipoUso() { return tipoUso; }

    public int getAntiguedad(int anioActual) {
        return anioActual - anioFabricacion;
    }
}
