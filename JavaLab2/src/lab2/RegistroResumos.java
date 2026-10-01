package lab2;

public class RegistroResumos {
    private String[] tema;
    private String conteudo;

    public RegistroResumos(int numeroDeResumos){
        this.tema = new String[numeroDeResumos];
    }

    private boolean verificarTemas(String temaProcurado){
        for (int i = 0; i < this.tema.length; i++) {
            if (this.tema[i].equals(temaProcurado)) {
                return true;
            }
        }
        return false;
    }

    public int conta(){
        int contador = 0;
        for (int j = 0; j < this.tema.length; j++) {
            if (this.tema[j] != null) {
                contador++;
            }
        }
        return contador;
    }

    public void adiciona(String tema, String conteudo){
        int index = 0;
        if (!verificarTemas(tema)) {
            if (index == this.tema.length) {
                index = 0;
            } else {
                this.tema[index] = conteudo;
                index++;
            }
        }

    }
}
