package campoMinado.Celulas;

import campoMinado.Celulas.CelulaMaluca.CelulaMaluca;
import campoMinado.Celulas.CelulaSimples.CelulaAbstrata;

public class Celula {
    public Celula(CelulaMaluca celulaMaluca) {
        this.celulaMaluca = celulaMaluca;
    }
    public Celula(CelulaAbstrata celulaSimples, CelulaMaluca celulaMaluca) {
        this.celulaSimples = celulaSimples;
        this.celulaMaluca = celulaMaluca;
    }
    private CelulaAbstrata celulaSimples;
    private CelulaMaluca celulaMaluca;
    
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
}
