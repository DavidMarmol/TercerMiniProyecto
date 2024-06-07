import modelo.Juego;
import vista.VistaJuegoConsola;
import vista.VistaJuegoGUI;
import controlador.ControladorJuego;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Juego modelo = new Juego();

        String[] opciones = {"Consola", "GUI"};
        int eleccion = JOptionPane.showOptionDialog(null, "Seleccione la interfaz", "Piedra, Papel o Tijera",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                if (eleccion == 0) {
                    VistaJuegoConsola vistaConsola = new VistaJuegoConsola();
                    new ControladorJuego(modelo, vistaConsola);
                } else if (eleccion == 1) {
                    VistaJuegoGUI vistaGUI = new VistaJuegoGUI(modelo);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            vistaGUI.setVisible(true);
                        }
                    });
                    new ControladorJuego(modelo, vistaGUI);
                }
            }
        }
        
