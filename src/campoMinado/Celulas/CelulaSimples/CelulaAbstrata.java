package campoMinado.Celulas.CelulaSimples;

public abstract class CelulaAbstrata {
	
	private boolean clicado;

	public CelulaAbstrata(){
		setClicado(false);
	}
	
	public boolean getClicado (){
		return this.clicado;
	}
	private void setClicado(boolean p1){
		this.clicado = p1;
	}
		
	public abstract char getSimbolo();

<<<<<<< Updated upstream
=======
	// Caso tenha uma bandeira na celula ele retira, caso não tenha ele adiciona uma bandeira

>>>>>>> Stashed changes
	public void clicarCelula(){
        setClicado(true);
    }

	

}
