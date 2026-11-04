
public class Pedido {

	private String nomeCliente;
	private int quantidadeLanches;
	private double precoLanche;
	private double taxaEntrega;
	private boolean status;
	
	public Pedido() {}
	
	public Pedido(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		this.quantidadeLanches = 0;
		this.status = true;
		this.precoLanche = 18.00;
		this.taxaEntrega = 7.00;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getQuantidadeLanches() {
		return quantidadeLanches;
	}

	public double getPrecoLanche() {
		return precoLanche;
	}

	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void adicionarLanches(int quantidade) {
		
		if(quantidade > 0 && status) {
			quantidadeLanches += quantidade;
		}
		else if (status) {
			System.out.println("Erro! adicione um valor válido");
		}
		else {
			System.out.println("ERRO! Pedido finalizado");
		}
	}
	
	public void calcularTotal() {
		
		double total = 0;
		
		if(quantidadeLanches >= 3) {
			
			total = (quantidadeLanches * precoLanche) * 0.90;
		}
		else {
			total = (quantidadeLanches * precoLanche);
		}
		
		total += taxaEntrega;
		System.out.println("Total do Pedido: R$" + total);
		
	}
	
	public void finalizarPedido() {
		status = false;
		System.out.println("Pedido finalizado");	
	}
	
	public void exibirPedido() {
		
		System.out.println();
		System.out.println("Nome cliente: " + nomeCliente);
		System.out.println("Quantidade de lanches: " + quantidadeLanches);
		System.out.println("Preço unitário do lanche: R$ " + precoLanche);
		System.out.println("Taxa de entrega: R$" + taxaEntrega);
		calcularTotal();
		System.out.print("Status do pedido: ");
		if(status) {
			System.out.print("Aberto");
		}
		else {
			System.out.print("Finalizado");
		}
	}
	
	
	
	
}
