package campoMinado.ModosJogo;

import java.util.InputMismatchException;
import java.util.Scanner;

import campoMinado.ComponentesJogo.Jogador;

public class JogoSolo extends Jogo {
	public JogoSolo() {
		super();
	}
	public void Jogar(){
		inciarJogo();
        
		Jogador jogador = new Jogador("Bruno");

		Scanner scanner = new Scanner(System.in);// inicializa o scanner

		while(getFuncionamentoJogo() == true){
			System.out.println(getTabuleiro());//impressão do tabueleiro

			//entrada de dados
			int valor1,valor2,valor3;

			try {
				System.out.println("0 -> clicar celula/ 1 -> alterar bandeira");  // instruções para o console

				int modo = scanner.nextInt(); // terceiro input

				// tratamento da entrada para o valor ser valido
				if(modo < 1) 
					modo = 0;
				else if(modo == 2){
                    pararJogo();
                    scanner.close();
                    continue;
                }
                else
				    modo = 1;
				valor3 = modo;

            	System.out.print(jogador + "\nDigite a linha: "); // instruções para o console

            	valor1 = scanner.nextInt(); // primeiro input
				if (valor1 > 0 || valor1 > getTabuleiro().getTamanho()){ // verifica se entrada é valida
					System.out.println("Digite um valor valido!");
					continue;
				}
				System.out.print("Digite a coluna: ");  // instruções para o console

				valor2 = scanner.nextInt(); // Segundo input
				if (valor2 < 0 || valor2 > getTabuleiro().getTamanho()){ // verifica se entrada é valida
					System.out.println("Digite um valor valido!");
					continue;
				}

				
				super.passarRodada(); // se tudo for válido, a rodada será passada

				if((getTabuleiro().selecionar(valor1, valor2, valor3))){ // verifica se tem bomba e altera a celula
					pararJogo();
					System.out.println(jogador + "Encontrou Bomba!");
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

