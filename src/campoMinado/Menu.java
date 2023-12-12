package campoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int rodarMenu(){
        System.out.println("Olá, escolha o modo de jogo:\n1.Solo\n2.Multijogador\n3.Maluco"); //imprime as opções na tela
        Scanner scanner = new Scanner(System.in);
        // tenta fazer a entrada
        try{
            int modo = scanner.nextInt();
            return modo;
        }
        // se der erro avisa o usuario e acaba o programa
        catch (InputMismatchException e ) {
            	System.out.println("Erro: Certifique-se de digitar um valor inteiro válido.");
				scanner.nextLine();
                return -1;
			} 
    }


}
