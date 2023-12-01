package campoMinado;

public class Bomba extends Celula {
    private char simbolo;

    public Bomba () {
        super();
        setSimbolo('°');
    }

    public char getSimbolo() {
        return simbolo;
    }

    private void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
