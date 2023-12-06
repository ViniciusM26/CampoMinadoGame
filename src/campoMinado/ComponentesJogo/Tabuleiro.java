package campoMinado.ComponentesJogo;

import java.util.Random;

import campoMinado.Celulas.Bomba;
import campoMinado.Celulas.Celula;
import campoMinado.Celulas.CelulaVazia;
import campoMinado.Celulas.CelulaVizinha;

public class Tabuleiro {
	
	private Celula [][] matriz; 
	private boolean[][] bandeiras;
	private int tamanho ;
	private int bombas;

	public Tabuleiro(int p1, int p2) {
		this.setTamanho(p1);
		this.setBombas(p2);
 
		setBandeiras(new boolean[getTamanho()][getTamanho()]);
		iniciarBandeiras(); // função que inicializa os elementos como false

	    setMatriz(new Celula[getTamanho()][getTamanho()]);
		iniciarCelulas(); // função que inicializa os elementos como bomba ou null

	}

	private void setMatriz(Celula [][] matriz){
		this.matriz = matriz;
	}

	public Celula [][] getMatriz(){
		return this.matriz;
	}
	
	public boolean[][] getBandeiras() {
		return bandeiras;
	}

	private void setBandeiras(boolean[][] bandeiras) {
		this.bandeiras = bandeiras;
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
	}

	public void mudarBandeira(int x,int y){
		if(getBandeiras()[x][y])
			getBandeiras()[x][y] = false;
		else
			getBandeiras()[x][y] = true;
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
							if(!(matriz[x + i][y + j] == null) && (matriz[x + i][y + j] instanceof Bomba)) {	
								contador++;
							}
						}	
					}
				}
			}
		}
		return contador;
	}

	public boolean selecionar(int x, int y, int z) {
		if (x >= 0 && y >= 0 && y < getTamanho() && x < getTamanho()){
			//verifica se não é nulo ou é bomba
			if (z == 0){
				if (!(bandeiras[x][y])){// verifica se tem bandeira
					if (!(this.matriz[x][y] == null) && this.matriz[x][y] instanceof Bomba) { 
						matriz[x][y].clicarCelula();
						return true; // retorna verdadeiro se tem bomba
					} else {
						if (matriz[x][y] == null){ // Verifica se já foi selecionado
							int bombasAoRedor = contagemBombas(x, y); // Armazena a quantidade de bombas ao redor de uma célula
							if (bombasAoRedor > 0) { // verifica o tipo da celula
								matriz[x][y] = new CelulaVizinha(contagemBombas(x, y));
								matriz[x][y].clicarCelula(); // faz com que a celula seja clicada
							} else {
								matriz[x][y] = new CelulaVazia();
								matriz[x][y].clicarCelula(); // faz com que a celula seja clicada
								// seleção de todas as bombas ao redor
								for (int i = -1; i < 2; i ++){ 
									for(int j = -1; j < 2; j++){
										selecionar(x+i,y+j,0);
									}
								}
							}
						}
						return false; // retorna falso se tem bomba
					}
				}
			}else{
				mudarBandeira(x, y); // inverte o boolean da bandeira
			} 
		}
		return false; // retorna falso por não ter bomba
	}	
	private void iniciarCelulas() {
		Random rand = new Random(); // cria um random
		
		// sorteio de bombas
		for (int i = 0; i < getBombas(); i++) {
			int l = rand.nextInt(tamanho); // random em x
			int c = rand.nextInt(tamanho); // random em y
	
			// Verifica se a célula na posição não é bomba
			if (matriz[l][c] == null || !(matriz [l][c] instanceof Bomba)) { // pensar sobre modificação de posições para o jogo maluco
				matriz[l][c] = new Bomba(); // coloca uma bomba no local
			} else {
				i--;
			}
		}
	}
	private void iniciarBandeiras(){
		for (int i = 0; i < getTamanho();i++){
			for(int j = 0; j < getTamanho(); j ++){
				getBandeiras()[i][j] = false; // coloca todas as posições como false
			}
		}
	}
	@Override
    public String toString() {
		String str = "";
		
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (!(bandeiras[i][j])){// verifica se tem bandeira no local
					if (matriz[i][j] == null || matriz[i][j].getClicado() == false){
						str += "# "; // simbolo para não selecionados
					}else {
						str += matriz[i][j].getSimbolo(); // pega o simbolo por overwriting
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
	