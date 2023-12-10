package campoMinado.ComponentesJogo;

import java.util.Random;

import campoMinado.Celulas.Celula;
import campoMinado.Celulas.CelulaMaluca.CelulaMaluca;
import campoMinado.Celulas.CelulaSimples.Bomba;

public class TabuleiroMaluco extends Tabuleiro{

    public TabuleiroMaluco(int p1, int p2) {
        super(p1, p2);
    }

    private void iniciarCelulasMalucas(){
		Random rand = new Random();
		for(int i = 0; i < getTamanho();i++){
			for(int j = 0; j < getTamanho(); j ++ ){
				int aleatorio = rand.nextInt();
				if((aleatorio % 2) == 0) // seleção aleatoria das celulas malucas
					getMatriz()[i][j].setCelulaMaluca(new CelulaMaluca());
			}
		}
	}

    protected void iniciarCelulas() {
		super.iniciarCelulas(); // inicializa com conf padrão
        iniciarCelulasMalucas(); // inicializa com as malucas
	}
	public void clicarBandeira(int x, int y){
		super.clicarBandeira(x, y);
		Celula celulaSelecao = getMatriz()[x][y]; 
		if (!(celulaSelecao.isBandeira()))// verifica se está colocando ou tirando bandeira
					if(!(celulaSelecao.getCelulaMaluca() == null)){// verifica se a celula é maluca
						if(celulaSelecao.getCelulaMaluca().clicarCelula()){ // verifica se vai alterar seu estado
							//alteração do estado
							if(celulaSelecao.getCelulaSimples() == null) 
								celulaSelecao.setCelulaSimples(new Bomba());
							else
								celulaSelecao.setCelulaSimples(null);
						}
					}

	}

    
}
