import java.util.Scanner;

class Estacionamento {
    private String placa;
    private String modelo;
    private int minutosEstacionados;
    private double valorPago;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.minutosEstacionados = 0;
        this.valorPago = 0.0;
    }

    public void adicionarTempo(int minutos) {
        if (minutos < 0) {
            System.out.println("Erro: nao pode ser negativo.");
            return;
        }

        minutosEstacionados += minutos;
    }

    public double calcularValor() {
        if (minutosEstacionados <= 0) {
            valorPago = 0.0;
        } else if (minutosEstacionados <= 30) {
            valorPago = 5.00;
        } else {
            valorPago = 5.00 + (minutosEstacionados - 30) * 0.10;
        }

        if (valorPago > 30.00) {
            valorPago = 30.00;
        }

        return valorPago;
    }

    public void exibirResumo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Minutos estacionados: " + minutosEstacionados);
        System.out.printf("Valor pago: R$ %.2f%n", valorPago);
    }
}

public class Atv01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com a placa:");
        String placa = sc.nextLine();

        System.out.println("Entre com o modelo do carro:");
        String modelo = sc.nextLine();

        System.out.println("Minutos estacionados:");
        int minutos = Integer.parseInt(sc.nextLine());

        if (minutos < 0) {
            System.out.println("Erro: os minutos nao podem ser negativos.");
            sc.close();
            return;
        }

        Estacionamento carro = new Estacionamento(placa, modelo);

        carro.adicionarTempo(minutos);
        carro.calcularValor();
        carro.exibirResumo();

        sc.close();
    }
}