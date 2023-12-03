package campoMinado;

public class CampoMinado {

	public static void main(String[] args) {
		Jogador bruno = new Jogador("Bruno");
		Jogador lumiar = new Jogador("Lumiar");
		Jogo jogo = new Jogo();
		jogo.Jogar(bruno,lumiar);

	}

}
