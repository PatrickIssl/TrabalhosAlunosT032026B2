
public class MaquinaRefrigerante {

	private int quantidadeEstoque;
	private double preco;
	private double dinheiroArrecadado;
	
	public MaquinaRefrigerante() {
		preco = 4.50;
	}
	
	public MaquinaRefrigerante(int quantidadeEstoque, double preco, double dinheiroArrecadado) {
		
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
		this.dinheiroArrecadado = dinheiroArrecadado;
		
	}
	
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
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
	
	
	public void comprar(int quantidade, double valorPago) {
		
		if(quantidadeEstoque > quantidade) {
			double precoCompra = quantidade * preco;
			
			if(precoCompra == valorPago) {
				System.out.println("Compra efetuada!");
				dinheiroArrecadado += precoCompra;
				quantidadeEstoque -= quantidade;
			}
			else if(valorPago < precoCompra) {
				System.out.println("Compra negada! Saldo Insuficiente");
			}
			else {
				double troco = valorPago - precoCompra;
				System.out.println("Compra efetuada! Troco de R$" + troco);
				dinheiroArrecadado += precoCompra;
				quantidadeEstoque -= quantidade;
			}
		}
		else {
			System.out.println("Sem estoque");
		}
		
	}
	
	public void reporEstoque(int quantidade) {
		
		if(quantidade > 0) {
			quantidadeEstoque += quantidade;
		}
		else {
			System.out.println("ERRO! INSIRA VALOR VALIDO");
		}
		
	}
	
	public void exibirEstado() {
		
		System.out.println("Preço do refrigerante: " + preco);
		System.out.println("Quantidade no estoque: " + quantidadeEstoque);
		System.out.println("Dinheiro arrecadado: " + dinheiroArrecadado);
		
		
		
	}
	
	
	
	
}
