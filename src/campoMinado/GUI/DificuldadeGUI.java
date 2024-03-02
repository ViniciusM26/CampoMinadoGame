package campoMinado.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import campoMinado.ModosJogo.Jogo;
import campoMinado.Tabuleiros.Tabuleiro;
import campoMinado.Tabuleiros.TabuleiroMaluco;

public class DificuldadeGUI {
    private static RecordesGUI recordesGUI;
    private static boolean modoJogo;

    public DificuldadeGUI(boolean modoJogo) {
        DificuldadeGUI.modoJogo = modoJogo;
    }

    public static void initGUI() {
        JFrame frame = new JFrame("Escolha a Dificuldade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font buttonFont = new Font("Arial", Font.BOLD, 18);

        JButton easyButton = createStyledButton("Fácil", buttonFont);
        JButton mediumButton = createStyledButton("Médio", buttonFont);
        JButton difficultButton = createStyledButton("Difícil", buttonFont);
        JButton backButton = createStyledButton("Voltar", buttonFont);

        easyButton.addActionListener(e -> {
            frame.dispose();
            Jogo jogo = criarJogo(modoJogo, 1);
            SelecaoModoJogador selecaoModoJogador = new SelecaoModoJogador(jogo);
            selecaoModoJogador.initGUI();
        });

        mediumButton.addActionListener(e -> {
            frame.dispose();
            Jogo jogo = criarJogo(modoJogo, 2);
            SelecaoModoJogador selecaoModoJogador = new SelecaoModoJogador(jogo);
            selecaoModoJogador.initGUI();
        });

        difficultButton.addActionListener(e -> {
            frame.dispose();
            Jogo jogo = criarJogo(modoJogo, 3);
            SelecaoModoJogador selecaoModoJogador = new SelecaoModoJogador(jogo);
            selecaoModoJogador.initGUI();
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            MenuGUI.initGUI();
        });

        menuPanel.add(easyButton);
        menuPanel.add(mediumButton);
        menuPanel.add(difficultButton);
        menuPanel.add(backButton);

        frame.add(menuPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JButton createStyledButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(new Color(130, 180, 220)); // Azul claro
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));

        // Altera o cursor ao passar o mouse sobre o botão
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Efeito de cor ao passar o mouse sobre o botão
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(100, 150, 200)); // Azul mais escuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(130, 180, 220)); // Retorna à cor original
            }
        });

        return button;
    }

    private static Jogo criarJogo(boolean modoJogo, int dificuldade) {
        Jogo jogo;
        if (modoJogo) {
            jogo = new Jogo(new TabuleiroMaluco(dificuldade));
        } else {
            jogo = new Jogo(new Tabuleiro(dificuldade));
        }
        return jogo;
    }
}
