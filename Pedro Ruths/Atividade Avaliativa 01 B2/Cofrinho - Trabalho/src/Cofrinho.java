
public class Cofrinho {

	private String dono;
	private double saldo;
	private double metaEconomia;
	
	public Cofrinho() {}
	
	public Cofrinho(String dono, double saldo, double metaEconomia) {
		
		this.dono = dono;
		this.saldo = saldo;
		this.metaEconomia = metaEconomia;
		
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getMetaEconomia() {
		return metaEconomia;
	}
	
	public void depositar(double valor) {
		
		if (saldo > 0) {
			saldo += valor;
		}
		else {
			System.out.println("ERRO ! Valor inválido");
		}
		
	}
	
	public void retirar(double valor) {
		
		if (saldo >= valor) {
			saldo -= valor;
		}
		else {
			System.out.println("ERRO! Saldo insuficiente");
		}
			
	}
	
	public void verificarMeta() {
		
		if(saldo >= metaEconomia) {
			System.out.println("Parabéns! sua meta de R$" + metaEconomia + " foi alcançada");
		}
		else {
			System.out.println("Sua meta ainda não foi atingida, faltam R$" + (metaEconomia - saldo));
		}
		
	}
	
	public void exibirSaldo() {
		
		System.out.println("Saldo atual R$" + saldo);
		
	}
	
	
}
