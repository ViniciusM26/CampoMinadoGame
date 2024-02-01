package campoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;

import campoMinado.Exceptions.MenuInputException;

public class Menu {

    public static int rodarMenu() throws MenuInputException{
        System.out.println("Olá, escolha o modo de jogo:\n1.Solo\n2.Multijogador\n3.Maluco"); // imprime as opções na tela
        Scanner scanner = new Scanner(System.in);

        // tenta fazer a entrada
        try {
            int modo = scanner.nextInt();
            if(modo > 3 || modo < 0) throw new MenuInputException();
            return modo;
        } catch (InputMismatchException e) {
            throw new MenuInputException();
        }
        finally{
            scanner.nextLine(); // Limpa o buffer do scanner
        }
    }
}
