package lab2;

import java.util.Arrays;

/**
 * Classe responsável por administrar uma coletânea de Resumos, podendo adicionar um resumo, procurar se um resumo está
 * cadastrado baseado no tema informado, contar a quantidade de resumos cadastrados válidos, retornar todos os temas e
 * contéudos dos resumos, buscar um tema através apenas de uma palavra que faz parte do conteúdo desse tema e retornar
 * quantos resumos existem e todos os temas cadastrados até o momento.
 */
public class RegistroResumos {
    private Resumo[] resumos;
    private int index = 0;

    /**
     * Construtor para inicializar o array que determinará a capacidade de resumos cadastráveis.
     * @param numeroDeResumos int que determinar a quantidade de resumos cadastráveis.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
    }

    /**
     * Método responsável por criar um objeto resumo da classe Resumo.java
     * @param tema String para guardar o tema do resumo.
     * @param conteudo String contéudo do tema do resumo.
     */
    public void adiciona(String tema, String conteudo) {
        if (!temResumo(tema)) {
            if (index == this.resumos.length) {
                index = 0;
            }
            this.resumos[index] = new Resumo(tema, conteudo);
            index++;
        }
    }

    /**
     * Método responsável por verificar através de um booleano, se determinado tema digitado pelo usuário existe na coletânea
     * de resumos
     * @param temaProcurado String que representa o valor a ser procurado
     * @return true se o existir o resumo, existir aquele tema e se for igual ao tema sendo procurado.
     *         false se não for desse jeito.
     */
    public boolean temResumo(String temaProcurado) {
        for (int i = 0; i < this.resumos.length; i++) {
            if (this.resumos[i] != null && this.resumos[i].getTema() != null && this.resumos[i].getTema().equals(temaProcurado)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que conta apenas os resumos realmente existentes e que foram atribuidos no Array.
     * @return conta total de resumos válidos existentes.
     */
    public int conta() {
        int contador = 0;
        for (int i = 0; i < this.resumos.length; i++) {
            if (this.resumos[i] != null) {
                contador++;
            }
        }
        return contador;
    }


    /**
     * Método responsável por retornar todos os resumos válidos cadastrados.
     * @return um array do tipo String[] mostrando o tema e seu respectivo conteúdo
     */
    public String[] pegaResumos() {
        int total = conta();
        String[] getResumos = new String[total];
        for (int i = 0; i < total; i++) {
            getResumos[i] = this.resumos[i].getTema() + ": " + this.resumos[i].getConteudo();

        }
        return getResumos;
    }

    /**
     * Método responsável por mostrar ao usuário a quantidade de resumos existentes (VÁLIDOS!) e seus respectivos temas
     * @return String mostrando o total de resumos cadastrados e o tema de cada resumo.
     */
    public String imprimeResumos() {
        int totalResumo = conta();
        String resumosMontados = "- " + totalResumo + " resumo(s) cadastrado(s)\n";
        for (int i = 0; i < totalResumo; i++) {
            if (i == 0) {
                resumosMontados += "- " + this.resumos[i].getTema() + " | ";
            } else if (i < totalResumo - 1) {
                resumosMontados += this.resumos[i].getTema() + " | ";
            } else {
                resumosMontados += this.resumos[i].getTema();
            }
        }
        return resumosMontados;
    }

    /**
     * Método de busca que retorna um array dos temas onde se encontrou a String procurado, array esse em ordem alfabética.
     * @param chaveDeBusca String a qual se procura nos contéudos
     * @return String[] array de Strings contendo os temas onde seus conteúdos tem a possível String buscada.
     */
    public String[] busca(String chaveDeBusca) {
        int quantPossiveisTemas = 0;
        for (int i = 0; i < this.resumos.length; i++) {
            if (this.resumos[i] != null && this.resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                quantPossiveisTemas++;
            }
        }
        String[] temasPossiveis = new String[quantPossiveisTemas];
        int posicaoArrayTemas = 0;
        for (int i = 0; i < this.resumos.length; i++) {
            if (this.resumos[i] != null) {
                if (this.resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                    temasPossiveis[posicaoArrayTemas] = this.resumos[i].getTema();
                    posicaoArrayTemas++;
                }
            }
        }
        Arrays.sort(temasPossiveis);
        return temasPossiveis;
    }
}
