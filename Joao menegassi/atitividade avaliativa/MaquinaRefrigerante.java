package estacionamento;

public class MaquinaRefrigerante {

	private int quantidadeEstoque;
	private double preco;
	private double dinheiroArrecadado;

	public MaquinaRefrigerante(int estoqueInicial) {
		preco = 4.50;
		quantidadeEstoque = estoqueInicial;
		dinheiroArrecadado = 0;
	}

	public void exibirEstado() {
		System.out.println("Estoque: " + quantidadeEstoque);
		System.out.printf("Preço: R$ %.2f%n", preco);
		System.out.printf("Dinheiro arrecadado: R$ %.2f%n", dinheiroArrecadado);
	}

	public void reporEstoque(int quantidade) {
		if (quantidade <= 0) {
			System.out.println("Erro: quantidade inválida para reposição.");
		} else {
			quantidadeEstoque += quantidade;
		}
	}

	public void comprar(int quantidade, double valorPago) {
		double total = quantidade * preco;

		if (quantidade > quantidadeEstoque) {
			System.out.println("Erro: estoque insuficiente.");
		} else if (valorPago < total) {
			System.out.printf("Erro: dinheiro insuficiente. Total: %.2f, pago: %.2f%n", total, valorPago);
		} else {
			quantidadeEstoque -= quantidade;
			dinheiroArrecadado += total;
			System.out.printf("Compra realizada! Troco: R$ %.2f%n", valorPago - total);
		}
	}
}