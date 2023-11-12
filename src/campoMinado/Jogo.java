package campoMinado;

public class Jogo {
	 private boolean funcionamentoJogo;
	 private Tabuleiro tabuleiro;
	 private int tempo;
	    
	 public boolean funcionamentoJogo() {
		 return this.funcionamentoJogo;
	 }
	    
	 public Tabuleiro tabuleiro() {
		 return this.tabuleiro;
	 }
	    
	 public int tempo() {
		 return this.tempo;
	 }

	 public Jogo(int tamanho, int bandeiras, int bombas) {
		 this.tabuleiro = new Tabuleiro();
	     this.tempo = 0;
	     this.funcionamentoJogo = true;
	 }
}

