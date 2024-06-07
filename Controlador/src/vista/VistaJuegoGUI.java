package vista;

import modelo.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaJuegoGUI extends JFrame implements VistaJuego {
    private JComboBox<String> comboBoxJugada;
    private JTextArea textAreaResultado;
    private JLabel labelPuntajeHumano;
    private JLabel labelPuntajeComputadora;
    private Juego juego;

    public VistaJuegoGUI(Juego juego) {
        this.juego = juego;
        setTitle("Piedra, Papel o Tijera");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para la selección de jugada
        JPanel panelJugada = new JPanel();
        comboBoxJugada = new JComboBox<>(new String[]{"Piedra", "Papel", "Tijera"});
        JButton botonJugar = new JButton("Jugar");
        botonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jugadaHumano = comboBoxJugada.getSelectedIndex();
                int jugadaComputadora = juego.generarJugadaComputadora();
                mostrarJugadas(juego.jugadaToString(jugadaHumano), juego.jugadaToString(jugadaComputadora));
                mostrarResultadoRonda(juego.determinarGanador(jugadaHumano, jugadaComputadora));
                mostrarPuntaje(juego.getPuntajeHumano(), juego.getPuntajeComputadora());
                if (juego.getPuntajeHumano() == 3 || juego.getPuntajeComputadora() == 3) {
                    mostrarResultadoFinal(juego.determinarGanadorFinal());
                }
            }
        });
        panelJugada.add(comboBoxJugada);
        panelJugada.add(botonJugar);

        // Área de texto para mostrar resultados
        textAreaResultado = new JTextArea();
        textAreaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResultado);

        // Panel para mostrar el puntaje
        JPanel panelPuntaje = new JPanel();
        panelPuntaje.setLayout(new GridLayout(2, 2));
        panelPuntaje.add(new JLabel("Puntaje Humano:"));
        labelPuntajeHumano = new JLabel("0");
        panelPuntaje.add(labelPuntajeHumano);
        panelPuntaje.add(new JLabel("Puntaje Computadora:"));
        labelPuntajeComputadora = new JLabel("0");
        panelPuntaje.add(labelPuntajeComputadora);

        add(panelJugada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelPuntaje, BorderLayout.SOUTH);
    }

    @Override
    public int obtenerEleccionJugador() {
        // No se utiliza en la GUI ya que se maneja por eventos
        return comboBoxJugada.getSelectedIndex();
    }

    @Override
    public void mostrarJugadas(String jugadaHumano, String jugadaComputadora) {
        textAreaResultado.append("Jugada Humano: " + jugadaHumano + "\n");
        textAreaResultado.append("Jugada Computadora: " + jugadaComputadora + "\n");
    }

    @Override
    public void mostrarResultadoRonda(String resultado) {
        textAreaResultado.append("Resultado Ronda: " + resultado + "\n");
    }

    @Override
    public void mostrarPuntaje(int puntajeHumano, int puntajeComputadora) {
        labelPuntajeHumano.setText(String.valueOf(puntajeHumano));
        labelPuntajeComputadora.setText(String.valueOf(puntajeComputadora));
    }

    @Override
    public void mostrarResultadoFinal(String resultadoFinal) {
        JOptionPane.showMessageDialog(this, resultadoFinal, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
