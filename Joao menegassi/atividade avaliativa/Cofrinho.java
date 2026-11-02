package estacionamento;

public class Cofrinho {

	private String dono;
	private double saldo;
	private double metaEconomia;

	public Cofrinho(String dono, double metaEconomia) {
		this.dono = dono;
		this.metaEconomia = metaEconomia;
		this.saldo = 0;
	}

	public void depositar(double valor) {
		if (valor <= 0) {
			System.out.println("Erro: o depósito deve ser de um valor positivo.");
		} else {
			saldo += valor;
			System.out.printf("Depósito de R$ %.2f realizado.%n", valor);
		}
	}

	public void retirar(double valor) {
		if (valor <= 0) {
			System.out.println("Erro: o valor da retirada deve ser positivo.");
		} else if (valor > saldo) {
			System.out.printf("Erro: saldo insuficiente. Saldo: R$ %.2f, retirada: R$ %.2f%n", saldo, valor);
		} else {
			saldo -= valor;
			System.out.printf("Retirada de R$ %.2f realizada.%n", valor);
		}
	}

	public void verificarMeta() {
		if (saldo >= metaEconomia) {
			System.out.println("Parabéns! A meta de economia foi atingida.");
		} else {
			System.out.printf("A meta ainda não foi atingida. Faltam R$ %.2f.%n", metaEconomia - saldo);
		}
	}

	public void exibirSaldo() {
		System.out.println("Dono: " + dono);
		System.out.printf("Saldo: R$ %.2f%n", saldo);
		System.out.printf("Meta de economia: R$ %.2f%n", metaEconomia);
	}
}