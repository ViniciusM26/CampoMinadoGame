package campoMinado;

public class CelulaVizinha extends Celula {
    private int contagemBombas;
    private char simbolo;
    public CelulaVizinha () {
        this.simbolo = (char) this.contagemBombas;
        super.setClicado(true);
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public int getContagemBombas(){
        return this.contagemBombas;
    }
    public void setContagemBombas(int contador){
        this.contagemBombas = contador; 
    }

    
}
