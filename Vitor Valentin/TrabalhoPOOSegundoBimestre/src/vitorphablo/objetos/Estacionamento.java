package vitorphablo.objetos;

public class Estacionamento {
    private String placa;
    private String modelo;
    private int minutosEstacionado;
    private double valorPago;

    public Estacionamento(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.minutosEstacionado = 0;
    }

    public void adicionarTempo(int minutos) {
        if (minutos <= 0) {
            System.out.println("[-] O tempo fornecido deve ser maior que 0");
            return;
        };

        minutosEstacionado += minutos;
    }

    public void calcularValor() {
        this.valorPago = Math.min(30, Math.max(0, (minutosEstacionado - 30) * 0.1) + 5);
    }

    public void exibirResumo() {
        System.out.println("=-=-= RESUMO =-=-=");
        System.out.println("Minutos Estacionado: " + minutosEstacionado);
        System.out.println("Valor à Pagar: R$ " + valorPago);
    }
}
