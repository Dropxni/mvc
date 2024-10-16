package controllers;

import models.Person_Vo;
import models.Logic;
import views.MainWindow;
import views.WindowRegistration;
import views.WindowSearch;

public class Coordinator {

    private MainWindow miVentanaPrincipal;
    private WindowRegistration miVentanaRegistro;
    private WindowSearch miVentanaBuscar;
    private Logic miLogica;

    // Método para establecer la lógica
    public void setMiLogica(Logic miLogica) {
        this.miLogica = miLogica;
    }

    // Método para establecer la ventana principal
    public void setMiVentanaPrincipal(MainWindow miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    // Método para establecer la ventana de registro
    public void setMiVentanaRegistro(WindowRegistration miVentanaRegistro) {
        this.miVentanaRegistro = miVentanaRegistro;
    }

    // Método para establecer la ventana de búsqueda
    public void setMiVentanaBuscar(WindowSearch miVentanaBuscar) {
        this.miVentanaBuscar = miVentanaBuscar;
    }

    // Método para mostrar la ventana principal
    public void mostrarVentanaPrincipal() {
        miVentanaPrincipal.setVisible(true);
    }

    // Método para mostrar la ventana de registro
    public void mostrarVentanaRegistro() {
        miVentanaPrincipal.setVisible(false); // Oculta la ventana principal
        miVentanaRegistro.setVisible(true);   // Muestra la ventana de registro
    }

    // Método para mostrar la ventana de búsqueda
    public void mostrarVentanaBuscar() {
        miVentanaPrincipal.setVisible(false); // Oculta la ventana principal
        miVentanaBuscar.setVisible(true);     // Muestra la ventana de búsqueda
    }

    // Método para registrar una persona
    public void registrarPersona(Person_Vo persona) {
        String mensaje = miLogica.validarRegistro(persona);
        mostrarMensaje(mensaje);
    }

    // Método para modificar una persona
    public void modificarPersona(Person_Vo persona) {
        String mensaje = miLogica.validarModificacion(persona);
        mostrarMensaje(mensaje);
    }

    // Método para buscar una persona por su ID
    public Person_Vo buscarPersona(String id) {
        Person_Vo persona = miLogica.validarConsulta(id);
        if (persona == null) {
            mostrarMensaje("No se encontró la persona.");
        }
        return persona;
    }

    // Método para eliminar una persona por su ID
    public void eliminarPersona(String id) {
        String mensaje = miLogica.validarEliminacion(id);
        mostrarMensaje(mensaje);
    }

    // Método para mostrar mensajes
    public void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(null, mensaje);
    }
}
