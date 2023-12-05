package campoMinado;

import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.JogoMultiplayer;
import campoMinado.ModosJogo.JogoSolo;

public class CampoMinado {

	public static void main(String[] args) {
		// criar os jogadores
		Jogo jogo; // função que cria o objeto jogo multiplayer
		int modo = Menu.rodarMenu();
		switch (modo) {
			case 1:
				jogo = new JogoSolo();
				jogo.Jogar(); // função que joga
				break;
			
			case 2:
				jogo = new JogoMultiplayer();
				jogo.Jogar(); // função que joga
				break;

			default:
				System.out.println("valor inválido");
				break;
		}

	}

}
