package campoMinado.Exceptions;

public class InputException extends Exception {
	
    public InputException(String message){
        super(message);
    }
    
    public InputException(){
        super("Erro: Input inválido");
    }
}

