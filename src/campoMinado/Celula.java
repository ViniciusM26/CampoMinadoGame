package campoMinado;

public class Celula {
	
	private boolean bandeira;
	private boolean clicado;

	public boolean getBandeira (){
		return this.bandeira;
	}
	public char getSimbolo(){
		return ' ';
	}

	public boolean getClicado (){
		return this.clicado;
	}

	public void setBandeira(boolean p1){
		this.bandeira = p1;
	}

	public void setClicado(boolean p1){
		this.clicado = p1;
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
}
