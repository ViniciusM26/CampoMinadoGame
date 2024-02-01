package campoMinado.Exceptions;

public class MenuInputException extends Exception{
    public MenuInputException(String message){
        super(message);
    }
    public MenuInputException(){
        super("Erro: Certifique-se de digitar um valor inteiro válido.");
    }
}
