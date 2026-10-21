package vitorphablo.objetos;

public class Pedido {
    private String nomeCliente;
    private int quantidadeLanches;
    private String status;

    private final double PRECO_LANCHE = 18;
    private final double TAXA_ENTREGA = 7;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.quantidadeLanches = 0;
        this.status = "AGUARDANDO PEDIDO";
    }

    public void adicionarLanches(int quantidade) {
        if (quantidade <= 0) {
            System.out.printf("\n[-] Você não pode adicionar menos de 1 lanche.");
            return;
        }
        if (status.equals("PEDIDO FINALIZADO")) {
            System.out.printf("\n[-] Você não pode adicionar mais lanches, este pedido já foi finalizado!");
            return;
        }

        quantidadeLanches += quantidade;
    }

    public void calcularTotal() {
        double total = 0;

        total += quantidadeLanches * PRECO_LANCHE;
        if (quantidadeLanches >= 3) total *= 0.9;
        total += TAXA_ENTREGA;

        System.out.printf("\n[+] Sub-total: %.2f", quantidadeLanches * PRECO_LANCHE);
        if (quantidadeLanches >= 3) {
            System.out.printf("\n[+] Desconto 10%%: %.2f", (quantidadeLanches * PRECO_LANCHE) * 0.1);
        }
        System.out.printf("\n[+] Taxa de Entrega: %.2f", TAXA_ENTREGA);
        System.out.printf("\n[?] Valor Total: %.2f", total);
    }

    public void finalizarPedido() {
        status = "PEDIDO FINALIZADO";
        System.out.printf("\n[+] Pedido finalizado! Saindo para entrega...");
    }

    public void exibirPedido() {
        System.out.printf("\n=-=-=-= PEDIDO =-=-=-=");
        System.out.printf("\n[+] Nome do Cliente: %s", nomeCliente);
        System.out.printf("\n[+] Status: %s", status);
        System.out.printf("\n[+] Quantidade de Lanches: %d", quantidadeLanches);
        calcularTotal();
    }
}
