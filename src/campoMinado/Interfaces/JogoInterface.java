package campoMinado.Interfaces;

import campoMinado.ModosJogo.Jogadores.Jogador;

public interface JogoInterface {

    void jogar(Jogador jogador, int row, int col);
    void alterarBandeira(int row,int col);

}