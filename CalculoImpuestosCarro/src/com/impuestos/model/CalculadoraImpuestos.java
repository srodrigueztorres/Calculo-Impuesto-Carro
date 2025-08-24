package com.impuestos.model;

/**
 * Lógica de negocio para cálculo de impuestos.
 * Las reglas de cálculo son ilustrativas y deben adaptarse a la normativa vigente.
 */
public class CalculadoraImpuestos {

    /**
     * Calcula el impuesto base según el avalúo y la categoría.
     * Regla ejemplo:
     *  - Impuesto base = avaluo * tarifa
     *  - tarifa base: 1.5% (0.015)
     *  - descuento por antigüedad: 0.1% por cada año mayor a 5 años, acumulable hasta 50% del impuesto
     *  - ajuste por tipo de uso: "publico" tiene 20% de descuento sobre el impuesto final (ejemplo)
     */
    public static double calcularImpuesto(Vehiculo v, int anioActual) {
        double tarifaBase = 0.015; // 1.5%
        double impuestoBase = v.getAvaluo() * tarifaBase;

        int antiguedad = v.getAntiguedad(anioActual);
        double descuentoAntiguedad = 0.0;
        if (antiguedad > 5) {
            int extraYears = antiguedad - 5;
            descuentoAntiguedad = 0.001 * extraYears; // 0.1% por año extra
            // limitar el descuento al 50% del impuesto
            if (descuentoAntiguedad > 0.5 * impuestoBase) {
                descuentoAntiguedad = 0.5 * impuestoBase;
            }
        }

        double impuestoDespuesAntiguedad = impuestoBase - descuentoAntiguedad;

        // Ajuste por cilindraje (ejemplo): si cilindraje > 2000, agregar 10% al impuesto
        if (v.getCilindraje() > 2000) {
            impuestoDespuesAntiguedad *= 1.10;
        }

        // Ajuste por tipo de uso
        if ("publico".equalsIgnoreCase(v.getTipoUso())) {
            impuestoDespuesAntiguedad *= 0.80; // 20% descuento para público (ejemplo)
        }

        return Math.max(0.0, impuestoDespuesAntiguedad);
    }
}
