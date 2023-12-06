package campoMinado.ModosJogo;

import campoMinado.ModosJogo.Jogadores.JogadorMultiplayer;

public class JogoMultiplayer extends Jogo {
	public JogoMultiplayer() {
		super();
	}


	public void Jogar(){
		inciarJogo();
		JogadorMultiplayer jogador1 = new JogadorMultiplayer("Bruno");
		JogadorMultiplayer jogador2 = new JogadorMultiplayer("Lumiar");
		
		JogadorMultiplayer jogadorDaRodada; // cria uma referencia ao jogador da rodada

		while(getFuncionamentoJogo() == true){
			if (getRodadas() % 2 == 1) // escolhe qual será o jogador da rodada
				jogadorDaRodada = jogador1;
			else
				jogadorDaRodada = jogador2;

			rodadaPadrao(jogadorDaRodada);
			System.out.println((jogadorDaRodada.getPontos()));
		}
	}	
}

