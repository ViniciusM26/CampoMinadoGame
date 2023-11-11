package campoMinado;

public class Tabuleiro {
	private int tamanho;
	private Celula[][] matriz;
	private int bandeiras;
	private int selecionados;
	private int bombas;
	
	public int bombas() {
		return this.bombas;
	}
	
	public int selecionados() {
		return this.selecionados;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	public int bandeiras() {
		return this.bandeiras;
	}
	
	public void colocarBandeira(int x, int y) {
		if(this.bandeiras > 0) {
			if (!(this.matriz[x][y].temBandeira)) {
				this.matriz[x][y].selecionarBandeira();
				this.bandeiras --;
			}
		}	
	}
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
	
	public int contagemBombas(int x, int y){
		int contador = 0;
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
							if(matriz[x + i][y + j].bomba()) {
								contador++;
							};
						}
					}	
				}
			}
		}

		return contador;
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
    }
}