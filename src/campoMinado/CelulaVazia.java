package campoMinado;

public class CelulaVazia extends Celula {
    private char simbolo;

    public CelulaVazia () {
        this.simbolo = '@';
        super.setClicado(true);
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
