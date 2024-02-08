package campoMinado.Celulas.CelulaMaluca;

import java.util.Random;

public class CelulaMaluca {
	
	private double grauLoucura;
	 
    public CelulaMaluca() {
        try{
            setGrauLoucura(0.8);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public double getGrauLoucura() {
        return grauLoucura;
    }

    public void setGrauLoucura(double grauLoucura) {
        if (grauLoucura >= 1 || grauLoucura < 0) // garante que o grau de loucura esteja entre 1 e 0
            throw new IllegalArgumentException("Erro: grau de loucura inválido");
        this.grauLoucura = grauLoucura;
    }

    public boolean clicarCelula(){
		Random rand = new Random(); // inicializa o random
        double aleatorio = rand.nextDouble(); // gera um aleatorio double
        // tranformação para um valor entre 0 e 1
        while(aleatorio > 1){ 
            aleatorio = aleatorio/10;
        }
        if (aleatorio > grauLoucura)
            return false;
        else
            return true;
    }
}
