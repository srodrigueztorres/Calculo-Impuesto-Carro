package com.impuestos;

import com.impuestos.view.ImpuestoView;
import com.impuestos.controller.ImpuestoController;
import javax.swing.SwingUtilities;

/**
 * Punto de entrada de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImpuestoView view = new ImpuestoView();
            new ImpuestoController(view);
            view.setVisible(true);
        });
    }
}
