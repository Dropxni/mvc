package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import controllers.Coordinator;

public class MainWindow extends JFrame implements ActionListener {

    private Coordinator miCoordinador; // Objeto miCoordinador que permite la relación entre esta clase y el coordinador
    private JTextArea areaIntroduccion;
    private JLabel labelTitulo, labelSeleccion;
    private JButton botonRegistrar, botonBuscar;

    /**
     * Establece la información que se presentará como introducción del sistema
     */
    public String textoIntroduccion = "";

    /**
     * Constructor de la clase donde se inicializan todos los componentes de la ventana principal
     */
    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        botonRegistrar = new JButton();
        botonRegistrar.setBounds(100, 280, 120, 25);
        botonRegistrar.setText("Registrar");

        botonBuscar = new JButton();
        botonBuscar.setBounds(240, 280, 120, 25);
        botonBuscar.setText("Buscar");

        labelTitulo = new JLabel();
        labelTitulo.setText("PATRÓN MODELO VISTA CONTROLADOR");
        labelTitulo.setBounds(60, 40, 380, 30);
        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

        labelSeleccion = new JLabel();
        labelSeleccion.setText("Escoja qué operación desea realizar");
        labelSeleccion.setBounds(75, 240, 250, 25);

        textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patrón "
                + "de diseño MVC.\n\n"
                + "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Persona. "
                + "También están vinculados algunos conceptos de los patrones Value Object y Data Access Object.";

        areaIntroduccion = new JTextArea();
        areaIntroduccion.setBounds(50, 90, 380, 140);
        areaIntroduccion.setEditable(false);
        areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
        areaIntroduccion.setLineWrap(true);
        areaIntroduccion.setText(textoIntroduccion);
        areaIntroduccion.setWrapStyleWord(true);
        areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
                javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(0, 0, 0)));

        botonRegistrar.addActionListener(this);
        botonBuscar.addActionListener(this);

        add(botonBuscar);
        add(botonRegistrar);
        add(labelSeleccion);
        add(labelTitulo);
        add(areaIntroduccion);

        setSize(480, 350);
        setTitle("Patrones de Diseño/MVC");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    /**
     * Establece el coordinador que controla las interacciones
     * @param miCoordinador Coordinador principal
     */
    public void setCoordinator(Coordinator miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrar) {
            miCoordinador.mostrarVentanaRegistro();
        }
        if (e.getSource() == botonBuscar) {
            miCoordinador.mostrarVentanaBuscar();
        }
    }
}
