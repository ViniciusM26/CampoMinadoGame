package campoMinado.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuGUI {
    public static void initGUI() {
        JFrame frame = new JFrame("Minha GUI");

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1));
        menuPanel.setSize(400, 400);

        JButton jogarButton = new JButton("Jogar");
        JButton creditosButton = new JButton("Créditos");
        JButton sairButton = new JButton("Sair");

        Font buttonFont = new Font(jogarButton.getFont().getName(), Font.PLAIN, 20); 
        jogarButton.setFont(buttonFont);
        creditosButton.setFont(buttonFont);
        sairButton.setFont(buttonFont);

        jogarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                EscolhaModoJogoGUI escolhaModoJogoGUI = new EscolhaModoJogoGUI();
                escolhaModoJogoGUI.initGUI();
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

        JButton historicoButton = new JButton("Histórico");
        historicoButton.setFont(buttonFont);
        historicoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame historicoFrame = new JFrame("Histórico");
                JPanel historicoPanel = new JPanel();
                historicoPanel.setPreferredSize(new Dimension(200, 400)); // Largura reduzida pela metade
                // Aqui você pode preencher o painel do histórico com os dados necessários
                JLabel historicoLabel = new JLabel("Histórico de Jogadas");
                historicoPanel.add(historicoLabel);
                historicoFrame.add(historicoPanel);

                // Obtenha a localização e a altura do JFrame existente
                Point location = frame.getLocationOnScreen();
                int height = frame.getHeight();

                // Defina a posição x e y do novo JFrame ao lado do JFrame existente
                int newX = location.x + frame.getWidth();
                int newY = location.y;

                // Defina a posição do novo JFrame e exiba-o
                historicoFrame.setLocation(newX, newY);
                historicoFrame.pack();
                historicoFrame.setVisible(true);
            }
        });

        menuPanel.add(jogarButton);
        menuPanel.add(creditosButton);
        menuPanel.add(sairButton);
        menuPanel.add(historicoButton);

        frame.add(menuPanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        initGUI();
    }
}
