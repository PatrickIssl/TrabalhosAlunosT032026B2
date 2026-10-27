package aluno;

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
		if (minutos > 0) {
			this.minutosEstacionado += minutos;
		} else {
			System.out.println("Erro: valor invalido. O tempo não pode ser negativo.");
		}
	}

	public void calcularValor() {
		if (this.minutosEstacionado <= 0) {
			this.valorPago = 0.0;
			return;
		}
		double total = 5.0;
		if (this.minutosEstacionado > 30) {
			int minutosAdicionais = this.minutosEstacionado - 30;
			total += minutosAdicionais * 0.10;
		}
		if (total > 30.00) {
			total = 30.00;
		}
		this.valorPago = total;
	}

	public void exibirResumo() {
		if (this.minutosEstacionado > 0) {
			System.out.println("\n-- RESUMO DO ESTACIONAMENTO --");
			System.out.println("Placa: " + this.placa);
			System.out.println("Modelo: " + this.modelo);
			System.out.println("Minutos Estacionados: " + this.minutosEstacionado);
			System.out.printf("Valor a Pagar: R$ %.2f\n", this.valorPago);
		}
	}
}
