package lista_de_exercicios_java.exercicio_3;

public class Main {
    public static void main(String[] args) {
        double nota = 5.9;
        if (nota >= 6) {
            System.out.println("A nota eh " + nota + " o aluno foi APROVADO");
        } else if (nota >= 4) {
            System.out.println("A nota eh " + nota + " o aluno esta de RECUPERACAO");
        } else {
            System.out.println("A nota eh " + nota + " o aluno foi REPROVADO");
        }
    }
    
}
