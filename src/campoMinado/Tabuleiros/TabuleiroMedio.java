package campoMinado.Tabuleiros;

public class TabuleiroMedio extends Tabuleiro {
    
    public TabuleiroMedio(){
        super(2);
    }

    @Override
    public void inicializar(int tamanho, int bombas) {
        // Chamada para o método inicializar da superclasse, passando os valores definidos para o nível médio
        super.inicializar(16, 40);
    }

}
