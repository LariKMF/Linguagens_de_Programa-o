

public class Fatec {
    public static void main (String[] args) {
        Aluno aluno_1 = new Aluno("Larissa", "lariii@hotmail.com");
        Aluno aluno_2 = new Aluno("Enzo", "enzinho@hotmail.com");
        Aluno aluno_3 = new Aluno("Valentina", "valen@hotmail.com");

        Aluno[] fatec = {aluno_1, aluno_2, aluno_3};

        for(Aluno aluno: fatec){
            System.out.println("## Informações do Aluno ##");
            System.out.println("Nome: " + aluno.nome);
            System.out.println("E-mail: " + aluno.email);
            System.out.println("\n");
}
