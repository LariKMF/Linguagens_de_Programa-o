package estacionamento.modelo;

// Herança: Carro herda de Veiculo.
public class Carro extends Veiculo {

    public Carro(String placa, String marca, String modelo) {

        super(placa, marca, modelo);

    }

    // Valor da hora para carros.
    @Override
    public double getValorHora() {

        return 12.00;

    }

    @Override
    public String getTipo() {

        return "Carro";

    }

}