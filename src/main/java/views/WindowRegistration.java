package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Person_Vo; // Importa el modelo de PersonaVo adaptado a tu proyecto
import controllers.Coordinator; // Importa el coordinador

public class WindowRegistration extends JFrame implements ActionListener {

    private Coordinator miCoordinador; // Objeto miCoordinador que permite la relación entre esta clase y el coordinador
    private JLabel labelTitulo;
    private JTextField textCod, textNombre, textEdad, textTelefono, textProfesion;
    private JLabel cod, nombre, edad, telefono, profesion;
    private JButton botonGuardar, botonCancelar;

    /**
     * Constructor de la clase donde se inicializan todos los componentes
     * de la ventana de registro
     */
    public WindowRegistration() {

        // Configuración de botones
        botonGuardar = new JButton();
        botonGuardar.setBounds(110, 220, 120, 25);
        botonGuardar.setText("Registrar");

        botonCancelar = new JButton();
        botonCancelar.setBounds(250, 220, 120, 25);
        botonCancelar.setText("Cancelar");

        // Configuración del título
        labelTitulo = new JLabel();
        labelTitulo.setText("REGISTRO DE PERSONAS");
        labelTitulo.setBounds(120, 20, 380, 30);
        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

        // Configuración de etiquetas
        cod = new JLabel();
        cod.setText("Código");
        cod.setBounds(20, 80, 80, 25);
        add(cod);

        nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(20, 120, 80, 25);
        add(nombre);

        telefono = new JLabel();
        telefono.setText("Teléfono");
        telefono.setBounds(290, 160, 80, 25);
        add(telefono);

        edad = new JLabel();
        edad.setText("Edad");
        edad.setBounds(290, 120, 80, 25);
        add(edad);

        profesion = new JLabel();
        profesion.setText("Profesión");
        profesion.setBounds(20, 160, 80, 25);
        add(profesion);

        // Configuración de campos de texto
        textCod = new JTextField();
        textCod.setBounds(80, 80, 80, 25);
        add(textCod);

        textNombre = new JTextField();
        textNombre.setBounds(80, 120, 190, 25);
        add(textNombre);

        textTelefono = new JTextField();
        textTelefono.setBounds(340, 160, 80, 25);
        add(textTelefono);

        textEdad = new JTextField();
        textEdad.setBounds(340, 120, 80, 25);
        add(textEdad);

        textProfesion = new JTextField();
        textProfesion.setBounds(80, 160, 190, 25);
        add(textProfesion);

        // Añadir listeners a los botones
        botonGuardar.addActionListener(this);
        botonCancelar.addActionListener(this);
        add(botonCancelar);
        add(botonGuardar);
        add(labelTitulo);

        limpiar(); // Limpia los campos cuando se inicializa
        setSize(480, 300);
        setTitle("Registro de Personas");
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false);
        setLayout(null);
    }

    /**
     * Limpia los campos de texto
     */
    private void limpiar() {
        textCod.setText("");
        textNombre.setText("");
        textEdad.setText("");
        textTelefono.setText("");
        textProfesion.setText("");
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
        if (e.getSource() == botonGuardar) {
            try {
                // Validar que los campos no estén vacíos
                if (textCod.getText().isEmpty() || textNombre.getText().isEmpty() || 
                    textTelefono.getText().isEmpty() || textEdad.getText().isEmpty() || 
                    textProfesion.getText().isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }

                // Crear instancia de PersonVo
                Person_Vo miPersona = new Person_Vo(); // Crea una nueva instancia de PersonVo
                miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
                miPersona.setNombrePersona(textNombre.getText());
                miPersona.setTelefonoPersona(textTelefono.getText());
                miPersona.setEdadPersona(Integer.parseInt(textEdad.getText()));
                miPersona.setProfesionPersona(textProfesion.getText());

                // Envía la persona al coordinador para registrarla
                miCoordinador.registrarPersona(miPersona);

                // Mensaje de éxito y limpiar campos
                JOptionPane.showMessageDialog(this, "Registro exitoso.");
                limpiar();

            } catch (NumberFormatException ex) {
                // Error en la conversión de los campos numéricos
                JOptionPane.showMessageDialog(this, "Error: El código y la edad deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                // Mensaje de error si falta un campo obligatorio
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                // Otros errores
                ex.printStackTrace(); // Muestra el error en la consola para depuración
                JOptionPane.showMessageDialog(this, "Error en el Ingreso de Datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == botonCancelar) {
            this.dispose(); // Cierra la ventana si se cancela
        }
    }
}
