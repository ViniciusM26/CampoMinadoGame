package campoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
	private boolean funcionamentoJogo;
	private Tabuleiro tabuleiro;
	private int tempo;

	public Jogo() {
		setTabuleiro(new Tabuleiro(7,1));
		 this.tempo = 0;
	}
	    
	 public boolean getFuncionamentoJogo() {
		 return this.funcionamentoJogo;
	}
	 public void setFuncionamentoJogo(boolean p1){
		this.funcionamentoJogo = p1;
	}
	    
	 public Tabuleiro getTabuleiro() {
		 return this.tabuleiro;
	}
	 public void setTabuleiro(Tabuleiro p1){
		this.tabuleiro = p1;
	}
	    
	public int getTempo() {
		 return this.tempo;
	}

	public void setTempo(int tempo){
		this.tempo = tempo;
	}
	public void inciarJogo(){
		setFuncionamentoJogo(true);
	}
	public void pararJogo(){
		setFuncionamentoJogo(false);
	}

	public void Jogar(){
		inciarJogo();

		Scanner scanner = new Scanner(System.in);
		int modo = 0;
		while(getFuncionamentoJogo() == true){
			System.out.println(tabuleiro);//impressão do tabueleiro
			//entrada de dados
			int valor1,valor2,valor3;
			
			try {
            	System.out.print("Digite a linha: ");
            	valor1 = scanner.nextInt();
				System.out.println("Digite a coluna");
				valor2 = scanner.nextInt();
				System.out.println("0 -> clicar celula/ 1 -> alterar bandeira");
				int x = scanner.nextInt();
				if(x < 1) // trata a entrada para o valor ser valido
					x = 0;
				else
					x = 1;
				valor3 = x; 
       	 	} catch (InputMismatchException e ) {
            	System.out.println("Erro: Certifique-se de digitar um valor inteiro válido.");
				valor1 = valor2 = -1;
				break;
			} 
			if((tabuleiro.selecionar(valor1, valor2, valor3))){ // verifica se tem bomba e altera a celula
				pararJogo();
				System.out.println("Encontrou Bomba!");
				System.out.println(tabuleiro);
				scanner.close();
			};
			}
	}	
}

