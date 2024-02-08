package campoMinado.Tabuleiros;

import java.util.Random;

import campoMinado.Celulas.Celula;
import campoMinado.Celulas.CelulaMaluca.CelulaMaluca;
import campoMinado.Celulas.CelulaSimples.CelulaVazia;
import campoMinado.Celulas.CelulaSimples.CelulaVizinha;

public class TabuleiroMaluco extends Tabuleiro{

    public TabuleiroMaluco(int p1, int p2) {
        super(p1, p2);
    }

    private void iniciarCelulasMalucas(){
		Random rand = new Random();
		for(int i = 0; i < getTamanho();i++){
			for(int j = 0; j < getTamanho(); j ++ ){
				int aleatorio = rand.nextInt();
				if(aleatorio % 2 == 0) // seleção aleatoria das celulas malucas , 50% de chance
					getMatriz()[i][j].setCelulaMaluca(new CelulaMaluca());
			}
		}
	}

    protected void iniciarCelulas(int x, int y) {
		super.iniciarCelulas(x,y); // inicializa com conf. padrão
        iniciarCelulasMalucas(); // inicializa com as malucas
	}

	public void clicarBandeira(int x, int y){
		Celula celulaSelecao = getMatriz()[x][y]; // cria uma referencia para a celula a ser modificada
			if(celulaSelecao.trocarBandeira()){// altera o estado da celula
				for(int i = -1; i < 2; i++){ //percorre as 3 posições x
					if ((x + i) >= 0 && (x + i) < getTamanho()){ //verifica se o valor é válido
						for(int j = -1; j < 2; j ++ ){ //percorre as 3 posições y
							if((y+j) >= 0 && (y + j) < getTamanho()) {// verifica se o valor é válido
								celulaSelecao = getMatriz()[x+i][y+j];
								if((!(celulaSelecao.getCelulaSimples() == null)) && celulaSelecao.getCelulaSimples().getClicado()){// verifica se a celula ja foi clicada
									int bombasAoRedor = contagemBombas(x+i, y+j);		
									if (bombasAoRedor > 0)// verifica se tem bombas ao redor
										celulaSelecao.setCelulaSimples(new CelulaVizinha(bombasAoRedor)); // atualiza a celula
									else 
										celulaSelecao.setCelulaSimples(new CelulaVazia()); // atualiza a celula

									celulaSelecao.getCelulaSimples().clicarCelula();// coloca a celula como clicada
								}
							}
						}
					}
				}
			}
		}
}
