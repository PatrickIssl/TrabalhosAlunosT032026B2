package avaliacao;

public class MaquinaRefrigerante {
	private int quantidadeEstoque;
    private double preco = 4.50;
    private double dinheiroArrecadado = 0;

    // get
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public double getPreco() {
        return preco;
    }
    public double getDinheiroArrecadado() {
        return dinheiroArrecadado;
    }

    // set
    public void setQuantidadeEstoque(int quantidade) {
        if (quantidade >= 0) {
            this.quantidadeEstoque = quantidade;
        } else {
            System.out.println("Quantidade inválida!");
        }
    }

    // metodos
    public void comprar(int quantidade, double valorPago) {
        double total = preco * quantidade;
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida! Deve ser maior que zero");
        } else if (quantidade > quantidadeEstoque) {
            System.out.println("Não há produto suficiente em estoque");
        } else if (valorPago < total) {
            System.out.println("Valor insuficiente! O total é R$ " + total);
        } else {
            double troco = valorPago - total;
            quantidadeEstoque -= quantidade;
            dinheiroArrecadado += total;
            System.out.println("Compra realizada!");
            if (troco > 0) {
                System.out.println("Troco: R$ " + troco);
            }
        }
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
            System.out.println("Estoque reposto com " + quantidade + " unidade(s).");
        } else {
            System.out.println("Quantidade inválida! Deve ser maior que zero");
        }
    }

    public void exibirEstado() {
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
        System.out.println("Preço da unidade: R$ " + preco);
        System.out.println("Valor arrecadado: R$ " + dinheiroArrecadado);
        System.out.println();
    }
	
	
	
}
