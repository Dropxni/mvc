package controllers;

import models.Logic;
import views.MainWindow;
import views.WindowRegistration;
import views.WindowSearch;

public class Main {

    public static void main(String[] args) {
        // Inicializa las vistas
        MainWindow ventanaPrincipal = new MainWindow();
        WindowRegistration ventanaRegistro = new WindowRegistration();
        WindowSearch ventanaBuscar = new WindowSearch();

        // Inicializa el Coordinador
        Coordinator miCoordinador = new Coordinator();

        // Inicializa la lógica
        Logic miLogica = new Logic();

        // Conecta la lógica con el Coordinador
        miCoordinador.setMiLogica(miLogica);

        // Conecta las vistas con el Coordinador
        miCoordinador.setMiVentanaPrincipal(ventanaPrincipal);
        miCoordinador.setMiVentanaRegistro(ventanaRegistro);
        miCoordinador.setMiVentanaBuscar(ventanaBuscar);

        // Establece el Coordinador en las ventanas
        ventanaPrincipal.setCoordinator(miCoordinador);
        ventanaRegistro.setCoordinator(miCoordinador);
        ventanaBuscar.setCoordinator(miCoordinador);

        // Muestra la ventana principal
        miCoordinador.mostrarVentanaPrincipal();
    }
}
