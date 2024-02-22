package campoMinado.ModosJogo;

import campoMinado.Celulas.CelulaSimples.CelulaAbstrata;
import campoMinado.ModosJogo.Jogadores.Jogador;
import campoMinado.Tabuleiros.Tabuleiro;

public abstract class Jogo {
    private boolean funcionamentoJogo;
	private Tabuleiro tabuleiro;
	private int rodadas;

    public Jogo (Tabuleiro tabuleiro){
        setTabuleiro(tabuleiro);
    }

    public abstract void Jogar(Jogador jogador,int row,int col );

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

    protected void setTabuleiro(Tabuleiro p1){
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

    protected boolean rodadaPadrao(Jogador jogador,int x,int y){
            
    CelulaAbstrata celulaSimples = getTabuleiro().getMatriz()[x][y].getCelulaSimples();  // separa a celula normal da maluca
    
    if(celulaSimples == null || !(celulaSimples.getClicado())){
        if((getTabuleiro().selecionar(x, y))){ // verifica se tem bomba e altera a celula
            System.out.println(jogador + jogador.encontrarBomba());// imprime e retira os pontos
        }else{
            System.out.println(jogador + jogador.passarRodada()); // imprime e coloca os pontos
        }
        passarRodada();
        return true;
    }
    return false;
    }
}
