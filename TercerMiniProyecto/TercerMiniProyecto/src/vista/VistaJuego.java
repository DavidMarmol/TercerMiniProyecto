package vista;

public interface VistaJuego {
    int obtenerEleccionJugador();
    void mostrarJugadas(String jugadaHumano, String jugadaMaquina);
    void mostrarResultadoRonda(String resultado);
    void mostrarPuntaje(int puntajeHumano, int puntajeComputadora);
    void mostrarResultadoFinal(String resultadoFinal);
    void mostrarMensaje(String mensaje);
}
