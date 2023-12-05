package campoMinado.ModosJogo;

import java.util.InputMismatchException;
import java.util.Scanner;

import campoMinado.ComponentesJogo.Jogador;

public class JogoMultiplayer extends Jogo {
	public JogoMultiplayer() {
		super();
	}


	public void Jogar(){
		inciarJogo();
		Jogador jogador1 = new Jogador("Bruno");
		Jogador jogador2 = new Jogador("Lumiar");

		Scanner scanner = new Scanner(System.in);// inicializa o scanner

		Jogador jogadorDaRodada; // cria uma referencia ao jogador da rodada

		while(getFuncionamentoJogo() == true){
			System.out.println(getTabuleiro());//impressão do tabueleiro
			if (getRodadas() % 2 == 1) // escolhe qual será o jogador da rodada
				jogadorDaRodada = jogador1;
			else
				jogadorDaRodada = jogador2;
			//entrada de dados
			int valor1,valor2,valor3;
			
			try {
				System.out.println("0 -> clicar celula/ 1 -> alterar bandeira/ 2 -> acabar o jogo");  // instruções para o console

				int modo = scanner.nextInt(); // terceiro input

				// tratamento da entrada para o valor ser valido
				if(modo < 1) 
					modo = 0;
				else if (modo > 1){
					pararJogo();
                    scanner.close();
                    continue;
				}else
					modo = 1;

				valor3 = modo;
				
            	System.out.print(jogadorDaRodada + "\nDigite a linha: "); // instruções para o console

            	valor1 = scanner.nextInt(); // primeiro input
				if (valor1 < 0 || valor1 > getTabuleiro().getTamanho()){ // verifica se entrada é valida
					System.out.println("perdeu sua vez! Digite um valor valido!");
					continue;
				}
				System.out.print("Digite a coluna: ");  // instruções para o console

				valor2 = scanner.nextInt(); // Segundo input
				if (valor2 < 0 || valor2 > getTabuleiro().getTamanho()){ // verifica se entrada é valida
					System.out.println("perdeu sua vez! Digite um valor valido!");
					continue;
				}

				super.passarRodada(); // se tudo for válido, a rodada será passada
				if (getRodadas() == (getTabuleiro().getTamanho() ^ 2)){
					pararJogo();
				}
				if((getTabuleiro().selecionar(valor1, valor2, valor3))){ // verifica se tem bomba e altera a celula
					jogadorDaRodada.encontrarBomba();
					System.out.println(jogadorDaRodada + "Encontrou Bomba! (- 3 pontos)");
				}else{
					jogadorDaRodada.passarRodada();
					System.out.println(jogadorDaRodada + "não achou bombas (+ 1 ponto)");
				}

				System.out.println("pontuação de " + jogadorDaRodada + jogadorDaRodada.getPontos());
       	 	} catch (InputMismatchException e ) {
            	System.out.println("Erro: Certifique-se de digitar um valor inteiro válido.");
				scanner.nextLine();
				continue;
			} 
		}
	}	
}

