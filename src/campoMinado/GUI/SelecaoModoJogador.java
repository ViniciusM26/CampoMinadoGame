package campoMinado.GUI;

import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.Jogadores.JogadorMultiplayer;
import campoMinado.ModosJogo.Jogadores.JogadorSingle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelecaoModoJogador {
    private static RecordesGUI recordesGUI;
    private static Jogo jogo;

    public SelecaoModoJogador(Jogo jogo) {
        SelecaoModoJogador.jogo = jogo;
        initGUI();
    }

    private static void initGUI() {
        JFrame frame = new JFrame("Seleção do Modo de Jogador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
    
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
    
        JButton singleButton = createStyledButton("Singleplayer", buttonFont);
        JButton multiButton = createStyledButton("Multiplayer", buttonFont);
        JButton backButton = createStyledButton("Voltar", buttonFont);
    
        singleButton.addActionListener(new ActionListener() { // escolha do modo single
            public void actionPerformed(ActionEvent e) {
                frame.dispose();// fecha tela 
                //abre GUI para escolher o nome dos jogadores
                SelecaoNomeJogador selecaoNomeJogador = new SelecaoNomeJogador(jogo);
            }
        });
    
        multiButton.addActionListener(new ActionListener() { // escolha do modo multiplayer
            public void actionPerformed(ActionEvent e) {
                frame.dispose();// fecha tela 
                //abre GUI para escolher o nome dos jogadores
                SelecaoNomesJogadores selecaoNomesJogadores = new SelecaoNomesJogadores(jogo);
            }
        });
    
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuGUI menuGUI = new MenuGUI();
            }
        });
    
        menuPanel.add(singleButton);
        menuPanel.add(multiButton);
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
}
