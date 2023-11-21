package campoMinado;

public class Bomba extends Celula {
    private char simbolo;

    public Bomba () {
        this.simbolo = '!';
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
