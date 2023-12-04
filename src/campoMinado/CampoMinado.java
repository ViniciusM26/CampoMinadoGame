package campoMinado;

public class CampoMinado {

	public static void main(String[] args) {
		// criar os jogadores
		Jogador bruno = new Jogador("Bruno");
		Jogador lumiar = new Jogador("Lumiar");
		Jogo jogo = new Jogo(); // função que cria o objeto jogo
		jogo.Jogar(bruno,lumiar); // função que joga

	}

}
