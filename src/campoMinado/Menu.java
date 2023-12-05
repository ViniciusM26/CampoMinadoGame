package campoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int rodarMenu(){
        System.out.println("Olá, escolha o modo de jogo:\n1.Solo\n2.Multijogador");
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


}
