package campoMinado.ModosJogo;

import campoMinado.ModosJogo.Jogadores.JogadorSingle;
import campoMinado.Tabuleiros.Tabuleiro;

public class JogoMaluco extends Jogo {
    public JogoMaluco(Tabuleiro tabuleiro){
        super(tabuleiro);
    }

    @Override
    public void Jogar(int x, int y){
		inciarJogo();

		JogadorSingle jogador = new JogadorSingle("Bruno");
		
		while(getFuncionamentoJogo() == true){
			rodadaPadrao(jogador, x, y);

			if(!(jogador.isJogando())){
				System.out.println(getTabuleiro());
				pararJogo();
			}
		}
	}
}
