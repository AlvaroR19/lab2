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
        for ()
    }
    public void adiciona(String tema, String conteudo){
        if (verificarTemas(tema)) {
            this.tema[0] = tema;
        }

    }

}
