package campoMinado;

import campoMinado.Jogos.Jogador;
import campoMinado.Jogos.JogoMultiplayer;

public class CampoMinado {

	public static void main(String[] args) {
		// criar os jogadores
		Jogador bruno = new Jogador("Bruno");
		Jogador lumiar = new Jogador("Lumiar");
		JogoMultiplayer jogo = new JogoMultiplayer(); // função que cria o objeto jogo
		jogo.Jogar(bruno,lumiar); // função que joga

	}

}
