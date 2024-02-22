package campoMinado.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuGUI {
    public static void initGUI() {
        JFrame frame = new JFrame("Minha GUI");

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 1));
        panel.setSize(400, 400);

        JButton jogarButton = new JButton("Jogar");
        JButton creditosButton = new JButton("Créditos");
        JButton sairButton = new JButton("Sair");

        Font buttonFont = new Font(jogarButton.getFont().getName(), Font.PLAIN, 20); // Definindo uma nova fonte com tamanho 20
        jogarButton.setFont(buttonFont);
        creditosButton.setFont(buttonFont);
        sairButton.setFont(buttonFont);

        jogarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                TabuleiroGUI tabuleiro = new TabuleiroGUI();
                tabuleiro.initGUI();
            }
        });

        creditosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CreditosGUI creditosGUI = new CreditosGUI();
                creditosGUI.initGUI();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", "Confirmar saída", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        panel.add(jogarButton);
        panel.add(creditosButton);
        panel.add(sairButton);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        initGUI();
    }
}
