public class Estacionamento {

    private final String placa;
    private String modelo;
    private int minutosEstacionado;
    private double valorPago;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.minutosEstacionado = 0;
        this.valorPago = 0.0;
    }

    public void addtempo(int minutos) {
        if (minutos >= 0) {
            this.minutosEstacionado += minutos;
        } else {
            System.out.println("erro, o valor não pode ser negativo.");
        }
    }

    public void calculaValor() {
        if (this.minutosEstacionado <= 30) {
            this.valorPago = 5.00;
        } else {
            this.valorPago = 5.00 + (this.minutosEstacionado - 30) * 0.10;
        }
        this.valorPago = Math.min(this.valorPago, 30);
    }

    public void exibirRespostas() {
        System.out.println("placa: " + this.placa);
        System.out.println("modelo: " + this.modelo);
        System.out.println("minutosEstacionado: " + this.minutosEstacionado + " min");
        System.out.printf("valorPago é R$ %.2f%n", this.valorPago);
    }

    public static void main(String[] args) {
        Estacionamento carro = new Estacionamento("ABC-1234", "Honda Civic");

        carro.addtempo(45);
        carro.addtempo(60);
        carro.calculaValor();
        carro.exibirRespostas();
    }
}