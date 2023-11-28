package campoMinado;

public class Celula {
	
	private boolean bandeira;
	private boolean clicado;

	public Celula(){
		this.bandeira = false;
		this.clicado = false;
	}
	
	public boolean getBandeira (){
		return this.bandeira;
	}
	public void setBandeira(boolean p1){
		this.bandeira = p1;
	}
	public boolean getClicado (){
		return this.clicado;
	}
	public void setClicado(boolean p1){
		this.clicado = p1;
	}
		
	public char getSimbolo(){// será subescrito nas subClasses
		return ' ';
	}

	// Caso tenha uma bandeira na celula ele retira, caso não tenha ele adiciona uma bandeira
	public void selecionarBandeira(){
		if (getBandeira() == true){
			setBandeira(false);
		}else{
			setBandeira(true);
		}
	}

	public void clicarCelula(){
        if (getBandeira() == false && getClicado() == false){
            setClicado(true);
        }
    }

	public void reset() {
		setBandeira(false);
		setClicado(false);
	}
}
