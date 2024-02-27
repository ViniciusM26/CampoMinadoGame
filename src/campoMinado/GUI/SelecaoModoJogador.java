package campoMinado.GUI;

import javax.swing.*;

import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.Jogadores.JogadorMultiplayer;
import campoMinado.ModosJogo.Jogadores.JogadorSingle;

import java.awt.*;
import java.awt.event.*;

public class SelecaoModoJogador {
    private static boolean modoJogo;
    private static Jogo jogo;
    
    public SelecaoModoJogador(boolean modoJogo, Jogo jogo){
        SelecaoModoJogador.modoJogo = modoJogo;
        SelecaoModoJogador.jogo = jogo;
    }

    public static void initGUI() {
        JFrame frame = new JFrame("Minha GUI");

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 1)); // Reduzindo para 3 para os botões principais
        panel.setSize(600, 600);

        JButton singleButton = new JButton("Singleplayer");
        JButton multiButton = new JButton("Multiplayer");

        Font buttonFont = new Font(singleButton.getFont().getName(), Font.PLAIN, 20);
        singleButton.setFont(buttonFont);
        multiButton.setFont(buttonFont);

        singleButton.addActionListener(new ActionListener() { //escolha do modo single
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String nomeJogador = JOptionPane.showInputDialog(frame, "Digite o nome do jogador:");

                // Verificar se o nome do jogador não está vazio
                if (nomeJogador != null && !nomeJogador.isEmpty()) {
                    JogadorSingle jogador = new JogadorSingle(nomeJogador);
                    TabuleiroSingleGUI tabuleiroSingleGUI = new TabuleiroSingleGUI(jogo, jogador);
                    tabuleiroSingleGUI.initGUI();
                } else {
                    // Se o nome do jogador for vazio ou cancelado, mostrar mensagem de erro
                    JOptionPane.showMessageDialog(frame, "Nome do jogador inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        multiButton.addActionListener(new ActionListener() { // escolha do modo single
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                
                // Painel para entrada dos nomes dos jogadores
                JPanel panel = new JPanel(new GridLayout(3, 2));
                JTextField nomeJogador1Field = new JTextField();
                JTextField nomeJogador2Field = new JTextField();
                panel.add(new JLabel("Nome do primeiro jogador:"));
                panel.add(nomeJogador1Field);
                panel.add(new JLabel("Nome do segundo jogador:"));
                panel.add(nomeJogador2Field);
        
                // Diálogo para entrada dos nomes dos jogadores
                int resultado = JOptionPane.showConfirmDialog(frame, panel, "Digite os nomes dos jogadores", JOptionPane.OK_CANCEL_OPTION);
        
                // Se o usuário pressionar OK (ou equivalente)
                if (resultado == JOptionPane.OK_OPTION) {
                    String nomeJogador1 = nomeJogador1Field.getText();
                    String nomeJogador2 = nomeJogador2Field.getText();
        
                    // Verificar se ambos os nomes não estão vazios
                    if (!nomeJogador1.isEmpty() && !nomeJogador2.isEmpty()) {
                        // Se ambos os nomes forem válidos, iniciar a GUI do tabuleiro single com esses nomes
                        JogadorMultiplayer jogador1 = new JogadorMultiplayer(nomeJogador1);
                        JogadorMultiplayer jogador2 = new JogadorMultiplayer(nomeJogador2);
                        TabuleiroMultiGUI tabuleiroMultiGUI = new TabuleiroMultiGUI(jogo, jogador1, jogador2);
                        tabuleiroMultiGUI.initGUI();
                    } else {
                        // Se um dos nomes estiver vazio, mostrar mensagem de erro
                        JOptionPane.showMessageDialog(frame, "Nomes dos jogadores não podem estar vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        
        panel.add(singleButton);
        panel.add(multiButton);

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

    public static void main(String[] args) {
        initGUI();
    }
}
