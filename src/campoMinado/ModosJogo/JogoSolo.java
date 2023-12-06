package campoMinado.ModosJogo;

import campoMinado.ModosJogo.Jogadores.JogadorSingle;

public class JogoSolo extends Jogo {
	public JogoSolo() {
		super();
	}
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

