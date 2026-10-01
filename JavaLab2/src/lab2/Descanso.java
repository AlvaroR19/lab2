package lab2;

public class Descanso {
    private int horasDenscanso;
    private int numerosSemanas;

    public void defineHorasDescanso(int valor){
        this.horasDenscanso = valor;
    }

    public void defineNumeroSemanas(int valor){
        this.numerosSemanas = valor;
    }

    public String getStatusGeral() {
        if (this.horasDenscanso == 0 || this.numerosSemanas == 0) {
            return "cansado";
        } else if (this.horasDenscanso/this.numerosSemanas >= 26){
            return "descansado";
        } else {
            return "cansado";
        }
    }
}
