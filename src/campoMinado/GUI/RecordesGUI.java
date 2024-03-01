package campoMinado.GUI;

import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        JPanel historicoPanel = new JPanel();
        historicoPanel.setPreferredSize(new Dimension(200, 400)); // Largura reduzida pela metade
        // Aqui você pode preencher o painel do histórico com os dados necessários

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

        // Adicionando apenas os primeiros cinco registros ao painel
        JLabel historicoLabel = new JLabel("Histórico de Jogadas");
        historicoPanel.add(historicoLabel);
        for (int i = 0; i < Math.min(5, rankings.size()); i++) {
            JLabel rankingLabel = new JLabel(rankings.get(i));
            historicoPanel.add(rankingLabel);
        }

        historicoFrame.add(historicoPanel);

        // Defina a posição do novo JFrame e exiba-o
        historicoFrame.setLocation(newX, newY);
        historicoFrame.pack();
        historicoFrame.setVisible(true);
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
}
