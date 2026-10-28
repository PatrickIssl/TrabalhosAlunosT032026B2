class Estacionamento {
    String placa;
    String modelo;
    int minutosEstacionado;
    double valorPago;

    void adicionarTempo(int minutos) {
        if (minutos >= 0) {
            minutosEstacionado += minutos;
        } else {
            System.out.println("O tempo não pode ser negativo!");
        }
    }

    void calcularValor() {
        if (minutosEstacionado == 0) {
            valorPago = 0;
        } else if (minutosEstacionado <= 30) {
            valorPago = 5.00;
        } else {
            valorPago = 5.00 + (minutosEstacionado - 30) * 0.10;
        }

        if (valorPago > 30.00) {
            valorPago = 30.00;
        }
    }

    void exibirResumo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Minutos estacionado: " + minutosEstacionado);
        System.out.printf("Valor pago: R$ %.2f%n", valorPago);
    }
}

public class Main {
    public static void main(String[] args) {
        Estacionamento carro = new Estacionamento();

        carro.placa = "ABC-1234";
        carro.modelo = "Honda Civic";

        carro.adicionarTempo(60);
        carro.calcularValor();
        carro.exibirResumo();
    }
}