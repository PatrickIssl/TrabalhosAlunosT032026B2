import java.util.Scanner;

public class Estacionamento {
    public static Scanner sc = new Scanner(System.in);
    private String placa;
    private String modelo;
    private int minutosEstacionado;
    private double valorPago;

    public Estacionamento(String p, String m) {
        placa = p;
        modelo = m;
        minutosEstacionado = 0;
        valorPago = 0.0;
    }

    public void adicionarTempo(int minutos) {
        if (minutos < 0) {
            System.out.println("Tempo não pode ser negativo.");
        }

        minutosEstacionado += minutos;
    }

    public double calcularValor() {
        double valor;
        if (minutosEstacionado <= 0) {
            valor = 0.0;
        } else if (minutosEstacionado <= 30) {
            valor = 5.00;
        } else {
            valor = 5.00 + (minutosEstacionado - 30) * 0.10;
        }
        if (valor > 30.00) {
            valor = 30.00;
        }
        valorPago = valor;
        return valor;
    }

    public void exibirResumo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Minutos estacionado: " + minutosEstacionado);
        System.out.printf("Valor a pagar: R$ %.2f%n", valorPago);
    }

    public static void main(String[] args) {
        System.out.print("Digite a placa: ");
        String placa = sc.nextLine();
        System.out.print("Digite o modelo: ");
        String modelo = sc.nextLine();
        Estacionamento veiculo = new Estacionamento(placa, modelo);

        System.out.print("Digite os minutos estacionado: ");
        veiculo.adicionarTempo(sc.nextInt());
        veiculo.calcularValor();
        veiculo.exibirResumo();
    }
}