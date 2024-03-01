package campoMinado.GUI;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;

import java.awt.*;
import java.awt.event.*;

public class MenuGUI {

    private static RecordesGUI recordesGUI;

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
                fecharHistorico();
                
                EscolhaModoJogoGUI escolhaModoJogoGUI = new EscolhaModoJogoGUI();
                escolhaModoJogoGUI.initGUI();

            }
        });

        creditosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                fecharHistorico();
                
                CreditosGUI creditosGUI = new CreditosGUI();
                creditosGUI.initGUI();
                
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", "Confirmar saída", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    fecharHistorico();
                    System.exit(0);
                    
                }
            }
        });

        JButton historicoButton = new JButton("Histórico");
        historicoButton.setFont(buttonFont);
        historicoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(fecharHistorico()){
                    recordesGUI = new RecordesGUI(frame);
                };
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
    private static boolean fecharHistorico(){
        if (recordesGUI != null) {
            recordesGUI.closeFrame();
            recordesGUI = null;
            return false; // retorna falso para não criar um historico novo
        }else{
            return true; // retorna true para criar um novo historico
        }
    }

    public static void main(String[] args) {
        initGUI();
    }
}
