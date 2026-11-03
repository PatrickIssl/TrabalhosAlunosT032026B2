class Pedido {
    String nomeCliente;
    int quantidadeLanches;
    double precoLanche;
    double taxaEntrega;
    String status;

    Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        quantidadeLanches = 0;
        precoLanche = 18.00;
        taxaEntrega = 7.00;
        status = "Aberto";
    }

    void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Nao e possivel adicionar lanches. Pedido finalizado.");
        } else if (quantidade <= 0) {
            System.out.println("A quantidade deve ser positiva.");
        } else {
            quantidadeLanches += quantidade;
            System.out.println(quantidade + " lanche(s) adicionado(s).");
        }
    }

    double calcularTotal() {
        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            total = total - (total * 0.10);
        }

        if (quantidadeLanches > 0) {
            total += taxaEntrega;
        }

        return total;
    }

    void finalizarPedido() {
        if (quantidadeLanches > 0) {
            status = "Finalizado";
            System.out.println("Pedido finalizado.");
        } else {
            System.out.println("Adicione lanches antes de finalizar.");
        }
    }

    void exibirPedido() {
        System.out.println("\n--- Dados do Pedido ---");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.printf("Preco por lanche: R$ %.2f%n", precoLanche);
        System.out.printf("Taxa de entrega: R$ %.2f%n", taxaEntrega);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + status);
    }
}

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Nathan");

        pedido.adicionarLanches(2);
        pedido.adicionarLanches(1);

        pedido.exibirPedido();

        pedido.finalizarPedido();

        pedido.adicionarLanches(1);

        pedido.exibirPedido();
    }
}