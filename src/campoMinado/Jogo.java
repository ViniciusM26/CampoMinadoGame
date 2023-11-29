package campoMinado;

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
	    
	 public int tempo() {
		 return this.tempo;
	 }

	 public void Jogar(){
		setFuncionamentoJogo(true);

		Scanner scanner = new Scanner(System.in);
		int modo = 0;
		while(getFuncionamentoJogo() == true){
			System.out.println(tabuleiro);//impressão do tabueleiro
			//entrada de dados
			String entrada = scanner.nextLine();
			String[] valores = entrada.split(" ");
			int valor1 = -1;
			int valor2 = -1;
			if(valores.length == 1){
				if(modo == 0)
					modo = 1;
				else
					modo = 0;
			}else if (valores.length == 2){
				if (isInteger(valores[0]) && isInteger(valores[1])){
				valor1 = Integer.parseInt(valores[0+modo]);
				valor2 = Integer.parseInt(valores[1+modo]);
					if((tabuleiro.selecionar(valor1, valor2,modo))){
						setFuncionamentoJogo(false);
						System.out.println("Encontrou Bomba!");
						System.out.println(tabuleiro);
						scanner.close();
					};
				}
			}else{

			}
		}
	 }

	 private static boolean isInteger(String s) {
		try {
			Scanner sc = new Scanner(s);
			if (sc.hasNextInt()) {
				sc.nextInt();
				return !sc.hasNext(); // Garante que não há mais tokens
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}

