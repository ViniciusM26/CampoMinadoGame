package campoMinado;

public class Celula {
	
	private boolean bomba;
	private boolean temBandeira ;
	private boolean selecionado;
	private int contagemBombas;
	
	public void contarBombas(int p) {
		this.contagemBombas = p;
	}
	
	public int contagemBombas() {
		return this.contagemBombas;
	}
	
	public boolean bomba() {
		return this.bomba;
	}
	
	public boolean bandeira() {
		return this.temBandeira;
	}
	
	public boolean selecionado() {
		return this.selecionado;
	}
	public void selecionarCelula() {
		this.selecionado = true;
	}
	public void selecionarBandeira() {
		this.temBandeira = true;
	}
	public void retirarBandeira() {
		this.temBandeira = false;
	}
	
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
	
}
