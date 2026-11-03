package atividade5;

public class Pedido {
	private String nomeCliente;
	private int quantidadeLanches;
	private double precoLanche = 18.0;
	private double taxaEntrega = 7.0;
	private String status = "Pedido Aceito";
	 
	public Pedido(String nomeCliente) {
		super();
		this.nomeCliente = nomeCliente;
	}

	public boolean adicionarLanches(int quantidade) {
		if(status.equals("Finalizado")) {
			System.out.println("Pedidos finalizados não podem adicionar lanches.");
			return false;
		}
		if(quantidade <= 0) {
			System.out.println("Quantidade inválida.");
			return false;
		}
		quantidadeLanches += quantidade;
		return true;
	}
	
	public double calcularTotal() {
		double valorLanches = quantidadeLanches * precoLanche;
		if(quantidadeLanches >= 3) {
			valorLanches = valorLanches * 0.9;
		}
		return valorLanches + taxaEntrega;
	}
	
	public void finalizarPedido() {
		status = "Finalizado";
	}
	
	public void exibirPedido() {
		System.out.println("Nome: " + nomeCliente);
		System.out.println("Quantidade de lanches = " + quantidadeLanches);
		System.out.println("Taxa de entrega = " + taxaEntrega);
		System.out.println("Total à pagar = " + calcularTotal());
		System.out.println("Status = " + status);
	}
}
