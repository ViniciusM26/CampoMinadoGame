package campoMinado;

public class Celula {
	
	protected boolean bandeira;
	protected boolean clicado;

	public boolean getBandeira (){
		return this.bandeira;
	}

	public boolean getClicado (){
		return this.clicado;
	}

	public void setBandeira(boolean p1){
		this.bandeira = p1;
	}

	public void setClicado(boolean p1){
		this.bandeira = p1;
	}

	// Caso tenha uma bandeira na celula ele retira, caso não tenha ele adiciona uma bandeira
	public void selecionarBandeira(){
		if (this.bandeira == true){
			this.bandeira = false;
		}else{
			this.bandeira = true;
		}
	}

	public void clicarCelula(){
        if (this.bandeira == false || this.clicado == false){
            this.clicado = true;
        }
    }

	public void reset() {
		this.bandeira = false;
		this.clicado = false;
	}

	public Celula(){
		this.bandeira = false;
		this.clicado = false;
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

	
	
	
}

	/*
	public void colocarBanderia (){
		this.bandeira = bandeira;
	}
	public void tirarBanderia (){
		this.bandeira = bandeira;
	}
	public void clicar (){
		this.clicado = clicado;
	}
	 */
	/*
	public void adicionarVizinhos(Celula e) {
		this.vizinhos.add(e);
	}
	ArrayList<Celula> vizinhos; // ajeitar
	 */
