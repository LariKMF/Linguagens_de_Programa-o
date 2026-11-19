package estacionamento;

import java.time.LocalDateTime;

import estacionamento.modelo.Caminhonete;
import estacionamento.modelo.Carro;
import estacionamento.modelo.Moto;
import estacionamento.modelo.Veiculo;

import estacionamento.servico.Estacionamento;

public class Main {

    public static void main(String[] args) {

        // Cria um estacionamento com 5 vagas.
        Estacionamento estacionamento =
                new Estacionamento(5);


        // ====================================
        // CRIAÇÃO DOS VEÍCULOS
        // ====================================

        Veiculo carro = new Carro(
                "ABC1234",
                "Toyota",
                "Corolla"
        );

        Veiculo moto = new Moto(
                "XYZ5678",
                "Honda",
                "CG 160"
        );

        Veiculo caminhonete = new Caminhonete(
                "DEF9012",
                "Ford",
                "Ranger"
        );


        // ====================================
        // CADASTRO DOS VEÍCULOS
        // ====================================

        estacionamento.cadastrarVeiculo(carro);

        estacionamento.cadastrarVeiculo(moto);

        estacionamento.cadastrarVeiculo(caminhonete);


        // ====================================
        // ENTRADA DOS VEÍCULOS
        // ====================================

        estacionamento.registrarEntrada(
                "ABC1234",
                LocalDateTime.of(2026, 11, 18, 14, 30)
        );

        estacionamento.registrarEntrada(
                "XYZ5678",
                LocalDateTime.of(2026, 11, 18, 14, 50)
        );

        estacionamento.registrarEntrada(
                "DEF9012",
                LocalDateTime.of(2026, 11, 18, 15, 0)
        );


        // ====================================
        // CONSULTAS
        // ====================================

        estacionamento.consultarVagas();

        estacionamento.listarVeiculosEstacionados();

        estacionamento.consultarVeiculoPorPlaca(
                "ABC1234"
        );


        // ====================================
        // SAÍDA DOS VEÍCULOS
        // ====================================

        estacionamento.registrarSaida(
                "ABC1234",
                LocalDateTime.of(2026, 11, 18, 16, 50)
        );

        estacionamento.registrarSaida(
                "XYZ5678",
                LocalDateTime.of(2026, 11, 18, 15, 35)
        );

        estacionamento.registrarSaida(
                "DEF9012",
                LocalDateTime.of(2026, 11, 18, 17, 20)
        );


        // ====================================
        // CONSULTA FINAL
        // ====================================

        estacionamento.consultarVagas();

        estacionamento.listarHistorico();

    }

}