package atividade4;


public class Cofrinho {
	private String dono;
	private double saldo;
	private double metaEconomia;
	
	public Cofrinho(String dono, double metaEconomia) {
		super();
		this.dono = dono;
		this.metaEconomia = metaEconomia;
	}

	public void depositar(double valor) {
	
		if(valor <= 0) {
			System.out.println("Inválido! Valor deve ser positivo.");
			return;
		}
		saldo += valor;
	}
	
	public void retirar(double valor) {
		if(valor <= 0) {
			System.out.println("Inválido! Valor deve ser positivo.");
			return;
		}

		if(valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Inválido! Saldo insuficiente.");
		}
	}
	
	public void verificarMeta() {
		if(saldo >= metaEconomia){
			System.out.println("Meta alcançada!!!");
		} else {
			System.out.println("Valor que falta para a meta: " + (metaEconomia - saldo));
		}
	}
	
	public void exibirSaldo( ) {
		System.out.println("Saldo = " + saldo);
	}
}
