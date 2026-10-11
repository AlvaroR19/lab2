package lab2;

/**
 * Classe responsável por manter a informação sobre a quantidade de horas que o aluno dedicou a
 * uma disciplina.
 */
public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoEsperado = 120;
    private int tempoInvestido = 0;

    /**
     * Construtor que guardar o nome da disciplina do objeto no estado atual e o
     * tempo de conclusão esperado de uma disciplina, padronizada por 120 horas.
     * @param nomeDisciplina String nome da disciplina atribuida
     */
    public RegistroTempoOnline(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = 120;
    }

    /**
     * Construtor que guarda o nome da disciplina mas que agora tem tempo de conclusão costumizada
     * @param nomeDisciplina String nome da disciplina atribuida
     * @param tempoEsperado int horas necessárias para aquela disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoEsperado;
    }

    /**
     * Método que incrementa tempo dedicado a uma disciplina.
     * @param tempoInvestido inteiro para incrementar com o tempo já guardado anteriormente.
     */
    public void adicionaTempoOnline(int tempoInvestido) {
        this.tempoInvestido += tempoInvestido;
    }

    /**
     * Método para verificar se o tempo necessário para uma disciplina já foi satisfeito.
     * @return true se o tempo dedicado a disciplina for maior ou igual o tempo que a disciplina espera.
     *         false caso o contrário.
     */
    public boolean atingiuMetaTempoOnline() {
        if (this.tempoInvestido >= this.tempoEsperado) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para retornar como o objeto é representado por String.
     * @return String contendo o nome da disciplina e o tempo dedicado pelo tempo esperado da disciplina.
     */

    @Override
    public String toString(){
        return this.nomeDisciplina +" "+tempoInvestido+"/"+tempoEsperado;
    }

}
