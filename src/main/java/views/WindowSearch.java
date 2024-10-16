package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Person_Vo;
import controllers.Coordinator;

public class WindowSearch extends JFrame implements ActionListener {

    private Coordinator miCoordinador;
    private JTextField textCod, textNombre, textEdad, textTelefono, textProfesion;
    private JButton botonBuscar, botonModificar, botonEliminar, botonCancelar;

    public WindowSearch() {
        setTitle("Buscar Persona");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelTitulo = new JLabel("Buscar/Modificar Persona");
        labelTitulo.setBounds(120, 20, 200, 30);
        add(labelTitulo);

        // Inicializar los campos de texto y etiquetas
        JLabel cod = new JLabel("Código:");
        cod.setBounds(20, 80, 80, 25);
        add(cod);

        textCod = new JTextField();
        textCod.setBounds(100, 80, 100, 25);
        add(textCod);

        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(20, 120, 80, 25);
        add(nombre);

        textNombre = new JTextField();
        textNombre.setBounds(100, 120, 200, 25);
        add(textNombre);

        JLabel telefono = new JLabel("Teléfono:");
        telefono.setBounds(20, 160, 80, 25);
        add(telefono);

        textTelefono = new JTextField();
        textTelefono.setBounds(100, 160, 200, 25);
        add(textTelefono);

        JLabel edad = new JLabel("Edad:");
        edad.setBounds(20, 200, 80, 25);
        add(edad);

        textEdad = new JTextField();
        textEdad.setBounds(100, 200, 50, 25);
        add(textEdad);

        JLabel profesion = new JLabel("Profesión:");
        profesion.setBounds(20, 240, 80, 25);
        add(profesion);

        textProfesion = new JTextField();
        textProfesion.setBounds(100, 240, 200, 25);
        add(textProfesion);

        // Inicializa los botones
        botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(50, 280, 80, 25);
        botonBuscar.addActionListener(this);
        add(botonBuscar);

        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(150, 280, 100, 25);
        botonModificar.addActionListener(this);
        add(botonModificar);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(270, 280, 100, 25);
        botonEliminar.addActionListener(this);
        add(botonEliminar);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(270, 320, 100, 25);
        botonCancelar.addActionListener(this);
        add(botonCancelar);
    }

    public void setCoordinator(Coordinator miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonBuscar) {
            Person_Vo persona = miCoordinador.buscarPersona(textCod.getText());
            if (persona != null) {
                textNombre.setText(persona.getNombrePersona());
                textTelefono.setText(persona.getTelefonoPersona());
                textEdad.setText(String.valueOf(persona.getEdadPersona()));
                textProfesion.setText(persona.getProfesionPersona());
            } else {
                JOptionPane.showMessageDialog(this, "Persona no encontrada.");
            }
        }

        if (e.getSource() == botonModificar) {
            Person_Vo persona = new Person_Vo();
            persona.setIdPersona(Integer.parseInt(textCod.getText()));
            persona.setNombrePersona(textNombre.getText());
            persona.setTelefonoPersona(textTelefono.getText());
            persona.setEdadPersona(Integer.parseInt(textEdad.getText()));
            persona.setProfesionPersona(textProfesion.getText());

            miCoordinador.modificarPersona(persona);
            JOptionPane.showMessageDialog(this, "Modificación exitosa.");
        }

        if (e.getSource() == botonEliminar) {
            miCoordinador.eliminarPersona(textCod.getText());
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Eliminación exitosa.");
        }

        if (e.getSource() == botonCancelar) {
            this.dispose();
        }
    }

    private void limpiarCampos() {
        textCod.setText("");
        textNombre.setText("");
        textTelefono.setText("");
        textEdad.setText("");
        textProfesion.setText("");
    }
}
