package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuGUI {

    private static RecordesGUI recordesGUI;

    public static void initGUI() {
        JFrame frame = new JFrame("Campo Minado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font buttonFont = new Font("Arial", Font.BOLD, 18);

        JButton jogarButton = createStyledButton("Jogar", buttonFont);
        JButton creditosButton = createStyledButton("Créditos", buttonFont);
        JButton sairButton = createStyledButton("Sair", buttonFont);
        JButton historicoButton = createStyledButton("Histórico", buttonFont);

        jogarButton.addActionListener(e -> {
            frame.dispose();
            fecharHistorico();
            EscolhaModoJogoGUI escolhaModoJogoGUI = new EscolhaModoJogoGUI();
            escolhaModoJogoGUI.initGUI();
        });

        creditosButton.addActionListener(e -> {
            frame.dispose();
            fecharHistorico();
            CreditosGUI creditosGUI = new CreditosGUI();
            creditosGUI.initGUI();
        });

        sairButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", "Confirmar saída", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                fecharHistorico();
                System.exit(0);
            }
        });

        historicoButton.addActionListener(e -> {
            if (fecharHistorico()) {
                recordesGUI = new RecordesGUI(frame);
            }
        });

        menuPanel.add(jogarButton);
        menuPanel.add(creditosButton);
        menuPanel.add(historicoButton);
        menuPanel.add(sairButton);

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

    private static boolean fecharHistorico() {
        if (recordesGUI != null) {
            recordesGUI.closeFrame();
            recordesGUI = null;
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuGUI::initGUI);
    }
}
