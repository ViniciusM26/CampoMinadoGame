package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditosGUI {
    public static void initGUI() {
        JFrame frame = new JFrame("Créditos");
        JPanel panel = new JPanel(new BorderLayout());

        JLabel tituloLabel = new JLabel("Desenvolvido por:");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextArea nomesArea = new JTextArea();
        nomesArea.setText("Bruno César\nVinicius Moura");
        nomesArea.setFont(new Font("Arial", Font.PLAIN, 16));
        nomesArea.setEditable(false);
        nomesArea.setOpaque(false);
        nomesArea.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        nomesArea.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel infoLabel = new JLabel("Jogo de Campo Minado");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                MenuGUI menuGUI = new MenuGUI();
                menuGUI.initGUI();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(voltarButton);

        panel.add(tituloLabel, BorderLayout.NORTH);
        panel.add(nomesArea, BorderLayout.CENTER);
        panel.add(infoLabel, BorderLayout.SOUTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Para centralizar na tela
        frame.setCursor(Cursor.getDefaultCursor()); // Desabilita o cursor
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreditosGUI::initGUI);
    }
}
