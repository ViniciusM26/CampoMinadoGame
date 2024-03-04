package campoMinado.GUI;

import campoMinado.Celulas.Celula;
import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.Jogadores.Jogador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabuleiroMultiGUI {

    private Jogo jogo;
    private Jogador jogador1;
    private Jogador jogador2;
    private JButton[][] buttons;
    private JLabel bandeirasLabel;
    private JLabel pontuacao1Label;
    private JLabel pontuacao2Label;

    public TabuleiroMultiGUI (Jogo jogo,Jogador jogador1,Jogador jogador2){
        //inicializa as variaveis do jogo Multiplayer
        this.jogo = jogo;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2; 
        initGUI();
    }

    public void initGUI() {

        int size = jogo.getTabuleiro().getTamanho();// pega do tabuleiro o tamanho
        
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
                        Jogador jogadorDaRodada;// cria uma variavel para referenciar o jogador
                        if(jogo.getRodadas()%2 == 0){
                             jogadorDaRodada= jogador1;
                        }else{
                            jogadorDaRodada = jogador2;
                        }
                        jogo.rodadaPadrao(jogadorDaRodada,row, col);//roda o jogo no back

                        atualizarBotoes(buttons);
                        System.out.println(jogo.getTabuleiro());// mostra o tabuleiro no console
                        atualizarPontuacao(jogadorDaRodada);
                        if(jogo.getTabuleiro().getBombasDisponiveis() == 0){
                            acabarJogo();
                            Timer timer = new Timer(2000, new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {
                                    SwingUtilities.invokeLater(new Runnable() {
                                        public void run() {
                                            frame.dispose(); // Fecha o JFrame do tabuleiro
                                            if(jogador1.getPontos() > jogador2.getPontos())
                                                new TelaVitoriaGUI(jogador1);
                                            else if(jogador2.getPontos() > jogador1.getPontos())
                                                new TelaVitoriaGUI(jogador2);
                                            else new TelaEmpateGUI();
                                        }
                                    });
                                }
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                    }
                });
                //botão direto na celula
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) { // Verifica se foi um clique com o botão direito
                            JButton buttonClicked = (JButton) e.getSource(); // Obtém o botão clicado
                            jogo.alterarBandeira(row, col);
                            System.out.println(jogo.getTabuleiro());
                            if (buttonClicked.isEnabled()) {
                                //coloca a bandeira
                                if(decrementarBandeiras()){
                                    buttonClicked.setEnabled(false);
                                    buttonClicked.setIcon(new BandeiraImagemIcon());
                                    if(jogo.getTabuleiro().getBombasDisponiveis() == 0){
                                        acabarJogo();
                                        Timer timer = new Timer(2000, new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                SwingUtilities.invokeLater(new Runnable() {
                                                    public void run() {
                                                        frame.dispose(); // Fecha o JFrame do tabuleiro
                                                        if(jogador1.getPontos() > jogador2.getPontos())
                                                            new TelaVitoriaGUI(jogador1);
                                                        else if(jogador2.getPontos() > jogador1.getPontos())
                                                            new TelaVitoriaGUI(jogador2);
                                                        else new TelaEmpateGUI();
                                                    }
                                                });
                                            }
                                        });
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

        pontuacao1Label = new JLabel("Pontuação de "+jogador1.getNome()+": 0");
        pontuacao2Label = new JLabel("Pontuação de "+jogador2.getNome()+": 0");
        placarPanel.add(pontuacao1Label);
        placarPanel.add(pontuacao2Label);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuGUI.initGUI();
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

    private void acabarJogo(){
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
        Jogador jogadorDaRodada;
        if(jogo.getRodadas() % 2 == 0){
            jogadorDaRodada = jogador1;
            pontuacao1Label.setText("Pontuação de "+ jogadorDaRodada.getNome() + ": " + jogador.getPontos());
        }else{
            jogadorDaRodada = jogador2;
            pontuacao2Label.setText("Pontuação de "+ jogadorDaRodada.getNome() + ": " + jogador.getPontos());
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
                        clicarBomba(x,y);
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

    private void clicarBomba(int x, int y) {
        JButton currentButton = buttons[x][y];
        currentButton.setText("°");
        currentButton.setEnabled(false);
        currentButton.setBackground(Color.RED);
    
    }
    
}