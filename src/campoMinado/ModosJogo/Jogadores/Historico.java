package campoMinado.ModosJogo.Jogadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Historico {
	
    private ArrayList<Jogador> jogadores;

    public Historico() {
        jogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
        Collections.sort(jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                return Integer.compare(j2.getPontos(), j1.getPontos());
            }
        });
    }

    public void imprimir() {
        System.out.println("Histórico de Jogadores:");
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.printf("%d. %s", i + 1, jogadores.get(i).getNome());
            System.out.printf(" - Pontuação: %d\n", jogadores.get(i).getPontos());
        }
    }
}
