package campoMinado;

public class CelulaVizinha extends Celula {
    private int contagemBombas;
    public CelulaVizinha () {
        super.setClicado(true);
    }

    public char getSimbolo() {
        return (char)('0' + this.contagemBombas);
    }

    public int getContagemBombas(){
        return this.contagemBombas;
    }
    public void setContagemBombas(int contador){
        this.contagemBombas = contador; 
    }

    
}
