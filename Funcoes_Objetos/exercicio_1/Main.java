
public class Main {

    public static void main(String[] args) {
        Carro car = new Carro();
        car.marca = "Bugatti";
        car.modelo = "Divo";
        car.combustivel = "Diesel";
        car.cor = "Azul";
        car.ano = 2024;

        System.out.println(car.marca);
        System.out.println(car.modelo);
        System.out.println(car.combustivel);
        System.out.println(car.cor);
        System.out.println(car.ano);
        car.ligarMotor();
        car.desligarMotor();

        Moto motocycle = new Moto();
        motocycle.marca = "Honda";
        motocycle.modelo = "Biz";
        motocycle.combustivel = "Gasolina";
        motocycle.cilindradas = 125;
        motocycle.ano = 2022;

        System.out.println(motocycle.marca);
        System.out.println(motocycle.modelo);
        System.out.println(motocycle.combustivel);
        System.out.println(motocycle.cilindradas);
        System.out.println(motocycle.ano);
        motocycle.ligarMotor();
        motocycle.desligarMotor();
    }
}
