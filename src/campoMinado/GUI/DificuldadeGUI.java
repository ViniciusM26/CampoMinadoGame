package campoMinado.GUI;

import javax.swing.*;

import campoMinado.ModosJogo.Jogo;
import campoMinado.Tabuleiros.Tabuleiro;
import campoMinado.Tabuleiros.TabuleiroDificil;
import campoMinado.Tabuleiros.TabuleiroFacil;
import campoMinado.Tabuleiros.TabuleiroMaluco;
import campoMinado.Tabuleiros.TabuleiroMedio;

import java.awt.*;
import java.awt.event.*;

public class DificuldadeGUI {
    private static boolean modoJogo;

    public DificuldadeGUI(boolean modoJogo){
        DificuldadeGUI.modoJogo = modoJogo;
    }

    public static void initGUI() {
        
        JFrame frame = new JFrame("Minha GUI");

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 1)); // Reduzindo para 3 para os botões principais
        panel.setSize(600, 600);

        JButton easyButton = new JButton("Fácil");
        JButton mediumButton = new JButton("Médio");
        JButton difficultButton = new JButton("Dificil");

        Font buttonFont = new Font(easyButton.getFont().getName(), Font.PLAIN, 20);
        easyButton.setFont(buttonFont);
        mediumButton.setFont(buttonFont);
        difficultButton.setFont(buttonFont);

        easyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Jogo jogo = criarJogo(modoJogo, 1);
                SelecaoModoJogador selecaoModoJogador = new SelecaoModoJogador(modoJogo,jogo);
                selecaoModoJogador.initGUI();
            }
        });

        mediumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Jogo jogo = criarJogo(modoJogo, 2);
                SelecaoModoJogador selecaoModoJogador = new SelecaoModoJogador(modoJogo,jogo);
                selecaoModoJogador.initGUI();
                
            }
        });

        difficultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Jogo jogo = criarJogo(modoJogo, 3);
                SelecaoModoJogador selecaoModoJogador = new SelecaoModoJogador(modoJogo,jogo);
                selecaoModoJogador.initGUI();
            }
        });

        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(difficultButton);

        JPanel bottomPanel = new JPanel(); // Novo painel para o botão "Voltar"
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centralizando o botão "Voltar"
        
        JButton voltarButton = new JButton("Voltar"); // Novo botão de voltar
        voltarButton.setPreferredSize(new Dimension(100, 50)); // Definindo tamanho menor para o botão "Voltar"
        voltarButton.setFont(new Font(voltarButton.getFont().getName(), Font.PLAIN, 15)); // Ajustando o tamanho da fonte
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
                MenuGUI menuGUI = new MenuGUI();
                menuGUI.initGUI();
            }
        });

        bottomPanel.add(voltarButton); // Adiciona o botão "Voltar" ao painel inferior

        frame.add(panel, BorderLayout.CENTER); // Adiciona o painel principal ao centro
        frame.add(bottomPanel, BorderLayout.SOUTH); // Adiciona o painel inferior na parte inferior
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static Jogo criarJogo(boolean modoJogo, int dificuldade){
        Jogo jogo;// cria a variavel
        //instancia de acordo com o usuario
        if(modoJogo){
            jogo = new Jogo(new TabuleiroMaluco(dificuldade)); 
        }else{
            jogo = new Jogo(new Tabuleiro(dificuldade)); 
        }
        return jogo;
    }

    public static void main(String[] args) {
        initGUI();
    }
}