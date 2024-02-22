package campoMinado;

import javax.swing.JFrame;

import campoMinado.GUI.MenuGUI;

public class Main extends JFrame {
    
    public static void main(String[] args){
        MenuGUI minhaGUI = new MenuGUI();
        minhaGUI.initGUI();
    }
}
