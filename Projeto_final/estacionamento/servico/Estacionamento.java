package estacionamento.servico;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import estacionamento.modelo.RegistroEstacionamento;
import estacionamento.modelo.Vaga;
import estacionamento.modelo.Veiculo;

public class Estacionamento {

    private List<Vaga> vagas;
    private List<Veiculo> veiculosCadastrados;
    private List<RegistroEstacionamento> historico;

    private DateTimeFormatter formatoHora =
            DateTimeFormatter.ofPattern("HH:mm");

    private NumberFormat formatoMoeda =
            NumberFormat.getCurrencyInstance(
                    Locale.forLanguageTag("pt-BR")
            );

    // Construtor: define a quantidade de vagas.
    public Estacionamento(int quantidadeVagas) {

        vagas = new ArrayList<>();
        veiculosCadastrados = new ArrayList<>();
        historico = new ArrayList<>();

        for (int i = 1; i <= quantidadeVagas; i++) {

            vagas.add(new Vaga(i));

        }

    }

    // RF01: cadastrar veículo.
    public void cadastrarVeiculo(Veiculo veiculo) {

        if (veiculo == null || veiculo.getPlaca().isBlank()) {

            System.out.println(
                    "Cadastro não realizado: dados inválidos.\n"
            );

            return;

        }

        if (buscarVeiculoCadastrado(veiculo.getPlaca()) != null) {

            System.out.println(
                    "Cadastro não realizado: placa já cadastrada.\n"
            );

            return;

        }

        veiculosCadastrados.add(veiculo);

        System.out.println(
                "Veículo cadastrado: "
                + veiculo.getPlaca()
                + " - "
                + veiculo.getTipo()
        );

        System.out.println();

    }

    // RF02: registrar entrada do veículo.
    public void registrarEntrada(
            String placa,
            LocalDateTime horarioEntrada) {

        Veiculo veiculo = buscarVeiculoCadastrado(placa);

        // Verifica se o veículo existe.
        if (veiculo == null || horarioEntrada == null) {

            System.out.println(
                    "Entrada não permitida: veículo não cadastrado ou horário inválido.\n"
            );

            return;

        }

        // Verifica se o veículo já está estacionado.
        if (buscarRegistroAtivo(placa) != null) {

            System.out.println(
                    "Entrada não permitida: veículo já estacionado.\n"
            );

            return;

        }

        // Procura uma vaga disponível.
        Vaga vagaDisponivel = buscarVagaDisponivel();

        if (vagaDisponivel == null) {

            System.out.println(
                    "Entrada não permitida: estacionamento cheio.\n"
            );

            return;

        }

        // Ocupa a vaga.
        vagaDisponivel.ocupar(veiculo);

        // Cria o registro de estacionamento.
        RegistroEstacionamento registro =
                new RegistroEstacionamento(
                        veiculo,
                        vagaDisponivel,
                        horarioEntrada
                );

        // Adiciona ao histórico.
        historico.add(registro);

        System.out.println("====================================");
        System.out.println("       ENTRADA DE VEÍCULO");
        System.out.println("====================================");

        System.out.println("Veículo registrado com sucesso!");

        System.out.println("Tipo: " + veiculo.getTipo());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Modelo: " + veiculo.getModelo());

        System.out.printf(
                "Vaga ocupada: %02d%n",
                vagaDisponivel.getNumero()
        );

        System.out.println(
                "Horário de entrada: "
                + horarioEntrada.format(formatoHora)
        );

        System.out.println();

    }

    // RF03 e RF04: registrar saída e calcular o estacionamento.
    public void registrarSaida(
            String placa,
            LocalDateTime horarioSaida) {

        RegistroEstacionamento registro =
                buscarRegistroAtivo(placa);

        // Verifica se o veículo está estacionado.
        if (registro == null) {

            System.out.println(
                    "Saída não realizada: veículo não encontrado.\n"
            );

            return;

        }

        // Verifica se o horário de saída é válido.
        if (horarioSaida == null ||
                !horarioSaida.isAfter(
                        registro.getHorarioEntrada()
                )) {

            System.out.println(
                    "Saída não realizada: horário inválido.\n"
            );

            return;

        }

        // Registra a saída.
        registro.registrarSaida(horarioSaida);

        // Libera a vaga.
        registro.getVaga().liberar();

        // Calcula o tempo de permanência.
        long minutos = registro.calcularMinutosPermanencia();

        long horasCompletas = minutos / 60;
        long minutosRestantes = minutos % 60;

        String tempoPermanencia;

        if (horasCompletas > 0 && minutosRestantes > 0) {

            tempoPermanencia =
                    horasCompletas
                    + " hora(s) e "
                    + minutosRestantes
                    + " minuto(s)";

        } else if (horasCompletas > 0) {

            tempoPermanencia =
                    horasCompletas + " hora(s)";

        } else {

            tempoPermanencia =
                    minutosRestantes + " minuto(s)";

        }

        System.out.println("====================================");
        System.out.println("        SAÍDA DE VEÍCULO");
        System.out.println("====================================");

        System.out.println(
                "Placa: " + registro.getVeiculo().getPlaca()
        );

        System.out.println(
                "Horário de entrada: "
                + registro.getHorarioEntrada().format(formatoHora)
        );

        System.out.println(
                "Horário de saída: "
                + horarioSaida.format(formatoHora)
        );

        System.out.println(
                "Tempo de permanência: " + tempoPermanencia
        );

        System.out.println(
                "Horas cobradas: "
                + registro.calcularHorasCobradas()
        );

        System.out.println(
                "Valor do estacionamento: "
                + formatoMoeda.format(registro.calcularValor())
        );

        System.out.printf(
                "Vaga %02d liberada com sucesso!%n%n",
                registro.getVaga().getNumero()
        );

    }

    // RF05: consultar vagas disponíveis e ocupadas.
    public void consultarVagas() {

        System.out.println("====================================");
        System.out.println("          CONSULTA DE VAGAS");
        System.out.println("====================================");

        for (Vaga vaga : vagas) {

            if (vaga.estaOcupada()) {

                System.out.printf(
                        "Vaga %02d - OCUPADA - Placa: %s%n",
                        vaga.getNumero(),
                        vaga.getVeiculo().getPlaca()
                );

            } else {

                System.out.printf(
                        "Vaga %02d - DISPONÍVEL%n",
                        vaga.getNumero()
                );

            }

        }

        System.out.println();

    }

    // RF06: listar veículos estacionados.
    public void listarVeiculosEstacionados() {

        System.out.println("====================================");
        System.out.println("       VEÍCULOS ESTACIONADOS");
        System.out.println("====================================");

        boolean encontrou = false;

        for (Vaga vaga : vagas) {

            if (vaga.estaOcupada()) {

                Veiculo veiculo = vaga.getVeiculo();

                System.out.printf(
                        "Vaga %02d | %s | %s | %s | Placa: %s%n",

                        vaga.getNumero(),
                        veiculo.getTipo(),
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getPlaca()
                );

                encontrou = true;

            }

        }

        if (!encontrou) {

            System.out.println(
                    "Não há veículos estacionados."
            );

        }

        System.out.println();

    }

    // RF08: consultar veículo pela placa.
    public void consultarVeiculoPorPlaca(String placa) {

        Veiculo veiculo = buscarVeiculoCadastrado(placa);

        System.out.println("====================================");
        System.out.println("       CONSULTA DE VEÍCULO");
        System.out.println("====================================");

        if (veiculo == null) {

            System.out.println(
                    "Veículo não encontrado: " + placa + "\n"
            );

            return;

        }

        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Tipo: " + veiculo.getTipo());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Modelo: " + veiculo.getModelo());

        RegistroEstacionamento registro =
                buscarRegistroAtivo(placa);

        if (registro != null) {

            System.out.printf(
                    "Vaga: %02d%n",
                    registro.getVaga().getNumero()
            );

            System.out.println(
                    "Entrada: "
                    + registro.getHorarioEntrada().format(formatoHora)
            );

            System.out.println("Situação: Estacionado\n");

        } else {

            System.out.println(
                    "Situação: Não está estacionado no momento.\n"
            );

        }

    }

    // Consultar o histórico de entradas e saídas.
    public void listarHistorico() {

        System.out.println("====================================");
        System.out.println("       HISTÓRICO DO ESTACIONAMENTO");
        System.out.println("====================================");

        if (historico.isEmpty()) {

            System.out.println(
                    "Ainda não existem registros.\n"
            );

            return;

        }

        for (RegistroEstacionamento registro : historico) {

            Veiculo veiculo = registro.getVeiculo();

            System.out.print(
                    "Placa: " + veiculo.getPlaca()
                    + " | Tipo: " + veiculo.getTipo()
                    + " | Entrada: "
                    + registro.getHorarioEntrada().format(formatoHora)
            );

            if (registro.estaAtivo()) {

                System.out.println(
                        " | Situação: Estacionado"
                );

            } else {

                System.out.println(
                        " | Saída: "
                        + registro.getHorarioSaida().format(formatoHora)
                        + " | Valor: "
                        + formatoMoeda.format(registro.calcularValor())
                );

            }

        }

        System.out.println();

    }

    // Método auxiliar: procurar veículo cadastrado pela placa.
    private Veiculo buscarVeiculoCadastrado(String placa) {

        if (placa == null) {

            return null;

        }

        for (Veiculo veiculo : veiculosCadastrados) {

            if (veiculo.getPlaca().equalsIgnoreCase(placa.trim())) {

                return veiculo;

            }

        }

        return null;

    }

    // Método auxiliar: procurar vaga disponível.
    private Vaga buscarVagaDisponivel() {

        for (Vaga vaga : vagas) {

            if (!vaga.estaOcupada()) {

                return vaga;

            }

        }

        return null;

    }

    // Método auxiliar: procurar veículo que ainda está estacionado.
    private RegistroEstacionamento buscarRegistroAtivo(String placa) {

        if (placa == null) {

            return null;

        }

        for (RegistroEstacionamento registro : historico) {

            boolean mesmaPlaca =
                    registro.getVeiculo().getPlaca()
                    .equalsIgnoreCase(placa.trim());

            if (mesmaPlaca && registro.estaAtivo()) {

                return registro;

            }

        }

        return null;

    }

}