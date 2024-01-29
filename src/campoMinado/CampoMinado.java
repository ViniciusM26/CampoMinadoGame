package campoMinado;

import java.util.InputMismatchException;

import campoMinado.ModosJogo.Jogo;
import campoMinado.ModosJogo.JogoMaluco;
import campoMinado.ModosJogo.JogoMultiplayer;
import campoMinado.ModosJogo.JogoSolo;
import campoMinado.Tabuleiros.Tabuleiro;
import campoMinado.Tabuleiros.TabuleiroMaluco;

public class CampoMinado {

	public static void main(String[] args) {
		// criar os jogadores
		Jogo jogo; // função que cria o objeto jogo multiplayer
		int modo;
		Tabuleiro tabuleiro;

		try {
			modo = Menu.rodarMenu();
		} catch (InputMismatchException e) {
			System.out.println("Erro: " + e.getMessage());
			return;
		}
		
		switch (modo) {
			case 1:
				tabuleiro = new Tabuleiro(7,7); // cria o tabuleiro
				jogo = new JogoSolo(tabuleiro);
				jogo.Jogar(); // função que joga
				break;
			
			case 2:
				tabuleiro = new Tabuleiro(7, 7);// cria o tabuleiro
				jogo = new JogoMultiplayer(tabuleiro);
				jogo.Jogar(); // função que joga
				break;
			case 3:
				tabuleiro = new TabuleiroMaluco(7, 7); // cria o tabuleiro
				jogo = new JogoMaluco(tabuleiro);
				jogo.Jogar();// função que joga

			default:
				System.out.println("valor inválido");
				break;
		}

	}

}
