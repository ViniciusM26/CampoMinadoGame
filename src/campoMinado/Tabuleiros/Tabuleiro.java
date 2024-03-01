package campoMinado.Tabuleiros;

import java.util.Random;

import campoMinado.Celulas.Celula;
import campoMinado.Celulas.CelulaSimples.Bomba;
import campoMinado.Celulas.CelulaSimples.CelulaVazia;
import campoMinado.Celulas.CelulaSimples.CelulaVizinha;
import campoMinado.Interfaces.TabuleiroInterface;

public class Tabuleiro implements TabuleiroInterface {
	
	private Celula[][] matriz;
	private int tamanho;
	private int bombas;
	private int bombasDisponiveis;

	public Tabuleiro(int modo) {
		
		switch(modo){
			case 1:
				setBombas(4);
				setTamanho(5);
				break;
			case 2:
				setBombas(16);
				setTamanho(8);
			case 3:
				setTamanho(10);
				setBombas(25);
		}

	    setMatriz(new Celula[getTamanho()][getTamanho()]);
		iniciarMatriz();

	}


	public int getBombasDisponiveis() {
		return bombasDisponiveis;
	}

	public void setBombasDisponiveis(int bombasDisponiveis) {
		this.bombasDisponiveis = bombasDisponiveis;
	}

	private void setMatriz(Celula [][] matriz){
		this.matriz = matriz;
	}

	public Celula [][] getMatriz(){
		return this.matriz;
	}

	public int getTamanho(){
		return this.tamanho;
	}

	private void setTamanho(int p1){
		this.tamanho = p1;
	}

	public int getBombas(){
		return this.bombas;
	}

	private void setBombas(int p1){
		this.bombas = p1;
		setBombasDisponiveis(p1);
	}

	public int contagemBombas(int x, int y){
		int contador = 0;
		// Percorre em x nas 3 posições
		for(int i = -1;i < 2;  i++) {
			//verifica se a soma não será uma posição negativa ou maior que o tamanho
			if ((x + i) >= 0 && (x + i) < getTamanho()) {
				//percorre em y nas 3 posições
				for (int j = -1; j < 2; j++) {
					//verifica se a soma não será uma posição negativa
					if ((y + j) >= 0 && (y + j) < getTamanho()) {
						// verifica se a posição analisada não é a propia celula
						if(i != 0 || j != 0) {
							if(!(matriz[x + i][y + j].getCelulaSimples() == null) && (matriz[x + i][y + j].getCelulaSimples() instanceof Bomba)) {	
								contador++;
							}
						}	
					}
				}
			}
		}
		return contador;
	}

	@Override
	public boolean clicarCelula(int x, int y){
		Celula celulaSelecao = getMatriz()[x][y];
			if (!(celulaSelecao.getCelulaSimples() == null) && celulaSelecao.getCelulaSimples() instanceof Bomba) { 
				celulaSelecao.getCelulaSimples().clicarCelula();
				return true; // retorna verdadeiro se tem bomba
			} else {
				if (celulaSelecao.getCelulaSimples() == null){ // Verifica se já foi selecionado
					int bombasAoRedor = contagemBombas(x, y); // Armazena a quantidade de bombas ao redor de uma célula
					if (bombasAoRedor > 0) { // verifica o tipo da celula
						celulaSelecao.setCelulaSimples(new CelulaVizinha(bombasAoRedor));// incializa celula simples
						celulaSelecao.getCelulaSimples().clicarCelula(); // faz com que a celula seja clicada
					} else {
						celulaSelecao.setCelulaSimples(new CelulaVazia());// incializa celula simples
						celulaSelecao.getCelulaSimples().clicarCelula(); // faz com que a celula seja clicada
						// seleção de todas as bombas ao redor
						for (int i = -1; i < 2; i ++){ 
							for(int j = -1; j < 2; j++){
								selecionar(x + i, y + j);
							}
						}
					}
				}
				return false; // retorna falso se tem bomba
			}
		}
	
	@Override
	public void clicarBandeira(int x, int y){
		Celula currentCell = getMatriz()[x][y];
		//verificação se é bomba
		if(currentCell.getCelulaSimples() != null && !(currentCell.getCelulaSimples().getClicado())){
			if(currentCell.isBandeira()){
				setBombasDisponiveis(getBombasDisponiveis()+1);//tirando bandeira
			}else{
				setBombasDisponiveis(getBombasDisponiveis()-1);//colocando bandeira
			}
			currentCell.trocarBandeira();// inverte o estado da bandeira
		}
		
	}

	@Override
	public boolean selecionar(int x, int y) {
		if (x >= 0 && y >= 0 && y < getTamanho() && x < getTamanho()){
			if( getMatriz()[x][y].getCelulaSimples() == null|| !(getMatriz()[x][y].getCelulaSimples().getClicado()))// verifica se a celula ja foi clicada
				return clicarCelula(x, y);
			}
		return false; // retorna falso por não ter bomba
	}	

	protected void iniciarMatriz(){
		for(int i = 0; i < getTamanho();i++){
			for(int j = 0; j < getTamanho(); j ++ ){
				matriz[i][j] = new Celula();
			}
		}
	}

	public void iniciarBombas(int x, int y){
		Random rand = new Random(); // cria um random

		// sorteio de bombas
		for (int i = 0; i < getBombas(); i++) {
			int l = rand.nextInt(tamanho); // random em x
			int c = rand.nextInt(tamanho); // random em y
	
			// Verifica se a célula na posição não é bomba
			if(!(l == x && c == y)){
				if (matriz[l][c].getCelulaSimples() == null || !(matriz [l][c].getCelulaSimples() instanceof Bomba)) {
					matriz[l][c].setCelulaSimples(new Bomba()); // coloca uma bomba no local
				}
			} else {
				i--;
			}
		}	
	}

	@Override
    public String toString() {
		String str = "";
		
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (!(matriz[i][j].isBandeira())){// verifica se tem bandeira no local
					if (matriz[i][j].getCelulaSimples() == null || matriz[i][j].getCelulaSimples().getClicado() == false){
						str += "# "; // simbolo para não selecionados
					}else {
						str += matriz[i][j].getCelulaSimples().getSimbolo(); // pega o simbolo por overwriting
						str += " "; // espaçamento
					}
				}else{
					str += "! "; // simbolo para bandeiras
				}
			}
				str += "\n";// quebra de linha
			}
		return str;
	}

}
	