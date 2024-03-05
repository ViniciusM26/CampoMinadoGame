package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import campoMinado.ModosJogo.Jogadores.Jogador;

public class TelaVitoriaGUI extends JFrame {
    private Jogador jogador;

    public TelaVitoriaGUI(Jogador jogador) {
        this.jogador = jogador; 
        initGUI();
    }

    private void initGUI() {
        setTitle("Vitoria");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Você ganhou, " + jogador.getNome() + "! Parabéns!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        JButton voltarButton = new JButton("Fechar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
                MenuGUI menuGUI = new MenuGUI();
                menuGUI.initGUI();
            }
        });
        add(voltarButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        Jogador jogador = new Jogador("Exemplo"); // Criando um jogador de exemplo
        new TelaVitoriaGUI(jogador);
    }
}
