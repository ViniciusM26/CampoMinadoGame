package campoMinado.Tabuleiros;

public class TabuleiroFacil extends Tabuleiro {
    
    public TabuleiroFacil() {
        super(9, 10); // tamanho 9x9 e 10 bombas
    }

    @Override
    public void inicializar(int tamanho, int bombas) {
        // Chamada para o método inicializar da superclasse, passando os valores definidos para o nível fácil
        super.inicializar(9, 10);
    }
    
}
