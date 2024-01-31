package campoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int rodarMenu(){

        System.out.println("Olá, escolha o modo de jogo:"); //imprime as opções na tela
        System.out.println("1 - Iniciar um jogo Solo");
        System.out.println("2 - Iniciar um jogo Multiplayer");
        System.out.println("3 - Iniciar um jogo Maluco");
        System.out.println("4 - Sair");
        Scanner scanner = new Scanner(System.in);

        try{
            int modo = scanner.nextInt();
            return modo;
        }

        catch (InputMismatchException e ) {
            	System.out.println("Erro: Certifique-se de digitar um valor inteiro válido.");
				scanner.nextLine();
                return -1;
			}

    }

    public static int rodarMenuDificuldade() {
    
        System.out.println("Escolha a dificuldade:"); //imprime as opções na tela
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        System.out.print  ("4 - Sair");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
    
        try {
            int dificuldade = scanner.nextInt();
            return dificuldade;
        } 
        
        catch (InputMismatchException e) {
                System.out.println("Erro: Certifique-se de digitar um valor inteiro válido.");
                scanner.nextLine();
                return -1;
            }
    }

}
