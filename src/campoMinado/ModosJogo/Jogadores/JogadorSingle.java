package campoMinado.ModosJogo.Jogadores;

public class JogadorSingle extends Jogador {

    public JogadorSingle(String nome) {
        super(nome);
    }
    
    public String encontrarBomba(){
        super.eliminado();
        return "Encontrou bomba! Você foi eliminado!";
    }

    public String passarRodada(){
        setPontos(getPontos()+1);
        return "você não encontrou bomba!";
    }
    
}
