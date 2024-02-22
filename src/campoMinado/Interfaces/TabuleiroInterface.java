package campoMinado.Interfaces;

public interface TabuleiroInterface {

    void inicializar(int tamanho, int bombas);
    boolean clicarCelula(int x, int y);
    void clicarBandeira(int x, int y);
    boolean selecionar(int x, int y);
    String toString();
    
}

