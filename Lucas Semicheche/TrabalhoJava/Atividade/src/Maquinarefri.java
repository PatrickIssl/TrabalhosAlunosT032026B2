import java.util.Scanner;

public class Maquinarefri {

	private int qtdestoque;
	private double preco;
	private double saldomaq;
	
	public int getQtdestoque() {
		return qtdestoque;
	}

	public void setQtdestoque(int qtdestoque) {
		this.qtdestoque = qtdestoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getSaldomaq() {
		return saldomaq;
	}

	public void setSaldomaq(double saldomaq) {
		this.saldomaq = saldomaq;
	}

	public Maquinarefri (int estoqueinic) {
		this.qtdestoque = Math.max(estoqueinic, 0);
		this.preco = 4.50;
		this.saldomaq = 0.0;
		}
	
		public void compra(int qtd, double valorPago) {
		System.out.println("Informe a Quantidade: " + qtd);
        System.out.printf("Valor a pagar: R$ %.2f\n", valorPago);	
		
        if (qtd <= 0) {
            System.out.println("Erro: A quantidade de compra deve ser maior que zero.");
            return;
        }     
        if (qtd > this.qtdestoque) {
            System.out.println("Erro: Estoque insuficiente! Unidades disponíveis: " + this.qtdestoque);
            return;
        }        
        double custoTotal = qtd * this.preco;

        if (valorPago < custoTotal) {
        	System.out.printf("Erro: Dinheiro insuficiente! Total do pedido: R$ %.2f\n", custoTotal);
            return;
	
        }
        
        this.qtdestoque -= qtd;
        this.saldomaq += custoTotal;
        double troco = valorPago - custoTotal;

        System.out.println("Compra realizada com sucesso!");
        if (troco > 0) {
            System.out.printf("Seu troco: R$ %.2f\n", troco);
        } else {
            System.out.println("Não há troco.");
        }
        }
        public void exibirEstado() {
            System.out.println("Estoque atual: " + this.qtdestoque + " unidade(s)");
            System.out.printf("Preço por unidade: R$ %.2f\n", this.preco);
            System.out.printf("Total arrecadado: R$ %.2f\n", this.saldomaq);
        }
    
	
}
