package atividade2;


public class MaquinaRefrigerante {
	private int quantidadeEstoque;
	private double preco = 4.5;
	private double dinheiroArrecadado;
	
	public void comprar(int quantidade, double valorPago) {

		if(!checkZero(quantidade)) {
			return;
		}
		double valorDaCompra = quantidade * preco;
		if(valorPago < valorDaCompra) {
			System.out.println("Dinheiro insuficiente");
			return;
		}
		if(quantidadeEstoque < quantidade) {
			System.out.println("Estoque insuficiente");
			return;
		}
		if(valorPago > valorDaCompra) {
			System.out.println("Troco = " + (valorPago - valorDaCompra));
		}

		dinheiroArrecadado += valorDaCompra;
		quantidadeEstoque -= quantidade;
	}
	
	private boolean checkZero(int quantidade) {
		
		if(quantidade <= 0) {
			System.out.println("Erro! Quantidade deve ser maior que zero.");
			return false;
		}
		return true;
	}
	
	public void reporEstoque(int quantidade) {
		if(!checkZero(quantidade)) {
			return;
		}
		quantidadeEstoque += quantidade;
	}
	
	public void exibirEstado() {
		System.out.println("Estoque da maquina: " + quantidadeEstoque);
		System.out.println("Dinheiro arrecadado pela máquina: " + dinheiroArrecadado);
	}
	
	
}
