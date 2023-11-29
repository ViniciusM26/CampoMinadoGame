package campoMinado;

public class CelulaVazia extends Celula {
    private char simbolo;

    public CelulaVazia () {
        super();
        setSimbolo('@');
        super.setClicado(false);
    }

    public char getSimbolo() {
        return simbolo;
    }

    private void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
