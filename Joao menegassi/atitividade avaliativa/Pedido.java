package estacionamento;

public class Pedido {

	private String nomeCliente;
	private int quantidadeLanches;
	private double precoLanche;
	private double taxaEntrega;
	private String status;

	public Pedido(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		this.quantidadeLanches = 0;
		this.precoLanche = 18.00;
		this.taxaEntrega = 7.00;
		this.status = "Aberto";
	}


	public boolean adicionarLanches(int quantidade) {
		if (status.equals("Finalizado")) {
			System.out.println("Operação não permitida: o pedido já foi finalizado.");
			return false;
		}
		if (quantidade <= 0) {
			System.out.println("Operação não permitida: a quantidade deve ser maior que zero.");
			return false;
		}
		quantidadeLanches += quantidade;
		System.out.println(quantidade + " lanche(s) adicionado(s) ao pedido.");
		return true;
	}

	public double calcularTotal() {
		double valorLanches = quantidadeLanches * precoLanche;
		if (quantidadeLanches >= 3) {
			valorLanches = valorLanches * 0.90; 
		}
		return valorLanches + taxaEntrega;
	}

	public void finalizarPedido() {
		status = "Finalizado";
		System.out.println("Pedido finalizado.");
	}

	public void exibirPedido() {
		System.out.println("===== Pedido =====");
		System.out.println("Cliente: " + nomeCliente);
		System.out.println("Quantidade de lanches: " + quantidadeLanches);
		System.out.printf("Preço do lanche: R$ %.2f%n", precoLanche);
		System.out.printf("Taxa de entrega: R$ %.2f%n", taxaEntrega);
		System.out.println("Status: " + status);
		System.out.printf("Total: R$ %.2f%n", calcularTotal());
	}
}