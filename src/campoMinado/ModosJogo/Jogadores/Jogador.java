package campoMinado.ModosJogo.Jogadores;

public class Jogador {
    private String nome;
    private int pontos;
    private boolean jogando;

    public Jogador(String nome){
        setJogando(true);
        setNome(nome);
        setPontos(0);
    }

    public boolean isJogando() { // função que retorna o estado do jogador
        return jogando;
    }

    protected void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

    public int getPontos() {
        return pontos;
    }

    protected void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public void eliminado(){ // função que altera o estado do jogador
        setJogando(false);
    }

    public String passarRodada(){
        return "";
    }
    
    public String encontrarBomba(){
        return "";
        //setPontos(getPontos() - 3);
    }
    @Override
    public String toString() {
        String str = "";
        str += getNome() + " ";
        return str;
    }
}
