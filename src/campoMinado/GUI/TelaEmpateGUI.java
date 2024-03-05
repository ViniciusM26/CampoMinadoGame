package campoMinado.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import campoMinado.ModosJogo.Jogadores.Jogador;

public class TelaEmpateGUI extends JFrame {

    public TelaEmpateGUI() {
        initGUI();
    }

    private void initGUI() {
        setTitle("Empate");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Empate!!Jogem novamente!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        JButton voltarButton = new JButton("Fechar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
                MenuGUI menuGUI = new MenuGUI();
            }
        });
        add(voltarButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaEmpateGUI();
    }
}
