package estacionamento.modelo;

public class Vaga {

    private int numero;
    private Veiculo veiculo;

    // Construtor.
    public Vaga(int numero) {

        this.numero = numero;
        this.veiculo = null;

    }

    public int getNumero() {

        return numero;

    }

    public Veiculo getVeiculo() {

        return veiculo;

    }

    // Verifica se a vaga está ocupada.
    public boolean estaOcupada() {

        return veiculo != null;

    }

    // Ocupa uma vaga.
    public boolean ocupar(Veiculo veiculo) {

        if (estaOcupada()) {

            return false;

        }

        this.veiculo = veiculo;

        return true;

    }

    // Libera uma vaga.
    public Veiculo liberar() {

        Veiculo veiculoLiberado = this.veiculo;

        this.veiculo = null;

        return veiculoLiberado;

    }

}