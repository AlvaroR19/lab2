package lab2;

/**
 * Classe responsável por ser o molde de resumos e por permitir
 * retornar seus dois únicos atributos separadamente, tem relação de composição com a classe RegistroResumos.java.
 */
public class Resumo {
    private String tema;
    private String conteudo;

    /**
     * Construtor de Resumo para guardar informações como tema e conteudo de objetos.
     * @param tema String tema do resumo
     * @param conteudo String contéudo daquele tema
     */
    public Resumo(String tema, String conteudo){
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Método getter para retornar o atributo tema do objeto naquele estado.
     * @return String retorna o tema do objeto naquele estado
     */
    public String getTema() {
        return this.tema;
    }

    /**
     * Método getter para retornar o atributo conteudo do objeto naquele estado.
     * @return String retorna o conteudo do objeto naquele estado
     */
    public String getConteudo() {
        return this.conteudo;
    }
}

