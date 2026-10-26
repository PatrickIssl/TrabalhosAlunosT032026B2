
package fag;

public class MaquinaRefrigerante {

    int quantidadeEstoque;
    double preco = 4.5;
    double dinheiroArrecadado;

    public void Comprar(int quantidade, double valorpago) {
        double total = quantidade * preco;

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida");
            return;
        }

        if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente");
            return;
        }

        if (valorpago < total) {
            System.out.println("Saldo insuficiente");
            return;
        }

        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += total;

        double troco = valorpago - total;

        System.out.printf("Troco: R$ %.2f%n", troco);
        System.out.println("Compra realizada com sucesso!");
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
            System.out.println("Estoque reposto!");
        } else {
            System.out.println("Quantidade inválida");
        }
    }

    public void exibirEstado() {
        System.out.printf("Estoque: %d%n", quantidadeEstoque);
        System.out.printf(
            "Dinheiro arrecadado: R$ %.2f%n",
            dinheiroArrecadado
        );
    }
}
