package controlador;

import modelo.Juego;
import vista.VistaJuego;

public class ControladorJuego {
    private Juego modelo;
    private VistaJuego vista;

    public ControladorJuego(Juego modelo, VistaJuego vista) {
        this.modelo = modelo;
        this.vista = vista;
        iniciarJuego();
    }

    public void iniciarJuego() {
        while (modelo.getPuntajeHumano() < 3 && modelo.getPuntajeMaquina() < 3) {
            int jugadaHumano = vista.obtenerEleccionJugador();
            if (jugadaHumano < 0 || jugadaHumano > 2) {
                vista.mostrarMensaje("Jugada inválida. Elige 0, 1 o 2");
                continue;
            }
            int jugadaMaquina = modelo.generarJugadaMaquina();

            vista.mostrarJugadas(modelo.jugadaToString(jugadaHumano), modelo.jugadaToString(jugadaMaquina));
            vista.mostrarResultadoRonda(modelo.determinarGanador(jugadaHumano, jugadaMaquina));
            vista.mostrarPuntaje(modelo.getPuntajeHumano(), modelo.getPuntajeMaquina());

            if (modelo.getPuntajeHumano() == 3 || modelo.getPuntajeMaquina() == 3) {
                vista.mostrarResultadoFinal(modelo.determinarGanadorFinal());
            }
        }
    }
}
