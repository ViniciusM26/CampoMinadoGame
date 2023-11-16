package campoMinado;

import java.util.ArrayList;

public class Celula {
	
	private boolean revelado;
	private boolean bandeira ;
	private boolean clicado;

	public boolean getrevelado (){
		return this.revelado;
	}
	public boolean getbandeira (){
		return this.bandeira;
	}
	public boolean getclicado (){
		return this.clicado;
	}

	ArrayList<Celula> vizinhos;
	
	public Celula(){
		this.revelado = false;
		this.bandeira = false;
		this.clicado = false;
	}
	
	public void adicionarVizinhos(Celula e) {
		this.vizinhos.add(e);
	}
	
	// Caso tenha uma bandeira na celula ele retira, caso não tenha ele adiciona uma bandeira
	
	public boolean marcarBandeira() {
		this.bandeira = !this.bandeira;
		return this.bandeira;
	}
	
	// -1 --> Bomba, 0 --> Vazio e n --> num de bombas nos vizinhos
	//Verificar como applicar na ideia de subClasse
	/*
	public int clicar(){
		this.clicado = true;
		if(this.bomba) {
			return -1;
		}
		else {
			return numMinasNosVizinhos();
		}
	}	
	 */

	//Ver como aplicar tirando a ideia de bomba da celula e levando em consideração apenas o tipo
	/*
	public int numMinasNosVizinhos(){
		int n = 0;
		for (Celula e : this.vizinhos) {
			if(e.bomba) n++;
		}
		return n;
	}
	 */

	public void reset() {
		this.revelado = false;
		this.bandeira = false;
		this.clicado = false;
	}
	
	public boolean clicado() {
		return this.clicado;
	}
	public void clicarCelula() {
		this.clicado = true;
	}
	
}
