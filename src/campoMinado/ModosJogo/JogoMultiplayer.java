package campoMinado.ModosJogo;

import campoMinado.ModosJogo.Jogadores.Jogador;
import campoMinado.ModosJogo.Jogadores.JogadorMultiplayer;
import campoMinado.Tabuleiros.Tabuleiro;

public class JogoMultiplayer extends Jogo {
	public JogoMultiplayer(Tabuleiro tabueleiro) {
		super(tabueleiro);
	}

	@Override
	public void Jogar(Jogador jogador,int x, int y){
		inciarJogo();
		if(rodadaPadrao(jogador,x,y)){
			jogador.passarRodada();
		}else{
			jogador.encontrarBomba();
		}

	}	
}

