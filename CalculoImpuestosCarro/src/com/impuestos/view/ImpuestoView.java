package com.impuestos.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Vista simple en Swing para ingresar datos y mostrar el resultado.
 */
public class ImpuestoView extends JFrame {
    private JTextField tfMarca = new JTextField(15);
    private JTextField tfModelo = new JTextField(15);
    private JTextField tfAnio = new JTextField(6);
    private JTextField tfCilindraje = new JTextField(6);
    private JTextField tfAvaluo = new JTextField(10);
    private JComboBox<String> cbTipoUso = new JComboBox<>(new String[]{"particular", "publico"});
    private JButton btnCalcular = new JButton("Calcular");
    private JButton btnLimpiar = new JButton("Limpiar");
    private JLabel lblResultado = new JLabel("Resultado: ");

    public ImpuestoView() {
        super("Cálculo de impuestos de un carro - MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 300);
        setLocationRelativeTo(null);
        initLayout();
    }

    private void initLayout() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0; p.add(new JLabel("Marca:"), c);
        c.gridx = 1; p.add(tfMarca, c);

        c.gridx = 0; c.gridy++; p.add(new JLabel("Modelo:"), c);
        c.gridx = 1; p.add(tfModelo, c);

        c.gridx = 0; c.gridy++; p.add(new JLabel("Año fabricación:"), c);
        c.gridx = 1; p.add(tfAnio, c);

        c.gridx = 0; c.gridy++; p.add(new JLabel("Cilindraje (cc):"), c);
        c.gridx = 1; p.add(tfCilindraje, c);

        c.gridx = 0; c.gridy++; p.add(new JLabel("Avalúo comercial:"), c);
        c.gridx = 1; p.add(tfAvaluo, c);

        c.gridx = 0; c.gridy++; p.add(new JLabel("Tipo de uso:"), c);
        c.gridx = 1; p.add(cbTipoUso, c);

        c.gridx = 0; c.gridy++; p.add(btnCalcular, c);
        c.gridx = 1; p.add(btnLimpiar, c);

        c.gridx = 0; c.gridy++; c.gridwidth = 2;
        p.add(lblResultado, c);

        add(p);
    }

    // Accessors para controlador
    public String getMarca() { return tfMarca.getText().trim(); }
    public String getModelo() { return tfModelo.getText().trim(); }
    public String getAnio() { return tfAnio.getText().trim(); }
    public String getCilindraje() { return tfCilindraje.getText().trim(); }
    public String getAvaluo() { return tfAvaluo.getText().trim(); }
    public String getTipoUso() { return (String)cbTipoUso.getSelectedItem(); }

    public void setCalcularListener(ActionListener l) { btnCalcular.addActionListener(l); }
    public void setLimpiarListener(ActionListener l) { btnLimpiar.addActionListener(l); }

    public void mostrarResultado(String texto) { lblResultado.setText("Resultado: " + texto); }
    public void mostrarError(String msg) { JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE); }
    public void limpiar() {
        tfMarca.setText(""); tfModelo.setText(""); tfAnio.setText(""); tfCilindraje.setText(""); tfAvaluo.setText("");
        cbTipoUso.setSelectedIndex(0); lblResultado.setText("Resultado: ");
    }
}
