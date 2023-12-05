package campoMinado.ModosJogo.Jogadores;

public class JogadorSingle extends Jogador {

    public JogadorSingle(String nome) {
        super(nome);
        
    }
    
    public String encontrarBomba(){
        setPontos(getPontos() - 3);
        return "Encontrou bomba! Você foi eliminado!";
    }

    public String passarRodada(){
        super.passarRodada();
        return "Você não encontrou bomba!";
    }
    
}
