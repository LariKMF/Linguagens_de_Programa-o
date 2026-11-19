package estacionamento.modelo;

// Herança: Caminhonete herda de Veiculo.
public class Caminhonete extends Veiculo {

    public Caminhonete(String placa, String marca, String modelo) {

        super(placa, marca, modelo);

    }

    // Valor da hora para caminhonetes.
    @Override
    public double getValorHora() {

        return 18.00;

    }

    @Override
    public String getTipo() {

        return "Caminhonete";

    }

}