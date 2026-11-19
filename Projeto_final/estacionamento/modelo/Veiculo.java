package estacionamento.modelo;

import estacionamento.interfaces.Calculavel;

// Classe abstrata que representa um veículo.
public abstract class Veiculo implements Calculavel {

    // Atributos privados (encapsulamento).
    private String placa;
    private String marca;
    private String modelo;

    // Construtor.
    public Veiculo(String placa, String marca, String modelo) {

        this.placa = placa.trim().toUpperCase();
        this.marca = marca;
        this.modelo = modelo;

    }

    // Getters.
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    // Métodos abstratos.
    public abstract double getValorHora();

    public abstract String getTipo();

    // Calcula o valor do estacionamento.
    @Override
    public double calcularValor(long minutos) {

        int horasCobradas = (int) Math.ceil(minutos / 60.0);

        // Cobra no mínimo uma hora.
        if (horasCobradas < 1) {
            horasCobradas = 1;
        }

        return horasCobradas * getValorHora();

    }
}