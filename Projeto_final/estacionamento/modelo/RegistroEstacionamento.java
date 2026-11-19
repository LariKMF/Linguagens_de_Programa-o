package estacionamento.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class RegistroEstacionamento {

    private Veiculo veiculo;
    private Vaga vaga;

    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;

    // Construtor.
    public RegistroEstacionamento(
            Veiculo veiculo,
            Vaga vaga,
            LocalDateTime horarioEntrada) {

        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = null;

    }

    // Getters.
    public Veiculo getVeiculo() {

        return veiculo;

    }

    public Vaga getVaga() {

        return vaga;

    }

    public LocalDateTime getHorarioEntrada() {

        return horarioEntrada;

    }

    public LocalDateTime getHorarioSaida() {

        return horarioSaida;

    }

    // Verifica se o veículo ainda está estacionado.
    public boolean estaAtivo() {

        return horarioSaida == null;

    }

    // Registra o horário de saída.
    public void registrarSaida(LocalDateTime horarioSaida) {

        this.horarioSaida = horarioSaida;

    }

    // Calcula o tempo de permanência em minutos.
    public long calcularMinutosPermanencia() {

        if (estaAtivo()) {

            return 0;

        }

        return Duration.between(
                horarioEntrada,
                horarioSaida
        ).toMinutes();

    }

    // Calcula as horas cobradas.
    public int calcularHorasCobradas() {

        int horas = (int) Math.ceil(
                calcularMinutosPermanencia() / 60.0
        );

        return Math.max(horas, 1);

    }

    // Calcula o valor final.
    public double calcularValor() {

        return veiculo.calcularValor(
                calcularMinutosPermanencia()
        );

    }

}
