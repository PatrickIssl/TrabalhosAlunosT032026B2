
package fag;

public class Pedido {
    String nomeCliente;
    int quantidadeLanches;
    double precoLanche = 18.00;
    double taxaEntrega = 7.00;
    String status = "Aberto";

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        quantidadeLanches = 0;
    }

    public void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Pedido ja finalizado");
        } else if (quantidade > 0) {
            quantidadeLanches += quantidade;
        } else {
            System.out.println("Quantidade errada");
        }
    }

    public double calcularTotal() {
        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            total *= 0.90;
        }

        if (quantidadeLanches > 0) {
            total += taxaEntrega;
        }

        return total;
    }

    public void finalizarPedido() {
        if (quantidadeLanches > 0) {
            status = "Finalizado";
            System.out.println("Pedido finalizado");
        } else {
            System.out.println("Adicione os lanche");
        }
    }

    public void exibirPedido() {
        System.out.println("\nCliente: " + nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + status);
    }
}
