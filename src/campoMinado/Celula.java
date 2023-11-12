package campoMinado;

import java.util.ArrayList;

public class Celula {
	
	private boolean bomba;
	private boolean revelado;
	private boolean bandeira ;
	private boolean clicado;
	
	ArrayList<Celula> vizinhos;
	
	public Celula(){
		this.bomba = false;
		this.revelado = false;
		this.bandeira = false;
		this.clicado = false;
		this.vizinhos = new ArrayList<Celula>();
	}
	
	public void adicionarVizinhos(Celula e) {
		this.vizinhos.add(e);
	}
	
	// Método de adicionar bombas no tabuleiro
	// Caso a celula já tenha uma bomba, ele retorna false
	
	public boolean bomba() {
		if (!this.bomba) {
			this.bomba = true;
			return true;
		}
		else {
			return false;
		}
	}
	
	// Caso tenha uma bandeira na celula ele retira, caso não tenha ele adiciona uma bandeira
	
	public boolean marcarBandeira() {
		this.bandeira = !this.bandeira;
		return this.bandeira;
	}
	
	// -1 --> Bomba, 0 --> Vazio e n --> num de bombas nos vizinhos
	public int clicar(){
		this.clicado = true;
		if(this.bomba) {
			return -1;
		}
		else {
			return numMinasNosVizinhos();
		}
	}	
	
	public int numMinasNosVizinhos(){
		int n = 0;
		for (Celula e : this.vizinhos) {
			if(e.bomba) n++;
		}
		return n;
	}
	
	public void reset() {
		this.bomba = false;
		this.revelado = false;
		this.bandeira = false;
		this.clicado = false;
	}
	
	public String toString() {
		if(this.bomba)
			return "-1";			
		return "+" + this.numMinasNosVizinhos();	
	}
	
	
	private int contagemBombas;
	
	public void contarBombas(int p) {
		this.contagemBombas = p;
	}
	
	public int contagemBombas() {
		return this.contagemBombas;
	}
	
	public boolean clicado() {
		return this.clicado;
	}
	public void clicarCelula() {
		this.clicado = true;
	}
	
}

/*
public Celula(boolean p1) {

	this.bomba = p1;
	this.temBandeira = false;
	this.selecionado = false;
}

public Celula() {
	this.bomba = false;
	this.temBandeira = false;
	this.selecionado = false;		
}
*/