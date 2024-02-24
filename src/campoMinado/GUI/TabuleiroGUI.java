package campoMinado.GUI;

import javax.swing.*;

import campoMinado.Celulas.Celula;
import campoMinado.Celulas.CelulaSimples.CelulaVizinha;
import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.Jogadores.Jogador;
import campoMinado.ModosJogo.Jogadores.JogadorSingle;
import campoMinado.Tabuleiros.Tabuleiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabuleiroGUI {

    private static Jogo jogo;
    private static JogadorSingle jogador;
    private static JButton[][] buttons;
    private static final int SIZE = 8;
    private static final Color GREEN = Color.GREEN;
    private static final Color WHITE = Color.WHITE;
    private static final Color BLACK = Color.BLACK;
    private static JLabel bandeirasLabel;
    private static JLabel pontuacaoLabel;

    public static void initGUI() {
        buttons = new JButton[SIZE][SIZE];
        int bombas = 5;

        jogo = new Jogo(new Tabuleiro(8, 5));
        jogador = new JogadorSingle("Bruno");

        JFrame frame = new JFrame("Campo Minado");
        JPanel panel = new JPanel(new BorderLayout());

        JPanel gamePanel = new JPanel(new GridLayout(8, 8)); // Grid para o campo minado

        for (int i = 0; i < jogo.getTabuleiro().getTamanho(); i++) {
            for (int j = 0; j < jogo.getTabuleiro().getTamanho(); j++) {
                buttons[i][j] = new JButton();
                int row = i; // Calcula a linha do botão
                int col = j; // Calcula a coluna do botão

                //botão esquerdo na celula
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jogo.jogar(jogador,row, col);
                        System.out.println("oi");
                        clicarCelula(row, col);
                        atualizarBotoes(buttons);
                        System.out.println(jogo.getTabuleiro());
                        atualizarPontuacao(jogador);
                        System.out.println(jogador.getPontos());
                    }
                });
                //botão direto na celula
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) { // Verifica se foi um clique com o botão direito
                            JButton buttonClicked = (JButton) e.getSource(); // Obtém o botão clicado
                            if (buttonClicked.isEnabled()) {
                                if(decrementarBandeiras()){
                                buttonClicked.setEnabled(false);
                                buttonClicked.setBackground(BLACK);
                            }
                            } else {
                                buttonClicked.setEnabled(true);
                                buttonClicked.setBackground(null);
                                incrementarBandeiras();
                            }
                        }
                    }
                });
                gamePanel.add(buttons[i][j]);
            }
        }

        // Placar
        JPanel placarPanel = new JPanel(new GridLayout(1, 2));

        bandeirasLabel = new JLabel("Bandeiras restantes: " + bombas);
        placarPanel.add(bandeirasLabel);

        pontuacaoLabel = new JLabel("Pontuação: 0");
        placarPanel.add(pontuacaoLabel);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuGUI menuGUI = new MenuGUI();
                menuGUI.initGUI();
            }
        });

        panel.add(gamePanel, BorderLayout.CENTER);
        panel.add(placarPanel, BorderLayout.SOUTH);
        panel.add(voltarButton, BorderLayout.NORTH);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centralizar na tela
        frame.setVisible(true);
    }

    private static void clicarCelula(int row, int col) {
        buttons[row][col].setBackground(Color.GREEN); // Muda a cor do botão clicado
        buttons[row][col].setEnabled(false);// desabilira o click
        /*
        // Coordenadas dos botões adjacentes
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] offset : offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            if (isValid(newRow, newCol) && buttons[newRow][newCol].getBackground() != GREEN) {
                buttons[newRow][newCol].setBackground(GREEN);
                buttons[newRow][newCol].setEnabled(false);
            }
        }
        */
    }
    private static boolean decrementarBandeiras() {
        int bandeiras = Integer.parseInt(bandeirasLabel.getText().split(": ")[1]);
        if(bandeiras != 0){
            bandeiras--;
            bandeirasLabel.setText("Bandeiras restantes: " + bandeiras);
            return(true);
        }
        else return(false);
    }
    
    private static void incrementarBandeiras() {
        int bandeiras = Integer.parseInt(bandeirasLabel.getText().split(": ")[1]);
        bandeiras++;
        bandeirasLabel.setText("Bandeiras restantes: " + bandeiras);
    }

    private static void atualizarPontuacao(Jogador jogador) {
        pontuacaoLabel.setText("Pontuação: " + jogador.getPontos());
    }

    private static void atualizarBotoes(JButton buttons[][]) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                Celula celula = jogo.getTabuleiro().getMatriz()[x][y];
                System.out.println("oi");
                // caso a celula seja modificada
                if (!(celula.getCelulaSimples() == null || (celula.getCelulaSimples().getClicado() == false))) {
                    if (celula.getCelulaSimples().getSimbolo() == '@') {
                        clicarCelula(x ,y);
                    } else if (celula.getCelulaSimples().getSimbolo() == '°') {
                        buttons[x][y].setText("°");
                    } else {
                        char c = celula.getCelulaSimples().getSimbolo();
                        buttons[x][y].setText(c + "");
                        clicarCelula(x, y);
                    }
                }
                buttons[x][y].repaint();

            }
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabuleiroGUI::initGUI);
        Jogo jogo = new Jogo(null);
    }
}