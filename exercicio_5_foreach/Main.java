
public class Main {
    public static void main(String[] args){
        /* String[] alunos = {"Miranata", "Savalo", "Aeronauta"};

        alunos[0] = "Mariazinha";
        System.out.println("Quantidade de alunos: " + alunos.length);

        for(String estudante : alunos){
            System.out.println(estudante);
        } */

        /* String[] produtos = {"Creme de Pentear", "Shampoo", "Condicionador", "Mascara Hidratante", "Oleo Finalizador"};

        System.out.println("Quantidade de produtos disponiveis para compra online: " + produtos.length);

        for(String mercadorias : produtos) {
            System.out.println(mercadorias);
        } */

       /*  String[] produtos = {"Creme de Pentear", "Shampoo", "Condicionador", "Mascara Hidratante", "Oleo Finalizador"};

        for (int i = 0; i < produtos.length; i++) {
            System.out.println(produtos[i]);
        } */

        int [] numeros = {45, -55, 65, -75, 0};

        for (int numerais : numeros) {
            if (numerais < 0)
            System.out.println("O valor de " + numerais + " e Negativo");
            if (numerais == 0)
            System.out.println("O valor de " + numerais + " e Zero");
            if (numerais > 0)
            System.out.println("O valor de " + numerais + " e Positivo");
        }
    }
}
