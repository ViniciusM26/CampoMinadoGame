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

	// Caso tenha uma bandeira na celula ele retira, caso não tenha ele adiciona uma bandeir

	public void clicarCelula(){
        setClicado(true);
    }

}
