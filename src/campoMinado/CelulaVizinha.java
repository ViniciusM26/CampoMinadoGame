package campoMinado;

public class CelulaVizinha extends Celula {

    private int contagemBombas;
    public CelulaVizinha (int contagemBombas) {
        super();
        setContagemBombas(contagemBombas);
        super.setClicado(false);
    }

    public char getSimbolo() {
        return (char)('0' + this.contagemBombas);
    }

    public int getContagemBombas(){
        return this.contagemBombas;
    }
    public void setContagemBombas(int contador){
        if(contador > 0)
        this.contagemBombas = contador; 
    }
   
}
