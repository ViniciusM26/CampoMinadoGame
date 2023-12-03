package campoMinado.Celulas;

public class Celula {
	
	private boolean clicado;

	public Celula(){
		setClicado(false);
	}
	
	public boolean getClicado (){
		return this.clicado;
	}
	private void setClicado(boolean p1){
		this.clicado = p1;
	}
		
	public char getSimbolo(){// será subescrito nas subClasses
		return ' ';
	}

	// Caso tenha uma bandeira na celula ele retira, caso não tenha ele adiciona uma bandeir

	public void clicarCelula(){
        if (getClicado() == false){
            setClicado(true);
        }
    }

}
