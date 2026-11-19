package estacionamento.modelo;

// Herança: Moto herda de Veiculo.
public class Moto extends Veiculo {

    public Moto(String placa, String marca, String modelo) {

        super(placa, marca, modelo);

    }

    // Valor da hora para motos.
    @Override
    public double getValorHora() {

        return 7.00;

    }

    @Override
    public String getTipo() {

        return "Moto";

    }

}