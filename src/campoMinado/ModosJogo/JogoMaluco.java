package campoMinado.ModosJogo;

import campoMinado.ComponentesJogo.Tabuleiro;
import campoMinado.ModosJogo.Jogadores.JogadorSingle;

public class JogoMaluco extends Jogo {
    public JogoMaluco(Tabuleiro tabuleiro){
        super(tabuleiro);
    }

    @Override
    public void Jogar(){
		inciarJogo();

		JogadorSingle jogador = new JogadorSingle("Bruno");
		
		while(getFuncionamentoJogo() == true){
			rodadaPadrao(jogador);

			if(!(jogador.isJogando())){
				System.out.println(getTabuleiro());
				pararJogo();
			}
		}
	}
}
