package campoMinado;

import java.util.Scanner;

public class teste {
    // Função para verificar se uma string pode ser convertida para um número inteiro usando Scanner
    public static boolean isInteger(String s) {
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
