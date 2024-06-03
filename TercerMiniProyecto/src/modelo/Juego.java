package modelo;

import java.util.Scanner;

public class Juego {
    public static final int PIEDRA = 0;
    public static final int PAPEL = 1;
    public static final int TIJERA = 2;

    private int puntajeHumano;
    private int puntajeComputadora;

    public Juego() {
        puntajeHumano = 0;
        puntajeComputadora = 0;
    }

    public int generarJugadaComputadora() {
        return (int) (Math.random() * 3);
    }

    public String determinarGanador(int jugadaHumano, int jugadaComputadora) {
        if (jugadaHumano == jugadaComputadora) {
            return "Empate";
        } else if ((jugadaHumano == PIEDRA && jugadaComputadora == TIJERA) ||
                   (jugadaHumano == PAPEL && jugadaComputadora == PIEDRA) ||
                   (jugadaHumano == TIJERA && jugadaComputadora == PAPEL)) {
            puntajeHumano++;
            return "Gana Humano (Usted)";
        } else {
            puntajeComputadora++;
            return "Gana Computadora";
        }
    }

    public String determinarGanadorFinal() {
        if (puntajeHumano == 3) {
            return "Humano (usted) gana la serie al llegar a tres puntos";
        } else if (puntajeComputadora == 3) {
            return "La computadora gana la serie al llegar a tres puntos";
        } else {
            return "La serie sigue";
        }
    }

    public String jugadaToString(int jugada) {
        switch (jugada) {
            case PIEDRA:
                return "Piedra";
            case PAPEL:
                return "Papel";
            case TIJERA:
                return "Tijera";
            default:
                return "Desconocido";
        }
    }

    public int getPuntajeHumano() {
        return puntajeHumano;
    }

    public int getPuntajeComputadora() {
        return puntajeComputadora;
    }

 // para probar el funcionamieto
    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);

        while (juego.getPuntajeHumano() < 3 && juego.getPuntajeComputadora() < 3) {
            System.out.println("Elige tu jugada (0: Piedra, 1: Papel, 2: Tijera):");
            int jugadaHumano = scanner.nextInt();

            if (jugadaHumano < 0 || jugadaHumano > 2) {
                System.out.println("Jugada inválida. Elige 0, 1 o 2");
                continue;
            }

            int jugadaComputadora = juego.generarJugadaComputadora();

            System.out.println("Jugada Humano: " + juego.jugadaToString(jugadaHumano));
            System.out.println("Jugada Computadora: " + juego.jugadaToString(jugadaComputadora));
            System.out.println("Resultado Ronda: " + juego.determinarGanador(jugadaHumano, jugadaComputadora));
            System.out.println("Puntaje Humano: " + juego.getPuntajeHumano());
            System.out.println("Puntaje Computadora: " + juego.getPuntajeComputadora());
        }

        System.out.println("Resultado Final: " + juego.determinarGanadorFinal());

        scanner.close();
    }
}
