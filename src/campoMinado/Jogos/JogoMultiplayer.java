package campoMinado.Jogos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoMultiplayer extends Jogo {
	public JogoMultiplayer() {
		super();
	}


	public void Jogar(Jogador jogador1, Jogador jogador2){
		inciarJogo();
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
				
            	System.out.print(jogadorDaRodada + "\nDigite a linha: "); // instruções para o console

            	valor1 = scanner.nextInt(); // primeiro input
				if (valor1 > 0 || valor1 > getTabuleiro().getTamanho()){ // verifica se entrada é valida
					System.out.println("perdeu sua vez! Digite um valor valido!");
					continue;
				}
				System.out.print("Digite a coluna: ");  // instruções para o console

				valor2 = scanner.nextInt(); // Segundo input
				if (valor2 < 0 || valor2 > getTabuleiro().getTamanho()){ // verifica se entrada é valida
					System.out.println("perdeu sua vez! Digite um valor valido!");
					continue;
				}

				System.out.println("0 -> clicar celula/ 1 -> alterar bandeira");  // instruções para o console

				int modo = scanner.nextInt(); // terceiro input

				// tratamento da entrada para o valor ser valido
				if(modo < 1) 
					modo = 0;
				else
					modo = 1;
				valor3 = modo;

				super.passarRodada(); // se tudo for válido, a rodada será passada

				if((getTabuleiro().selecionar(valor1, valor2, valor3))){ // verifica se tem bomba e altera a celula
					pararJogo();
					System.out.println(jogadorDaRodada + "Encontrou Bomba!");
					System.out.println(getTabuleiro());
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

