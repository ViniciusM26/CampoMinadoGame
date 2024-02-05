package campoMinado.ModosJogo;

import java.util.Scanner;
import java.util.InputMismatchException;

import campoMinado.Celulas.CelulaSimples.CelulaAbstrata;
import campoMinado.ModosJogo.Jogadores.Jogador;
import campoMinado.Tabuleiros.Tabuleiro;
import campoMinado.Exceptions.InputException;

public abstract class Jogo {
	
    private boolean funcionamentoJogo;
	private Tabuleiro tabuleiro;
	private int rodadas;

    public Jogo (Tabuleiro tabuleiro){
        setTabuleiro(tabuleiro);
    }

    public abstract void Jogar();

    public int getRodadas() {
		return rodadas;
	}

	private void setRodadas(int rodadas) {
		if (rodadas >= 0)
            this.rodadas = rodadas;
        else throw new IllegalArgumentException("Numero de rodadas invalida");
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

    protected void setTabuleiro(Tabuleiro p1){
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

    protected void rodadaPadrao  (Jogador jogador) throws InputException{
        
        Scanner scanner = new Scanner(System.in);// inicializa o scanner

        System.out.println(getTabuleiro());//impressão do tabueleiro
        
        //entrada de dados
        int x,y,modo;
        
        try {
            System.out.println(jogador+"\n0 -> clicar celula/ 1 -> alterar bandeira/ 2 -> acabar o jogo");  // instruções para o console
            modo = scanner.nextInt(); // terceiro input

            // tratamento da entrada para o valor ser valido
            if(modo < 0 || modo > 2) 
                throw new InputException();
            else if (modo == 2){
                pararJogo();
                scanner.close();
                return;
            }
            
            System.out.print("\nDigite a linha: "); // instruções para o console

            x = scanner.nextInt(); // primeiro input
            if (x < 0 || x > getTabuleiro().getTamanho()){ // verifica se entrada é valida
                throw new InputException();
            }
            System.out.print("Digite a coluna: ");  // instruções para o console

            y = scanner.nextInt(); // Segundo input
            if (y < 0 || y > getTabuleiro().getTamanho()){ // verifica se entrada é valida
                throw new InputException();
            }
            //obs: testar de maneira pratica!
            if (getRodadas() == (getTabuleiro().getTamanho() ^ 2)){ // finaliza todos os espaços do tabuleiro
                pararJogo();
            }

            CelulaAbstrata celulaSimples = getTabuleiro().getMatriz()[x][y].getCelulaSimples();  // separa a celula normal da maluca
            
            if(celulaSimples == null || !(celulaSimples.getClicado())){
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
            throw new InputException();
        } 
    } 
}
