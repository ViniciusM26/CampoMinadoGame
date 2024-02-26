package campoMinado.GUI;

import javax.swing.*;

import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.Jogadores.Jogador;
import campoMinado.ModosJogo.Jogadores.JogadorSingle;
import campoMinado.Tabuleiros.Tabuleiro;
import campoMinado.Tabuleiros.TabuleiroDificil;
import campoMinado.Tabuleiros.TabuleiroFacil;
import campoMinado.Tabuleiros.TabuleiroMedio;

import java.awt.*;
import java.awt.event.*;

public class EscolhaModoJogoGUI {
    public static void initGUI() {
        JFrame frame = new JFrame("Minha GUI");

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 1)); // Reduzindo para 3 para os botões principais
        panel.setSize(600, 600);

        JButton malucoButton = new JButton("Maluco");
        JButton normalButton = new JButton("Normal");

        Font buttonFont = new Font(malucoButton.getFont().getName(), Font.PLAIN, 20);
        malucoButton.setFont(buttonFont);
        normalButton.setFont(buttonFont);

        malucoButton.addActionListener(new ActionListener() { //escolha do modo maluco
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DificuldadeGUI dificuldadeGUI = new DificuldadeGUI(true);
                DificuldadeGUI.initGUI();
            }
        });

        normalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DificuldadeGUI dificuldadeGUI = new DificuldadeGUI(false);
                dificuldadeGUI.initGUI();
            }
        });

        panel.add(normalButton);
        panel.add(malucoButton);

        JPanel bottomPanel = new JPanel(); // Novo painel para o botão "Voltar"
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centralizando o botão "Voltar"
        
        JButton voltarButton = new JButton("Voltar"); // Novo botão de voltar
        voltarButton.setPreferredSize(new Dimension(100, 50)); // Definindo tamanho menor para o botão "Voltar"
        voltarButton.setFont(new Font(voltarButton.getFont().getName(), Font.PLAIN, 15)); // Ajustando o tamanho da fonte
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
                MenuGUI menuGUI = new MenuGUI();
                menuGUI.initGUI();
            }
        });

        bottomPanel.add(voltarButton); // Adiciona o botão "Voltar" ao painel inferior

        frame.add(panel, BorderLayout.CENTER); // Adiciona o painel principal ao centro
        frame.add(bottomPanel, BorderLayout.SOUTH); // Adiciona o painel inferior na parte inferior
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        initGUI();
    }
}
