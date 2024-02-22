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

    public void setPontos(int pontos) {
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
    
    public String getIniciais(){
        String[] nomes = getNome().split(" ");
        StringBuilder iniciais = new StringBuilder();
        for (String nome : nomes) {
            iniciais.append(nome.charAt(0));
        }
        return iniciais.toString().toUpperCase();
    }

    public String passarRodada(){
        return "";
    }
    
    public String encontrarBomba(){
        return "";
    }
    @Override
    public String toString() {
        String str = "";
        str += getNome() + " ";
        return str;
    }
}
