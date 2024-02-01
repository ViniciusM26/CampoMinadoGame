package campoMinado.ModosJogo;

import campoMinado.Exceptions.InputException;
import campoMinado.ModosJogo.Jogadores.JogadorSingle;
import campoMinado.Tabuleiros.Tabuleiro;

public class JogoMaluco extends Jogo {
    public JogoMaluco(Tabuleiro tabuleiro){
        super(tabuleiro);
    }

    @Override
    public void Jogar(){
		inciarJogo();

		JogadorSingle jogador = new JogadorSingle("Bruno");
		
		while(getFuncionamentoJogo() == true){
			try{
			rodadaPadrao(jogador);
			}catch (InputException e){
				System.out.println( e.getMessage());
			}
			if(!(jogador.isJogando())){
				System.out.println(getTabuleiro());
				pararJogo();
			}
		}
	}
}
