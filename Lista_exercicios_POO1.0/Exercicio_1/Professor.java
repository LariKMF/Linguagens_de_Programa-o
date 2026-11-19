public class Professor {
    String nome = "";
    int quantidade_cafe = 0;
    String humor = "";
    String nivel_paciencia = "";
    boolean usa_data_show = true;
    String frase_favorita = "";

    public Professor (String nome, int quantidade_cafe, String humor, String nivel_paciencia, boolean usa_data_show,  String frase_favorita) {
        this.nome = nome;
        this.quantidade_cafe = quantidade_cafe;
        this.humor = humor;
        this.nivel_paciencia = nivel_paciencia;
        this.usa_data_show = usa_data_show;
        this.frase_favorita = frase_favorita;
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }
     public String getNome() { 
        return this.nome; 
    }
    public void setQuantidadeCafe(int quantidade_cafe) { 
        this.quantidade_cafe = quantidade_cafe; 
    }
    public int getQuantidadeCafe() { 
        return this.quantidade_cafe;
    }
    public void setHumor(String humor) { 
        this.humor = humor; 
    }
    public String getHumor() {
}
