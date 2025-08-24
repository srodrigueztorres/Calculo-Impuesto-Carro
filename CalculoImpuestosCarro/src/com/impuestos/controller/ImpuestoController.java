package com.impuestos.controller;

import com.impuestos.model.Vehiculo;
import com.impuestos.model.CalculadoraImpuestos;
import com.impuestos.view.ImpuestoView;
import java.time.LocalDate;

/**
 * Controlador que une Modelo y Vista.
 */
public class ImpuestoController {
    private ImpuestoView view;

    public ImpuestoController(ImpuestoView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.setCalcularListener(e -> calcular());
        view.setLimpiarListener(e -> view.limpiar());
    }

    private void calcular() {
        try {
            String marca = view.getMarca();
            String modelo = view.getModelo();
            int anio = Integer.parseInt(view.getAnio());
            int cilindraje = Integer.parseInt(view.getCilindraje());
            double avaluo = Double.parseDouble(view.getAvaluo());
            String tipoUso = view.getTipoUso();

            Vehiculo v = new Vehiculo(marca, modelo, anio, cilindraje, avaluo, tipoUso);
            int anioActual = LocalDate.now().getYear();
            double impuesto = CalculadoraImpuestos.calcularImpuesto(v, anioActual);

            view.mostrarResultado(String.format("%,.2f", impuesto));
        } catch (NumberFormatException ex) {
            view.mostrarError("Verifique que los campos numéricos estén correctamente diligenciados.");
        } catch (Exception ex) {
            view.mostrarError("Ocurrió un error: " + ex.getMessage());
        }
    }
}
