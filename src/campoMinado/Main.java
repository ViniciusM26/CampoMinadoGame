package campoMinado;

import javax.swing.JFrame;
import campoMinado.MinhaGUI.MinhaGUI;

public class Main extends JFrame {
    
    public static void main(String[] args){
        CampoMinado campoMinado = new CampoMinado();
        //campoMinado.jogar();
        MinhaGUI minhaGUI = new MinhaGUI();
        minhaGUI.initGUI();
    }
}
