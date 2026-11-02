package trabalhoDupla;

public class MaquinaRefrigerante {
	private int quantidadeEstoque;
	private double preco;
	private double dinheiroArrecadado;
	
	public MaquinaRefrigerante() {
		preco = 4.50;
	}
	
	public MaquinaRefrigerante(int quantidadeEstoque, double dinheiroArrecadado) {
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = 4.50;
		this.dinheiroArrecadado = dinheiroArrecadado;
	}
	
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		if(quantidadeEstoque <= 0) {
			System.out.println("Não é possível adicionar 0 ou valores negativos no estoque");
			return;
		}
		this.quantidadeEstoque = this.quantidadeEstoque + quantidadeEstoque;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getDinheiroArrecadado() {
		return dinheiroArrecadado;
	}
	public void setDinheiroArrecadado(double dinheiroArrecadado) {
		this.dinheiroArrecadado = dinheiroArrecadado;
	}
	
	public void comprar(int quantidade, double valorPago) {
		if(quantidadeEstoque == 0) {
			System.out.println("O estoque está negativo");
			return;
	    }else if(quantidade <= 0) {
			System.out.println("Não é possivel comprar 0 ou itens negativos");
			return;
		}else if(quantidade > quantidadeEstoque) {
			System.out.println("Não é possivel comprar mais itens do que existe no estoque");
			return;
		}else {
			double valorTotal = quantidade * preco;
			if(valorPago < valorTotal) {
				System.out.println("Valor insuficiente");
				return;
			}else if(valorPago == valorTotal) {
				System.out.println("Compra realizada");
				quantidadeEstoque = quantidadeEstoque - quantidade;
				dinheiroArrecadado = dinheiroArrecadado + valorPago;
				return;
			}else {
				System.out.println("Compra realizada - Troco de " + (valorPago - (quantidade * preco)));
				quantidadeEstoque = quantidadeEstoque - quantidade;
				dinheiroArrecadado = dinheiroArrecadado + (quantidade * preco);
				return;
			}
		}
	}
	
	public void exibirEstado() {
		System.out.println("Quantidade Estoque: " + quantidadeEstoque);
		System.out.println("Preço refrigerenate: " + preco);
		System.out.println("Dinheiro arrecadado: " + dinheiroArrecadado);
	}
}
