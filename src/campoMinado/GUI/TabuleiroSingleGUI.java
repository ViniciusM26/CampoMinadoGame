package campoMinado.GUI;

import campoMinado.Celulas.Celula;
import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.Jogadores.Historico;
import campoMinado.ModosJogo.Jogadores.Jogador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabuleiroSingleGUI {

    private Jogo jogo;
    private Jogador jogador;
    private JButton[][] buttons;
    private JLabel bandeirasLabel;
    private JLabel pontuacaoLabel;

    public TabuleiroSingleGUI(Jogo jogo,Jogador jogador){
        this.jogo = jogo;
        this.jogador = jogador;
        initGUI();
    }

    private void initGUI() {

        int size = jogo.getTabuleiro().getTamanho();
        
        buttons = new JButton[size][size];

        JFrame frame = new JFrame("Campo Minado");
        JPanel panel = new JPanel(new BorderLayout());

        JPanel gamePanel = new JPanel(new GridLayout(size, size)); // Grid para o campo minado

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton();
                int row = i; // Calcula a linha do botão
                int col = j; // Calcula a coluna do botão

                //botão esquerdo na celula
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // roda o jogo no "back" e verifica se ocorreram modificações
                        if (jogo.rodadaPadrao(jogador, row, col)) {
                            if (jogador.isJogando()) { // jogo funcionando
                                atualizarBotoes(buttons);
                                System.out.println(jogo.getTabuleiro());
                                atualizarPontuacao(jogador);
                                System.out.println("Pontuação de " + jogador.getNome() + ":" + jogador.getPontos());
                            } else { // jogo não funcionando
                                perderJogo();

                                Timer timer = new Timer(2000, new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                        SwingUtilities.invokeLater(new Runnable() {
                                            public void run() {
                                                new TelaDerrotaGUI(jogador);
                                                frame.dispose(); // Fecha o JFrame do tabuleiro
                                            }
                                        });
                                    }
                                });
                                timer.setRepeats(false); // Garante que o Timer dispare apenas uma vez
                                timer.start();
                            }
                        }
                    }
                });
                
                //botão direto na celula
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            JButton buttonClicked = (JButton) e.getSource();
                            jogo.alterarBandeira(row, col);
                            if (buttonClicked.isEnabled()) {
                                if (decrementarBandeiras()) {
                                    buttonClicked.setEnabled(false);
                                    buttonClicked.setIcon(new BandeiraImagemIcon());
                                    if (jogo.getTabuleiro().getBombasDisponiveis() == 0) {
                                        ganharJogo();
                                        Timer timer = new Timer(2000, new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                SwingUtilities.invokeLater(new Runnable() {
                                                    public void run() {
                                                        frame.dispose(); // Fecha o JFrame do tabuleiro
                                                        new TelaVitoriaGUI(jogador);
                                                    }
                                                });
                                            }
                                        });
                                        timer.setRepeats(false);
                                        timer.start();
                                    }
                                }
                            } else {
                                buttonClicked.setEnabled(true);
                                buttonClicked.setIcon(null);
                                incrementarBandeiras();
                            }
                        }
                        System.out.println(jogo.getTabuleiro());
                        
                    }
                });
                
                gamePanel.add(buttons[i][j]);
            }
        }

        // Placar
        JPanel placarPanel = new JPanel(new GridLayout(1, 2));

        bandeirasLabel = new JLabel("Bandeiras restantes: " + jogo.getTabuleiro().getBombas());
        placarPanel.add(bandeirasLabel);

        pontuacaoLabel = new JLabel("Pontuação de "+jogador.getNome()+": 0");
        placarPanel.add(pontuacaoLabel);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuGUI menuGUi = new MenuGUI();
            }
        });

        panel.add(gamePanel, BorderLayout.CENTER);
        panel.add(placarPanel, BorderLayout.SOUTH);
        panel.add(voltarButton, BorderLayout.NORTH);

        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centralizar na tela
        frame.setVisible(true);
    }

    private void clicarCelula(int row, int col) {
        buttons[row][col].setBackground(Color.GREEN); // Muda a cor do botão clicado
        buttons[row][col].setEnabled(false);// desabilira o click
    }
    
    private boolean decrementarBandeiras() {
        int bandeiras = Integer.parseInt(bandeirasLabel.getText().split(": ")[1]);
        if(bandeiras != 0){
            bandeiras--;
            bandeirasLabel.setText("Bandeiras restantes: " + bandeiras);
            return(true);
        }
        else return(false);
    }
    
    private void incrementarBandeiras() {
        int bandeiras = Integer.parseInt(bandeirasLabel.getText().split(": ")[1]);
        bandeiras++;
        bandeirasLabel.setText("Bandeiras restantes: " + bandeiras);
    }

    private void atualizarPontuacao(Jogador jogador) {
        pontuacaoLabel.setText("Pontuação de "+jogador.getNome()+": " + jogador.getPontos());
    }
    private void perderJogo(){
        // guarda o historico do jogador
        Historico historico = new Historico();
        historico.adicionarJogador(jogador);

        int size = jogo.getTabuleiro().getTamanho();
        for(int x = 0; x < size; x++){
            for(int y = 0;y<size;y++){
                JButton botaoRodada = buttons[x][y];//pega o botão da posição x e y
                botaoRodada.setEnabled(false);

                // pega as celulas bombas e as mostra
                Celula celula = jogo.getTabuleiro().getMatriz()[x][y];
                //verifica se é bomba
                if(celula.getCelulaSimples() != null && celula.getCelulaSimples().getSimbolo() == '°'){
                    clicarBomba(x, y);
                    botaoRodada.repaint();
                }
            }
        }
    }

    private void ganharJogo(){
        // guarda o historico do jogador
        Historico historico = new Historico();
        historico.adicionarJogador(jogador);

        int size = jogo.getTabuleiro().getTamanho();
        for(int x = 0; x < size; x++){
            for(int y = 0;y<size;y++){
                JButton botaoRodada = buttons[x][y];//pega o botão da posição x e y
                botaoRodada.setEnabled(false);

                // pega as celulas bombas e as mostra
                Celula celula = jogo.getTabuleiro().getMatriz()[x][y];
                if(celula.getCelulaSimples() != null && celula.getCelulaSimples().getSimbolo() == '°'){
                    botaoRodada.setEnabled(false);
                }
            }
        }
    }

    private void atualizarBotoes(JButton buttons[][]) {
        int size = jogo.getTabuleiro().getTamanho();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Celula celula = jogo.getTabuleiro().getMatriz()[x][y];
                // caso a celula seja modificada
                if (!(celula.getCelulaSimples() == null || (celula.getCelulaSimples().getClicado() == false))) {
                    if (celula.getCelulaSimples().getSimbolo() == '@') {
                        clicarCelula(x ,y);
                    } else if (celula.getCelulaSimples().getSimbolo() == '°') {
                        clicarBomba(x, y);
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

    private void clicarBomba(int row, int col){
        JButton currentButton = buttons[row][col];
        currentButton.setIcon(new BombaImagemIcon()); // Mostra a imagem da bomba
        currentButton.setEnabled(false);// desabilira o click
        currentButton.setText("°");
        currentButton.repaint();
    }
}