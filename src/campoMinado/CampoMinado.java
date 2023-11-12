package campoMinado;

public class CampoMinado {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.sortearBombas();
		System.out.println(tabuleiro);
	}

}
