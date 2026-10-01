package lab2;

public class RegistroTempoOnline {
    private String nomeMateria;
    private int tempoEsperado = 120;
    private int tempoInvestido = 0;

    public RegistroTempoOnline(String nomeMateria){
        this.nomeMateria = nomeMateria;
        this.tempoEsperado = 120;
    }

    public RegistroTempoOnline(String nomeMateria, int tempoEsperado) {
        this.nomeMateria = nomeMateria;
        this.tempoEsperado = tempoEsperado;
    }

    public void adicionaTempoOnline(int tempoInvestido) {
        this.tempoInvestido += tempoInvestido;
    }

    public boolean atingiuMetaTempoOnline() {
        if (this.tempoInvestido >= this.tempoEsperado) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return this.nomeMateria+" "+tempoInvestido+"/"+tempoEsperado;
    }

}
