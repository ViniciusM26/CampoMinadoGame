package campoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
	private boolean funcionamentoJogo;
	private Tabuleiro tabuleiro;
	private int rodadas;

	public Jogo() {
		setTabuleiro(new Tabuleiro(7,7));
	}

	public int getRodadas() {
		return rodadas;
	}

	private void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}

	private void passarRodada(){
		setRodadas(getRodadas() + 1);
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
	    
	public void inciarJogo(){
		setFuncionamentoJogo(true);
		setRodadas(0);
	}

	public void pararJogo(){
		setFuncionamentoJogo(false);
	}

	public void Jogar(Jogador jogador1, Jogador jogador2){
		inciarJogo();
		Scanner scanner = new Scanner(System.in);// inicializa o scanner
		Jogador jogadorDaRodada;
		while(getFuncionamentoJogo() == true){
			passarRodada();
			System.out.println(tabuleiro);//impressão do tabueleiro
			if (getRodadas() % 2 == 1)
				jogadorDaRodada = jogador1;
			else
				jogadorDaRodada = jogador2;
			//entrada de dados
			int valor1,valor2,valor3;
			
			try {
				
            	System.out.print(jogadorDaRodada + "\nDigite a linha: ");
            	valor1 = scanner.nextInt();
				if (valor1 > 0 || valor1 > tabuleiro.getTamanho()){ // verifica se entrada é valida
					System.out.println("perdeu sua vez! Digite um valor valido!");
					continue;
				}
				System.out.print("Digite a coluna: ");
				valor2 = scanner.nextInt();
				if (valor2 < 0 || valor2 > tabuleiro.getTamanho()){ // verifica se entrada é valida
					System.out.println("perdeu sua vez! Digite um valor valido!");
					continue;
				}
				System.out.println("0 -> clicar celula/ 1 -> alterar bandeira");
				int modo = scanner.nextInt();
				if(modo < 1) // trata a entrada para o valor ser valido
					modo = 0;
				else
					modo = 1;
				valor3 = modo; 

				if((tabuleiro.selecionar(valor1, valor2, valor3))){ // verifica se tem bomba e altera a celula
					pararJogo();
					System.out.println(jogadorDaRodada + "Encontrou Bomba!");
					System.out.println(tabuleiro);
					scanner.close();
				}
       	 	} catch (InputMismatchException e ) {
            	System.out.println("Erro: Certifique-se de digitar um valor inteiro válido.");
				scanner.nextLine();
				continue;
			} 
		}
	}	
}

