package campoMinado;

import java.util.Random;

public class Tabuleiro {
	
	private Celula [][] matriz; //Duvida a respeito das subClasses
	private int tamanho ;
	private int bombas;

	 public int getTamanho(){
		return this.tamanho;
	 }
	 public int getBombas(){
		return this.bombas;
	 }

	public String toString() {
		String str = "";
		
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (matriz[i][j] instanceof Bomba)
				str += "# ";
				else 
				str += "* ";
			}
			str += "\n";
		}
		return str;
	}	

	public void contagemBombas(int x, int y){
	int contador = 0;
	CelulaVazia celulaVazia = (CelulaVazia)matriz[x][y];
	// Percorre em x nas 3 posições
	for(int i = -1;i < 2;  i++) {
		//verifica se a soma não será uma posição negativa
		if (x + i >= 0) {
			//percorre em y nas 3 posições
			for (int j = -1; j < 2; j++) {
				//verifica se a soma não será uma posição negativa
				if (y + j >= 0) {
					// verifica se a posição analisada não é a propia celula
					if(i != 0 || j != 0) {
						if(matriz[x + i][y + j] instanceof Bomba) {
							contador++;
						};
					}
				}	
			}
		}
	}
	celulaVazia.setContagemBombas(contador);
}

	public boolean selecionar(int x, int y){
		this.matriz[x][y].clicarCelula();
		if (this.matriz[x][y] instanceof Bomba)// verifica se é bomba
			return true;
		else{ // não é bomba
			contagemBombas(x, y);// resolver a questão do acesso as funções
			return false;
		}
	}
	//ver como mudar para herança
	
	public void iniciarCelulas() {
		Random rand = new Random();
		
		for (int i = 0; i < this.bombas; i++) {
			int l = rand.nextInt(tamanho);
			int c = rand.nextInt(tamanho);
	
			// Verifica se a célula na posição é nula
			if (matriz[l][c] == null) {
				matriz[l][c] = new Bomba();
			} else {
				i--;
			}
		}
	
		// Preencher o restante da matriz com CelulaVazia
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (matriz[i][j] == null) {
					matriz[i][j] = new CelulaVazia();
				}
			}
		}
	}

	public Tabuleiro() {
		this.tamanho = 6;
		this.bombas = 5;
	    matriz = new Celula[tamanho][tamanho];
	}
	
	//mudar para funcionar
	 /*
	public void colocarBandeira(int x, int y) {
		if (!(this.matriz[x][y].getBandeira())) {
			this.matriz[x][y].selecionarBandeira();
			this.bandeiras --;
		}
	}	

	 */
}
	
/*	



public void retirarBandeira(int x, int y) {
	if(this.matriz[x][y].bandeira()) {
		this.matriz[x][y].retirarBandeira();
		this.bandeiras ++;
	}
}
public boolean selecionar(int x, int y) {
if (!(this.matriz[x][y].selecionado)) {
	this.matriz[x][y].selecionarCelula();
	
	if (this.matriz[x][y].bomba) {
		return false;
	}else {
		this.matriz[x][y].contarBombas(contagemBombas(x,y));
		return true;
	}
}
	return true;
}

public void imprimir() {
	for (int j = 0; j < tamanho; j++) {
    	for (int i = 0; i < tamanho; i++) {
    		if (matriz[j][i].selecionado()) {
    			System.out.print(this.matriz[i][j].contagemBombas);
    		}else {
    			System.out.print('@');
    		}
    		System.out.print(" ");
    	}
    	System.out.println();
    }
}


public void selecionar() {
	this.selecionados ++;
}

public Tabuleiro(int tamanho, int bandeiras, int bombas) {
	this.tamanho = tamanho;
	this.bombas = bombas;
	this.bandeiras = bandeiras;
	this.matriz = new Celula [tamanho][tamanho];
	
    for (int j = 0; j < tamanho; j++) {
    	for (int i = 0; i < tamanho; i++) {
    		matriz[j][i] = new Celula();
    	}
    }
}*/