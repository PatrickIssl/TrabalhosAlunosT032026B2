public class MaquinaRefrigerante {
    private int quantidadeEstoque;
    private double preco;
    private double dinheiroArrecadado;

    public MaquinaRefrigerante(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = 4.50;
        this.dinheiroArrecadado = 0.0;
    }

    public void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }
        if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente. Disponível: " + quantidadeEstoque);
            return;
        }
        double total = quantidade * preco;
        if (valorPago < total) {
            System.out.printf("Dinheiro insuficiente. Total: R$ %.2f, pago: R$ %.2f%n", total, valorPago);
            return;
        }
        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += total;
        System.out.printf("Compra realizada: %d refrigerante(s) por R$ %.2f%n", quantidade, total);
        double troco = valorPago - total;
        if (troco > 0) {
            System.out.printf("Troco: R$ %.2f%n", troco);
        }
    }

    public void reporEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade de reposição inválida.");
            return;
        }
        quantidadeEstoque += quantidade;
        System.out.println("Estoque reposto em " + quantidade + " unidade(s).");
    }

    public void exibirEstado() {
        System.out.println("--- Estado da Máquina ---");
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n", dinheiroArrecadado);
    }

    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante(5);
        maquina.comprar(2, 10.00);   // compra com troco
        maquina.comprar(10, 50.00);  // falta de estoque
        maquina.exibirEstado();
    }
}