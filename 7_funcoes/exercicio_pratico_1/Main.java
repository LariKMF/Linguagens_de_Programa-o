

public class Main {
    
    static void analisar(int valor){
        if (valor < 0){
            System.out.println("O numero " + valor + " e menor que 0");
        } else if (valor == 0){
            System.out.println("O numero " + valor + " e igual a 0");
        } else if (valor > 0){
            System.out.println("O numero " + valor + " e maior que 0");
        }
    }

    public static void main(String[] args){
        analisar(-4);
    }
}
