package campoMinado.ModosJogo.Jogadores;

public class JogadorMultiplayer extends Jogador {
    public JogadorMultiplayer(String nome) {
        super(nome);
    }
    public String encontrarBomba(){
        setPontos(getPontos() - 3);
        return "Encontrou bomba! (perca 3 pontos)";
    }

    public String passarRodada(){
        setPontos(getPontos() + 1);
        return "Você não encontrou bomba!(ganhe 1 ponto)";
    }

}
