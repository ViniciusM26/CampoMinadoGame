package campoMinado;

import campoMinado.Exceptions.MenuInputException;
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
		int dificuldade;
		Tabuleiro tabuleiro;

		{	//escolha da dificuldade
			System.out.println("Olá, escolha a dificuldade de jogo:\n1.Fácil\n2.Médio\n3.Difícil"); // imprime as opções na tela
        
			while(true){
				try{
					dificuldade = Menu.rodarMenu();
					break;
				}catch(MenuInputException e){
					System.out.println("Erro: "+ e.getMessage());
				}
			}
		}
		{	//escolha do modo de jogo
			System.out.println("Olá, escolha o modo de jogo:\n1.Solo\n2.Multijogador\n3.Maluco"); // imprime as opções na tela
			while(true){
				try {
					modo = Menu.rodarMenu();
					break;		
				}catch (MenuInputException e) {
					System.out.println("Erro: " + e.getMessage());
				}
			}
			
			switch (modo) {
				case 1:
					tabuleiro = new Tabuleiro(dificuldade); // cria o tabuleiro
					jogo = new JogoSolo(tabuleiro);
					jogo.Jogar(); // função que joga
					break;
				
				case 2:
					tabuleiro = new Tabuleiro(dificuldade);// cria o tabuleiro
					jogo = new JogoMultiplayer(tabuleiro);
					jogo.Jogar(); // função que joga
					break;
				case 3:
					tabuleiro = new TabuleiroMaluco(dificuldade); // cria o tabuleiro
					jogo = new JogoMaluco(tabuleiro);
					jogo.Jogar();// função que joga
					break;
			}
		}
		
		
	}

}
