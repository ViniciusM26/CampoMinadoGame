package campoMinado.Celulas;

import campoMinado.Celulas.CelulaMaluca.CelulaMaluca;
import campoMinado.Celulas.CelulaSimples.Bomba;
import campoMinado.Celulas.CelulaSimples.CelulaAbstrata;

<<<<<<< Updated upstream
public class Celula {
	
	private CelulaAbstrata celulaSimples;
    private CelulaMaluca celulaMaluca;
    private boolean bandeira;
    
=======
public class Celula{
>>>>>>> Stashed changes
    public Celula() {

    }
    
<<<<<<< Updated upstream
=======
    private CelulaAbstrata celulaSimples;

    private CelulaMaluca celulaMaluca;
    
    private boolean bandeira;
    
>>>>>>> Stashed changes
    public boolean isBandeira() {
        return bandeira;
    }
    
    public void setBandeira(boolean bandeira) {
        this.bandeira = bandeira;
    }
    
    public CelulaMaluca getCelulaMaluca() {
        return celulaMaluca;
    }
    
    public void setCelulaMaluca(CelulaMaluca celulaMaluca) {
        this.celulaMaluca = celulaMaluca;
    }
    
    public CelulaAbstrata getCelulaSimples() {
        return celulaSimples;
    }
    
    public void setCelulaSimples(CelulaAbstrata celulaSimples) {
        this.celulaSimples = celulaSimples;
    }
    
    public void inverterBandeira(){
        if(isBandeira())
            setBandeira(false);
        else
            setBandeira(true);
    }
    
    public boolean trocarBandeira(){
        if (!(isBandeira()))// verifica se está colocando ou tirando bandeira
            if(!(getCelulaMaluca() == null)){// verifica se a celula é maluca  
                System.out.println("essa celula é maluca");
                if(getCelulaMaluca().clicarCelula()){ // verifica se vai alterar seu estado
                    //alteração do estado
                    System.out.println("A celula mudou de estado");
                    if(getCelulaSimples() == null){ 
                        setCelulaSimples(new Bomba());
                    }else{
                        setCelulaSimples(null);
                    }
                    inverterBandeira();
                    return true;// retorna true para a atualização
                }
            }
            inverterBandeira();
            return false;// retorna falso para a atualização
    }
}
