package campoMinado.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.Jogadores.JogadorMultiplayer;

public class SelecaoNomesJogadores {
    private static Jogo jogo; 

    public SelecaoNomesJogadores(Jogo jogo){
        this.jogo = jogo;
        initGUI();
    }
    private static void initGUI() {
        JFrame frame = new JFrame("Seleção dos nomes dos jogadores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // Ajustando a altura para torná-la mais compacta
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10)); // Adicionando espaçamento entre os componentes
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font labelFont = new Font("Arial", Font.BOLD, 16); // Fonte para os rótulos
        Font fieldFont = new Font("Arial", Font.PLAIN, 16); // Fonte para os campos de texto

        JLabel labelNome1 = new JLabel("Nome do primeiro jogador:");
        labelNome1.setFont(labelFont);
        JTextField nomeJogador1Field = new JTextField();
        nomeJogador1Field.setFont(fieldFont);

        JLabel labelNome2 = new JLabel("Nome do segundo jogador:");
        labelNome2.setFont(labelFont);
        JTextField nomeJogador2Field = new JTextField();
        nomeJogador2Field.setFont(fieldFont);

        panel.add(labelNome1);
        panel.add(nomeJogador1Field);
        panel.add(labelNome2);
        panel.add(nomeJogador2Field);

        int option = JOptionPane.showConfirmDialog(frame, panel, "Digite os nomes dos jogadores", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nomeJogador1 = nomeJogador1Field.getText().trim();
            String nomeJogador2 = nomeJogador2Field.getText().trim();

            if (!nomeJogador1.isEmpty() && !nomeJogador2.isEmpty()) {
                JogadorMultiplayer jogador1 = new JogadorMultiplayer(nomeJogador1);
                JogadorMultiplayer jogador2 = new JogadorMultiplayer(nomeJogador2);
                TabuleiroMultiGUI tabuleiroMultiGUI = new TabuleiroMultiGUI(jogo, jogador1, jogador2);
            } else {
                // Se um dos nomes estiver vazio, mostrar mensagem de erro e permitir tentar novamente
                int retryOption = JOptionPane.showConfirmDialog(frame, "Nomes dos jogadores não podem estar vazios! Deseja tentar novamente?", "Erro", JOptionPane.YES_NO_OPTION);
                if (retryOption == JOptionPane.YES_OPTION) {
                    initGUI(); // Tente novamente inserir os nomes
                } else {
                	MenuGUI menuGUi = new MenuGUI(); // Volte para o menu principal se o usuário cancelar
                }
            }
        } else {
        	MenuGUI menuGUi = new MenuGUI(); // Se o usuário cancelar, volte para o menu principal
    }
}

}
