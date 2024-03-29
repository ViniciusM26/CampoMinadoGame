package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EscolhaModoJogoGUI {
	public EscolhaModoJogoGUI() {
		initGUI();
	}
    private static void initGUI() {
        JFrame frame = new JFrame("Escolha o Modo de Jogo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font buttonFont = new Font("Arial", Font.BOLD, 18);

        JButton malucoButton = createStyledButton("Modo Maluco", buttonFont);
        JButton normalButton = createStyledButton("Modo Normal", buttonFont);
        JButton voltarButton = createStyledButton("Voltar", buttonFont);

        malucoButton.addActionListener(e -> {
            frame.dispose();
            DificuldadeGUI dificuldadeGUI = new DificuldadeGUI(true);
        });

        normalButton.addActionListener(e -> {
            frame.dispose();
            DificuldadeGUI dificuldadeGUI = new DificuldadeGUI(false);
        });

        voltarButton.addActionListener(e -> {
            frame.dispose();
            MenuGUI menuGUI = new MenuGUI();
        });

        menuPanel.add(normalButton);
        menuPanel.add(malucoButton);
        menuPanel.add(voltarButton);

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
