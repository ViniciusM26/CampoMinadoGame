package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditosGUI {
	public CreditosGUI() {
		initGUI();
	}
    private static void initGUI() {
        JFrame frame = new JFrame("Créditos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(130, 180, 220)); // Mesma paleta de cores do MenuGUI

        JLabel tituloLabel = new JLabel("Desenvolvido por:");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0)); // Espaçamento

        JTextArea nomesArea = new JTextArea();
        nomesArea.setText("\n\nBruno César Protasio de Lima Filho\nVinícius Moura de Oliveira\n\nE-mails para contato:"
        		+ "\nbcplf@poli.br\nvmo1@poli.br\n\nEsse projeto foi desenvolvido como forma de estudo da disciplina de LPOO.");
        nomesArea.setFont(new Font("Arial", Font.PLAIN, 18));
        nomesArea.setEditable(false);
        nomesArea.setOpaque(false);
        nomesArea.setForeground(Color.WHITE);
        nomesArea.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        nomesArea.setLineWrap(true);
        nomesArea.setWrapStyleWord(true);

        JLabel infoLabel = new JLabel("Jogo de Campo Minado");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // Espaçamento

        JButton voltarButton = createStyledButton("Voltar", new Font("Arial", Font.BOLD, 18));

        voltarButton.addActionListener(e -> {
            frame.dispose();
            MenuGUI menuGUI = new MenuGUI();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false); // Para que o fundo da paleta de cores seja visível
        buttonPanel.add(voltarButton);

        panel.add(tituloLabel, BorderLayout.NORTH);
        panel.add(nomesArea, BorderLayout.CENTER);
        panel.add(infoLabel, BorderLayout.SOUTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JButton createStyledButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(new Color(130, 180, 220)); // Mesma paleta de cores do MenuGUI
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100))); // Mesma borda do MenuGUI

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreditosGUI::initGUI);
    }
}
