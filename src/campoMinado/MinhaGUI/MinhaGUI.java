package campoMinado.MinhaGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinhaGUI {
    public static void initGUI() {
        JFrame frame = new JFrame("Minha GUI");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton jogarButton = new JButton("Jogar");
        JButton creditosButton = new JButton("Créditos");
        JButton sairButton = new JButton("Sair");

        jogarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Iniciar o jogo...");
            }
        });

        creditosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Desenvolvido por [seu nome].");
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
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        initGUI();
    }
}
