package REVISAO.Relacionamento;

public class Main {
    private static Professor professor;

    public static void main(String[] args) {
        this.professor.add(new Professor("Amarildo"));        
        
        System.out.println("Nome: " + professor.getNome());
    }
    
}
