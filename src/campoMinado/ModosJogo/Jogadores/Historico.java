package campoMinado.ModosJogo.Jogadores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Historico {
    private ArrayList<Jogador> jogadores;

    public Historico() {
        jogadores = new ArrayList<>();
        carregarJogadoresDoArquivo();
    }

    public void adicionarJogador(Jogador currentJogador) {
        Jogador jogadorEncontrado = null;
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(currentJogador.getNome())) {
                jogadorEncontrado = jogador;
                break;
            }
        }

        if (jogadorEncontrado != null) {
            jogadorEncontrado.setPontos(currentJogador.getPontos());
        } else {
            jogadores.add(currentJogador);
        }

        atualizarJogadores();
        atualizarArquivoRanking();
    }

    private void carregarJogadoresDoArquivo() {
        File rankingFile = new File("ranking.txt");
        if (rankingFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(rankingFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Remove espaços em branco em excesso antes de tentar converter para número
                    line = line.trim();
                    String[] parts = line.split(" - ");
                    int index = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("."))) - 1;
                    int pontos = Integer.parseInt(parts[1].substring(parts[1].lastIndexOf(":") + 1).trim());
                    Jogador jogador = new Jogador(parts[0].substring(parts[0].indexOf(".") + 1).trim());
                    jogador.setPontos(pontos);
                    jogadores.add(index, jogador);
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo de ranking: " + e.getMessage());
            }
        }
    }
    
    private void atualizarJogadores() {
        Collections.sort(jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                return Integer.compare(j2.getPontos(), j1.getPontos());
            }
        });
    }

    private void atualizarArquivoRanking() {
        try (FileWriter fw = new FileWriter("ranking.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (int i = 0; i < jogadores.size(); i++) {
                bw.write(String.format("%d. %s - Pontuação: %d\n", i + 1, jogadores.get(i).getNome(), jogadores.get(i).getPontos()));
            }
        } catch (IOException e) {
            System.err.println("Erro ao atualizar arquivo de ranking: " + e.getMessage());
        }
    }
}
