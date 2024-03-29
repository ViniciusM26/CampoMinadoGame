package campoMinado.ModosJogo;

import campoMinado.Celulas.CelulaSimples.CelulaAbstrata;
import campoMinado.Interfaces.JogoInterface;
import campoMinado.ModosJogo.Jogadores.Jogador;
import campoMinado.Tabuleiros.Tabuleiro;

public class Jogo implements JogoInterface {
    private boolean funcionamentoJogo;
	private Tabuleiro tabuleiro;
	private int rodadas;

    public Jogo (Tabuleiro tabuleiro){
        setTabuleiro(tabuleiro);
    }

    public void alterarBandeira(int row, int col) {
		getTabuleiro().clicarBandeira(row, col);
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

    public boolean rodadaPadrao(Jogador jogador,int x,int y){
            
        if(getRodadas() == 0){//verifica se é o primeiro click
            getTabuleiro().iniciarBombas(x, y);
        }
        // separa a celula normal da maluca
        CelulaAbstrata celulaSimples = getTabuleiro().getMatriz()[x][y].getCelulaSimples();
        if(celulaSimples == null || !(celulaSimples.getClicado())){
            if((getTabuleiro().selecionar(x, y))){ // verifica se tem bomba e altera a celula
                jogador.encontrarBomba();// Retira os pontos
                getTabuleiro().setBombasDisponiveis(getTabuleiro().getBombasDisponiveis()-1);
            }else{
                jogador.passarRodada(); // Coloca os pontos
            }
            passarRodada();
            return true;
        }
        return false;// retorna falso para não fazer modificações
    }
}
