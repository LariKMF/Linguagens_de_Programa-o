public class Aluno {
    String nome = "";
    String email = "";
    boolean inteligente = true;
    int nivel_sono = 0;
    boolean piscando_lento = true;

    public Aluno(String nome, String email, boolean inteligente, int nivel_sono, boolean piscando_lento) {
        this.nome = nome;
        this.email = email;
        this.inteligente = inteligente;
        this.nivel_sono = nivel_sono;
        this.piscando_lento = piscando_lento;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void getNome(String nome) {
        this.nome = nome;
    }

}
