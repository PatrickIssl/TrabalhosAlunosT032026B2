public class Estacionamento {
    private String placa;
    private String modelo;
    private int minutosEstacionado;
    private double valorPago;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.minutosEstacionado = 0;
        this.valorPago = 0.0;
    }

    public void adicionarTempo(int minutos) {
        if (minutos < 0) {
            System.out.println("Erro: o tempo não pode ser negativo.");
            return;
        }
        minutosEstacionado += minutos;
    }

    public double calcularValor() {
        double valor;
        if (minutosEstacionado <= 30) {
            valor = 5.00;
        } else {
            valor = 5.00 + (minutosEstacionado - 30) * 0.10;
        }
        valorPago = Math.min(valor, 30.00);
        return valorPago;
    }

    public void exibirResumo() {
        System.out.println("--- Resumo do Estacionamento ---");
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tempo estacionado: " + minutosEstacionado + " minutos");
        System.out.printf("Valor a pagar: R$ %.2f%n", valorPago);
    }

    public static void main(String[] args) {
        Estacionamento carro = new Estacionamento("ABC-1234", "Gol");
        carro.adicionarTempo(45);
        carro.adicionarTempo(60);
        carro.adicionarTempo(-10); // teste de valor negativo
        carro.calcularValor();
        carro.exibirResumo();
    }
}
