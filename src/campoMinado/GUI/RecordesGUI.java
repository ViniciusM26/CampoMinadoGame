package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecordesGUI {
    private JFrame historicoFrame;
    private Point location;
    private int height;
    private int newX;
    private int newY;

    public RecordesGUI(JFrame frame) {
        // Obtem a localização e a altura do JFrame
        this.location = frame.getLocationOnScreen();
        this.height = frame.getHeight();

        // Define a posição x e y do novo JFrame ao lado do JFrame existente
        this.newX = location.x + frame.getWidth();
        this.newY = location.y;
        initGUI();
    }

    private void initGUI() {
        historicoFrame = new JFrame("Histórico");
        historicoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historicoFrame.setLayout(new BorderLayout());
        historicoFrame.setLocation(newX, newY);

        JPanel historicoPanel = new JPanel();
        historicoPanel.setBackground(new Color(130, 180, 220)); // Mesma paleta de cores do MenuGUI
        historicoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        historicoPanel.setLayout(new BoxLayout(historicoPanel, BoxLayout.Y_AXIS));

        JLabel historicoLabel = new JLabel("Histórico de Jogadas:");
        historicoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        historicoLabel.setForeground(Color.WHITE);
        historicoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        historicoPanel.add(historicoLabel);

        // Lendo e ordenando os dados do arquivo
        List<String> rankings = readRankingsFromFile("ranking.txt");
        Collections.sort(rankings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Comparando os rankings para ordenar de maior para menor
                int rank1 = Integer.parseInt(o1.split("- Pontuação:")[1].trim());
                int rank2 = Integer.parseInt(o2.split("- Pontuação:")[1].trim());
                return Integer.compare(rank2, rank1);
            }
        });

        // Adicionando registros ao painel
        for (String ranking : rankings) {
            JLabel rankingLabel = new JLabel(ranking);
            rankingLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            rankingLabel.setForeground(Color.WHITE);
            rankingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            historicoPanel.add(rankingLabel);
        }

        JScrollPane scrollPane = new JScrollPane(historicoPanel);
        historicoFrame.add(scrollPane, BorderLayout.CENTER);

        // Botão de fechar
        JButton fecharButton = createStyledButton("Fechar", new Font("Arial", Font.BOLD, 18));
        fecharButton.addActionListener(e -> historicoFrame.dispose());
        fecharButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        historicoFrame.add(fecharButton, BorderLayout.SOUTH);

        historicoFrame.pack();
        historicoFrame.setVisible(true);
    }

    private JButton createStyledButton(String text, Font font) {
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

    public void closeFrame() {
        historicoFrame.dispose();
    }

    private List<String> readRankingsFromFile(String fileName) {
        List<String> rankings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                rankings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rankings;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame dummyFrame = new JFrame(); // Cria um frame temporário para passar para o RecordesGUI
            dummyFrame.setVisible(true); // Torna o frame temporário visível para que suas dimensões sejam calculadas corretamente
            RecordesGUI recordesGUI = new RecordesGUI(dummyFrame);
            recordesGUI.initGUI();
        });
    }
}
