package campoMinado.ModosJogo;

import campoMinado.ComponentesJogo.Tabuleiro;

public class Jogo {
    private boolean funcionamentoJogo;
	private Tabuleiro tabuleiro;
	private int rodadas;

    public Jogo(){
		setTabuleiro(new Tabuleiro(7,7));
    }

    public void Jogar(){

    }

    public int getRodadas() {
		return rodadas;
	}

	private void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}
	
    public boolean getFuncionamentoJogo() {
        return this.funcionamentoJogo;
    }

    private void setFuncionamentoJogo(boolean p1){
       this.funcionamentoJogo = p1;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    private void setTabuleiro(Tabuleiro p1){
        this.tabuleiro = p1;
    }

    protected void passarRodada(){ // função que vai alterar diretamente as rodadas
        setRodadas(getRodadas() + 1);
    }

    public void inciarJogo(){ // função que inicia o jogo
		setFuncionamentoJogo(true);
		setRodadas(0);
	}

	public void pararJogo(){ // função que para o jogo
		setFuncionamentoJogo(false);
	}
   
}
