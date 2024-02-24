package campoMinado;

import javax.swing.JFrame;
import campoMinado.MinhaGUI.MinhaGUI;
import campoMinado.ModosJogo.Jogadores.Historico;

public class Main extends JFrame {
    
    public static void main(String[] args){
        CampoMinado campoMinado = new CampoMinado();
        // campoMinado.jogar();
        
        Historico historico = new Historico();
	    
        MinhaGUI minhaGUI = new MinhaGUI();
        minhaGUI.initGUI();
    }
}
