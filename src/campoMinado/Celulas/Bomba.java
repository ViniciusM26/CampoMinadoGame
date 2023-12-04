package campoMinado.Celulas;

public class Bomba extends Celula {
    private char simbolo;

    public Bomba () {
        super();
        setSimbolo('°'); // atribui o simbolo que será impresso
    }

    public char getSimbolo() {
        return simbolo;
    }

    private void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
