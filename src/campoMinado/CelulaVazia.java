package campoMinado;

public class CelulaVazia extends Celula {
    private int contagemBombas;

    public int getContagemBombas(){
        return this.contagemBombas;
    }
    public void setContagemBombas(int contador){
        this.contagemBombas = contador; 
    }
    
}
