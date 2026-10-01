package lab2;

public class RegistroResumos {
    private String[] tema;
    private String[] conteudo;
    private int index = 0;

    public RegistroResumos(int numeroDeResumos){
        this.tema = new String[numeroDeResumos];
        this.conteudo = new String[numeroDeResumos];
    }

    public boolean temResumo(String temaProcurado){
        for (int i = 0; i < this.tema.length; i++) {
            if (this.tema[i] != null && this.tema[i].equals(temaProcurado)) {
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
        if (!temResumo(tema)) {
            if (index == this.tema.length) {
                index = 0;
            }
            this.tema[index] = tema;
            this.conteudo[index] = conteudo;
            index++;
        }
    }

    public String[] pegaResumos(){
        int total = conta();
        String[] getResumos = new String[total];
        for (int i = 0; i < total; i++) {
            getResumos[i] = this.tema[i]+": "+this.conteudo[i];
        }
        return getResumos;
    }

    public String imprimeResumos() {
        int totalResumo = conta();
        String resumosMontados = "- "+totalResumo+" resumo(s) cadastrado(s)\n";
        for (int i = 0; i < totalResumo; i++) {
            if (i == 0) {
                resumosMontados+="- " + this.tema[i] + " | ";
            } else if (i < totalResumo-1){
                resumosMontados+=this.tema[i] + " | ";
            } else {
                resumosMontados+=this.tema[i];
            }
        }
        return resumosMontados;
    }
}
