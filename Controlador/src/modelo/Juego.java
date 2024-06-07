package modelo;

import java.util.Scanner;

public class Juego {
    public static final int PIEDRA = 0;
    public static final int PAPEL = 1;
    public static final int TIJERA = 2;

    private int puntajeHumano;
    private int puntajeMaquina;

    public Juego() {
        puntajeHumano = 0;
        puntajeMaquina = 0;
    }

    public int generarJugadaMaquina() {
        return (int) (Math.random() * 3);
    }

    public String determinarGanador(int jugadaHumano, int jugadaMaquina) {
        if (jugadaHumano == jugadaMaquina) {
            return "Empate";
        } else if ((jugadaHumano == PIEDRA && jugadaMaquina == TIJERA) ||
                   (jugadaHumano == PAPEL && jugadaMaquina == PIEDRA) ||
                   (jugadaHumano == TIJERA && jugadaMaquina == PAPEL)) {
            puntajeHumano++;
            return "Gana Humano (Usted)";
        } else {
            puntajeMaquina++;
            return "Gana Maquina";
        }
    }

    public String determinarGanadorFinal() {
        if (puntajeHumano == 3) {
            return "Humano (usted) gana la serie al llegar a tres puntos";
        } else if (puntajeMaquina == 3) {
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

    public int getPuntajeMaquina() {
        return puntajeMaquina;
    }

 // para probar el funcionamieto
    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);

        while (juego.getPuntajeHumano() < 3 && juego.getPuntajeMaquina() < 3) {
            System.out.println("Elige tu jugada (0: Piedra, 1: Papel, 2: Tijera):");
            int jugadaHumano = scanner.nextInt();

            if (jugadaHumano < 0 || jugadaHumano > 2) {
                System.out.println("Jugada inválida. Elige 0, 1 o 2");
                continue;
            }

            int jugadaMaquina = juego.generarJugadaMaquina();

            System.out.println("Jugada Humano: " + juego.jugadaToString(jugadaHumano));
            System.out.println("Jugada Maquina: " + juego.jugadaToString(jugadaMaquina));
            System.out.println("Resultado Ronda: " + juego.determinarGanador(jugadaHumano, jugadaMaquina));
            System.out.println("Puntaje Humano: " + juego.getPuntajeHumano());
            System.out.println("Puntaje Maquina: " + juego.getPuntajeMaquina());
        }

        System.out.println("Resultado Final: " + juego.determinarGanadorFinal());

        scanner.close();
    }
}
