package vista;

import java.util.Scanner;

public class VistaJuegoConsola implements VistaJuego {
    private Scanner scanner;

    public VistaJuegoConsola() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int obtenerEleccionJugador() {
        System.out.println("Seleccione su opcion (0: Piedra, 1: Papel, 2: Tijera):");
        return scanner.nextInt();
    }

    @Override
    public void mostrarJugadas(String jugadaHumano, String jugadaMaquina) {
        System.out.println("Jugada Humano: " + jugadaHumano);
        System.out.println("Jugada Maquina: " + jugadaMaquina);
    }

    @Override
    public void mostrarResultadoRonda(String resultado) {
        System.out.println("Resultado Ronda: " + resultado);
    }

    @Override
    public void mostrarPuntaje(int puntajeHumano, int puntajeMaquina) {
        System.out.println("Puntaje Humano: " + puntajeHumano);
        System.out.println("Puntaje Maquina: " + puntajeMaquina);
    }
    
    @Override
    public void mostrarResultadoFinal(String resultadoFinal) {
        System.out.println("Resultado Final: " + resultadoFinal);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
