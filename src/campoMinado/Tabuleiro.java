package campoMinado;

import java.util.Random;

public class Tabuleiro {
	
	private Celula [][] matriz; //Duvida a respeito das subClasses
	private int tamanho ;
	private int bombas;

	public Tabuleiro(int tamanho,int bombas) {
		setTamanho(tamanho);
		setBombas(bombas);

	    matriz = new Celula[tamanho][tamanho];
		iniciarCelulas();

	}

	 public int getTamanho(){
		return this.tamanho;
	 }
	 public void setTamanho(int p1){
		this.tamanho = p1;
	 }
	 public int getBombas(){
		return this.bombas;
	 }
	 public void setBombas(int p1){
		this.bombas = p1;
	 }

	public String toString() {
		String str = "";
		
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (matriz[i][j] == null || matriz[i][j].getClicado() == false){
					str += "# ";
				}
					else{
						str += matriz[i][j].getSimbolo();
						str += " ";
					}
				}
				str += "\n";
			}
			return str;
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

	public boolean selecionar(int x, int y) {
		if (x >= 0 && y >= 0 && y < getTamanho() && x < getTamanho()){
			//verifica se não é nulo ou é bomba
			if (!(this.matriz[x][y] == null) && this.matriz[x][y] instanceof Bomba) { 
				matriz[x][y].setClicado(true);
				return true; // retorna verdadeiro se tem bomba
			} else {
				if (matriz[x][y] == null) { // Verifica se já foi selecionado
					int bombasAoRedor = contagemBombas(x, y);
					if (bombasAoRedor > 0) {
						matriz[x][y] = new CelulaVizinha(contagemBombas(x, y));
					} else {
						matriz[x][y] = new CelulaVazia();
						for (int i = -1; i < 2; i ++){
							for(int j = -1; j < 2; j++){
								selecionar(x+i,y+j);
							}
						}
					}
				}
				return false; // retorna falso se tem bomba
			}
		}
		return false;//retorna falso por ser um lugar invalido
	}	
	private void iniciarCelulas() {
		Random rand = new Random();
		
		for (int i = 0; i < getBombas(); i++) {
			int l = rand.nextInt(tamanho);
			int c = rand.nextInt(tamanho);
	
			// Verifica se a célula na posição é nula
			if (matriz[l][c] == null) {
				matriz[l][c] = new Bomba();
			} else {
				i--;
			}
		}
	}	
}
	