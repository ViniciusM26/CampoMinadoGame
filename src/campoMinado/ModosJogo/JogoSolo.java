package campoMinado.ModosJogo;

import campoMinado.ModosJogo.Jogadores.Jogador;
import campoMinado.ModosJogo.Jogadores.JogadorSingle;
import campoMinado.Tabuleiros.Tabuleiro;

public class JogoSolo extends Jogo {
	JogadorSingle jogador;
	public JogadorSingle getJogador() {
		return jogador;
	}

	public void setJogador(JogadorSingle jogador) {
		this.jogador = jogador;
	}

	public JogoSolo(Tabuleiro tabuleiro) {
		super(tabuleiro);
		setJogador(new JogadorSingle("Bruno"));
		inciarJogo();
	}

	@Override
	public void Jogar(Jogador jogador,int row, int col){
		if(rodadaPadrao(jogador, row, col)){
			jogador.passarRodada();
		}else{
			jogador.encontrarBomba();
		}
	}	
}