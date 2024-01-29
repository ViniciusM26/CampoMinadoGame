package campoMinado.Tabuleiros;

public class TabuleiroDificil extends Tabuleiro {

    public TabuleiroDificil(){
        super(30,99);
    }
    
    @Override
    public void inicializar(int tamanho, int bombas) {
        // Chamada para o método inicializar da superclasse, passando os valores definidos para o nível díficil
        super.inicializar(30, 99);
    }

}
