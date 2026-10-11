package lab2;

import java.util.Arrays;

/**
 * Classe responsável por construir informações completas de disciplina, como nome da disciplina, atribuir notas, calcular
 * média das notas, atribuir horas de estudo e avisar ao aluno caso ele esteja aprovado ou não. Ou seja, é quem gerencia
 * as diferentes disciplinas criadas.
 */

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private int quantNotas;
    private double[] notas;
    private int[] pesosNotas;

    /**
     * Construtor quando apenas o nome da disciplina foi informado, no caso ele irá executar outro construtor dentro de si
     * no caso, o construtor com 2 parâmetros, aplicando o padrão de 4 notas por disciplina.
     * @param nomeDisciplina String nome da disciplina que está sendo guardado
     */
    public Disciplina(String nomeDisciplina){
        this(nomeDisciplina,4);
    }

    /**
     * Construtor para apenas criar novas instâncias contendo apenas o nome e quantidade de notas que a disciplina terá.
     * @param nomeDisciplina string para o nome da disciplina
     * @param qNotas int para saber quantas notas a disciplina terá
     */
    public Disciplina(String nomeDisciplina, int qNotas){ //Outro construtor solicitado.
        this.nomeDisciplina = nomeDisciplina;
        this.quantNotas = qNotas;
        this.notas = new double[this.quantNotas];
    }

    /**
     * Construtor completo caso seja informado todas as informações da disciplina.
     * @param nomeDisciplina string para o nome da disciplina
     * @param qNotas int para saber quantas notas a disciplina terá
     * @param pesosNota array tipo int para receber os valores dos pesos das notas
     */
    public Disciplina(String nomeDisciplina, int qNotas, int[] pesosNota) {
        this.nomeDisciplina = nomeDisciplina;
        this.quantNotas = qNotas;
        this.notas = new double[this.quantNotas]; //Reserva espaços na memória para receber uma quantidade determinada (informada pelo usuário) de notas.
        this.pesosNotas = pesosNota.clone();
    }

    /**
     * Método para adicionar horas estudadas para aquela disciplina
     * @param horas parâmetro inteiro para receber quantas horas foi dedicado para a disciplina
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo +=horas;
    }

    /**
     * Método para cadastrar as notas recebidas do usuário
     * @param indexNota valor inteiro recebido para adicionar em alguma posição a nota que será recebida
     * @param valorNota valor double das notas a ser adicionada no array notas
     */
    public void cadastraNota(int indexNota, double valorNota){
        this.notas[indexNota-1] = valorNota;
    }


    /**
     * Método que calcula a média conforme os parâmetros enviados nos construtores, caso o Array de peso não tenha sido declarado
     * ou tenha algum peso igual a zero, o programa irá calcular a média aritmética. Caso contrário, a média ponderada.
     * @return a média calculada baseado nas condições passadas, ou uma média aritmética, ou então uma média ponderada
     */
    public double calcularMedia() {
        double somaNotas = 0;
        for (int i = 0; i < this.notas.length; i++) {
            somaNotas += this.notas[i];
        }

        if (this.pesosNotas == null || this.pesosNotas.length == 0) {
            return somaNotas / this.notas.length;
        }

        double numerador = 0;
        double denominador = 0;
        boolean isZeroOuNegativo = false;
        for (int i = 0; i < this.notas.length; i++) {
            numerador += this.pesosNotas[i] * this.notas[i];
            if (this.pesosNotas[i] > 0) {
                denominador += this.pesosNotas[i];
            } else {
                isZeroOuNegativo = true;
            }
        }

        if (denominador<=0 || isZeroOuNegativo) {
            return somaNotas / this.notas.length;
        } else {
            return numerador/denominador;
        }
    }

    /**
     * Método que invoca outro método, calcularMedia(), para determinar se o aluno está aprovado ou não.
     * @return true se a média for maior ou igual a sete;
     *         false se for o contrário.
     */
    public boolean aprovado(){
        if (calcularMedia() >= 7.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para retornar como o objeto é representado por String.
     * @return String contendo o nome da disciplina, horas de estudo, a média de notas da disciplina e todas as notas em array.
     */
    @Override
    public String toString(){
        return this.nomeDisciplina + " " + this.horasEstudo + " " + calcularMedia() + " " + Arrays.toString(this.notas);
    }
}
