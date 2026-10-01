package lab2;

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas = {0,0,0,0};

    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    public void cadastraHoras(int horas) {
        this.horasEstudo +=horas;
    }

    public void cadastraNota(int nota, double valorNota){
        this.notas[nota-1] = valorNota;
    }

    public double calcularMedia() {
        double media = 0;
        for (int i = 0; i < this.notas.length; i++) {
            media+=notas[i];
        }
        return media = media/4;
    }

    public boolean aprovado(){
        if (calcularMedia() >= 7.0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return this.nomeDisciplina + " " + this.horasEstudo + " " + calcularMedia() + " " + Arrays.toString(this.notas);
    }
}
