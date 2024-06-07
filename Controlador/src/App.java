import modelo.Juego;
import vista.VistaJuegoConsola;
import vista.VistaJuegoGUI;
import controlador.ControladorJuego;

public class App {
    public static void main(String[] args) throws Exception {
        Juego modelo = new Juego();
        
        // Puedes cambiar entre VistaJuegoConsola y VistaJuegoGUI comentando/descomentando estas líneas
        VistaJuegoConsola vistaConsola = new VistaJuegoConsola();
         VistaJuegoGUI vistaGUI = new VistaJuegoGUI(modelo);

         //Controlador para la vista de consola
        ControladorJuego controladorConsola = new ControladorJuego(modelo, vistaConsola);

        //Controlador para la vista GUI
        //ControladorJuego controladorGUI = new ControladorJuego(modelo, vistaGUI);
        //vistaGUI.setVisible(true);
    }
}
