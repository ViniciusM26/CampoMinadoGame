package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import campoMinado.ModosJogo.Jogadores.Jogador;

public class TelaDerrotaGUI extends JFrame {
    private Jogador jogador;

    public TelaDerrotaGUI(Jogador jogador) {
        this.jogador = jogador; 
        initGUI();
    }

    private void initGUI() {
        setTitle("Você Perdeu!");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Você Perdeu, " + jogador.getNome() + "! Tente Novamente.");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        JButton voltarButton = new JButton("Fechar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
                MenuGUI menuGUI = new MenuGUI();
            }
        });
        add(voltarButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        Jogador jogador = new Jogador("Exemplo"); // Criando um jogador de exemplo
        new TelaDerrotaGUI(jogador);
    }
}
