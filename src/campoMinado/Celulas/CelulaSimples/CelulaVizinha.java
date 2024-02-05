package campoMinado.Celulas.CelulaSimples;

public class CelulaVizinha extends CelulaAbstrata {

    private int contagemBombas;
    public CelulaVizinha (int contagemBombas) {
        super();
        setContagemBombas(contagemBombas);
    }

    public char getSimbolo() {
        return (char)('0' + this.contagemBombas);
    }

    public int getContagemBombas(){
        return this.contagemBombas;
    }

    public void setContagemBombas(int contador){
        if(contador >= 0 && contador < 9) // verifica se a entrada é válida
            this.contagemBombas = contador;
        else
            throw new IllegalArgumentException("Erro: Contagem inválida");
    }
   
}
