package campoMinado.ModosJogo;

import java.util.Scanner;
import java.util.InputMismatchException;


import campoMinado.ComponentesJogo.Tabuleiro;
import campoMinado.ModosJogo.Jogadores.Jogador;

public class Jogo {
    private boolean funcionamentoJogo;
	private Tabuleiro tabuleiro;
	private int rodadas;

    public Jogo(){
		setTabuleiro(new Tabuleiro(7,7));
    }

    public void Jogar(){

    }

    public int getRodadas() {
		return rodadas;
	}

	private void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}
	
    public boolean getFuncionamentoJogo() {
        return this.funcionamentoJogo;
    }

    private void setFuncionamentoJogo(boolean p1){
       this.funcionamentoJogo = p1;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    private void setTabuleiro(Tabuleiro p1){
        this.tabuleiro = p1;
    }

    protected void passarRodada(){ // função que vai alterar diretamente as rodadas
        setRodadas(getRodadas() + 1);
    }

    public void inciarJogo(){ // função que inicia o jogo
		setFuncionamentoJogo(true);
		setRodadas(0);
	}

	public void pararJogo(){ // função que para o jogo
		setFuncionamentoJogo(false);
	}

    protected void rodadaPadrao(Jogador jogador){
        
        Scanner scanner = new Scanner(System.in);// inicializa o scanner

        System.out.println(getTabuleiro());//impressão do tabueleiro
        
        //entrada de dados
        int x,y,modo;
        
        try {
            System.out.println(jogador+"\n0 -> clicar celula/ 1 -> alterar bandeira/ 2 -> acabar o jogo");  // instruções para o console

            modo = scanner.nextInt(); // terceiro input

            // tratamento da entrada para o valor ser valido
            if(modo < 1) 
                modo = 0;
            else if (modo > 1){
                pararJogo();
                scanner.close();
                return;
            }else
                modo = 1;
            
            System.out.print("\nDigite a linha: "); // instruções para o console

            x = scanner.nextInt(); // primeiro input
            if (x < 0 || x > getTabuleiro().getTamanho()){ // verifica se entrada é valida
                System.out.println("Digite um valor valido!");
                return;
            }
            System.out.print("Digite a coluna: ");  // instruções para o console

            y = scanner.nextInt(); // Segundo input
            if (y < 0 || y > getTabuleiro().getTamanho()){ // verifica se entrada é valida
                System.out.println("Digite um valor valido!");
                return;
            }
            
            if (getRodadas() == (getTabuleiro().getTamanho() ^ 2)){
                pararJogo();
            }
            if(getTabuleiro().getMatriz()[x][y] == null || !(getTabuleiro().getMatriz()[x][y].getClicado())){
                if((getTabuleiro().selecionar(x, y, modo))){ // verifica se tem bomba e altera a celula
                    System.out.println(jogador + jogador.encontrarBomba());// imprime e retira os pontos
                }else{
                    System.out.println(jogador + jogador.passarRodada()); // imprime e coloca os pontos
                }
                passarRodada();
            }
            else 
                System.out.println("celula ja selecionada");
            

        } catch (InputMismatchException e ) {
            System.out.println("Erro: Certifique-se de digitar um valor inteiro válido.");
            scanner.nextLine();
            return;
        } 
    } 
}