package campoMinado.Celulas.CelulaSimples;

public class CelulaVazia extends CelulaAbstrata {
	
    private char simbolo;

    public CelulaVazia () {
        super();
        setSimbolo('@'); // atribui um simbolo que será utilizado
    }

    public char getSimbolo() {
        return simbolo;
    }

    private void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
