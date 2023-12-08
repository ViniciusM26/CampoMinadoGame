package campoMinado.Celulas.CelulaSimples;

public class Bomba extends CelulaAbstrata {
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
