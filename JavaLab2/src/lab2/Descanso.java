package lab2;

/**
 * Classe responsável por guardar as horas de descanso na semana que o aluno teve. Checa também, se o aluno está descansado
 * ou não.
 */

public class Descanso {
    private int horasDescanso;
    private int numerosSemanas;

    /**
     * Método que define as horas de descanso
     * @param valor inteiro para atribuir as horas de descanso
     */
    public void defineHorasDescanso(int valor){
        this.horasDescanso = valor;
    }

    /**
     * Método que está definindo o número de semanas.
     * @param valor parâmetro inteiro que se refere ao um valor para número de semanas
     */
    public void defineNumeroSemanas(int valor){
        this.numerosSemanas = valor;
    }

    /**
     * Método responsável por verificar dois estados possíveis do estudante: Cansado ou descansado, baseado nos
     * dados colhidos.
     * @return String retorna:
     *         cansado caso não tenha horas de descanso ou numeros de semanas definidas, ou se for menor que 26;
     *         descansado se a divisão entre horas de descanso e numeros de semanas forem maiores ou iguais a 26.
     */
    public String getStatusGeral() {
        if (this.horasDescanso == 0 || this.numerosSemanas == 0) {
            return "cansado";
        } else if (this.horasDescanso /this.numerosSemanas >= 26){
            return "descansado";
        } else {
            return "cansado";
        }
    }
}
