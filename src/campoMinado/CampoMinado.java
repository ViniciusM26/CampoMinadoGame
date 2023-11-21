package campoMinado;

public class CampoMinado {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciarCelulas();
		tabuleiro.selecionar(0, 0);
		System.out.println(tabuleiro);

	}

}
