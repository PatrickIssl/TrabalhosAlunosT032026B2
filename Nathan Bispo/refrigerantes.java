class MaquinaRefrigerante {
    int quantidadeEstoque;
    double preco;
    double dinheiroArrecadado;

    MaquinaRefrigerante() {
        quantidadeEstoque = 10;
        preco = 4.50;
        dinheiroArrecadado = 0;
    }

    void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Quantidade invalida!");
        } else if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente!");
        } else {
            double total = quantidade * preco;

            if (valorPago < total) {
                System.out.println("Dinheiro insuficiente!");
            } else {
                quantidadeEstoque -= quantidade;
                dinheiroArrecadado += total;

                double troco = valorPago - total;

                System.out.println("Compra realizada com sucesso!");
                System.out.printf("Total: R$ %.2f%n", total);
                System.out.printf("Troco: R$ %.2f%n", troco);
            }
        }
    }

    void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
            System.out.println("Estoque reposto com sucesso!");
        } else {
            System.out.println("Quantidade invalida!");
        }
    }

    void exibirEstado() {
        System.out.println("\n--- Estado da Maquina ---");
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.printf("Preco: R$ %.2f%n", preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n",
                dinheiroArrecadado);
    }
}

public class MaquinaRefrigerante {
    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        System.out.println("--- Primeira compra ---");
        maquina.comprar(2, 10.00);

        System.out.println("\n--- Segunda compra ---");
        maquina.comprar(3, 5.00);

        maquina.exibirEstado();
    }
}