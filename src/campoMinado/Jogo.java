package campoMinado;

import java.util.Scanner;

public class Jogo {
	 private boolean funcionamentoJogo;
	 private Tabuleiro tabuleiro;
	 private int tempo;

	 public Jogo() {
		setTabuleiro(new Tabuleiro(7, 5));
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
	    
	 public int tempo() {
		 return this.tempo;
	 }
	 public void Jogar(){
		setTabuleiro(new Tabuleiro(5,5));
		setFuncionamentoJogo(true);

		Scanner scanner = new Scanner(System.in);

		while(this.funcionamentoJogo == true){
			System.out.println(tabuleiro);//impressão do tabueleiro

			//entrada de dados
			String entrada = scanner.nextLine();
			String[] valores = entrada.split(" ");
			int valor1 = Integer.parseInt(valores[0]);
			int valor2 = Integer.parseInt(valores[1]);
			
			if((tabuleiro.selecionar(valor1, valor2))){
				setFuncionamentoJogo(false);
				System.out.println("Encontrou Bomba!");
				System.out.println(tabuleiro);
				scanner.close();
			};




		}
	 }
}

