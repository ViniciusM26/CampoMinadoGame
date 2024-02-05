package campoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;

import campoMinado.Exceptions.MenuInputException;

public class Menu {

    public static int rodarMenu() throws MenuInputException{
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
