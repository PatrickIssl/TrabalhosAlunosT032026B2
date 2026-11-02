
package trabalhoDupla;

public class Pedido {

    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche;
    private double taxaEntrega;
    private String status;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        quantidadeLanches = 0;
        precoLanche = 18.00;
        taxaEntrega = 7.00;
        status = "Em andamento";
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public int getQuantidadeLanches() {
        return quantidadeLanches;
    }
    public double getPrecoLanche() {
        return precoLanche;
    }
    public double getTaxaEntrega() {
        return taxaEntrega;
    }
    public String getStatus() {
        return status;
    }

    public void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Não é possível adicionar lanches, pedido finalizado");
            return;
        }
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero");
            return;
        }
        quantidadeLanches = quantidadeLanches + quantidade;
        System.out.println("Lanches adicionados ao pedido");
    }

    public double calcularTotal() {
        double total = quantidadeLanches * precoLanche;
        if (quantidadeLanches >= 3) {
            total = total - (total * 0.10);
        }
        total = total + taxaEntrega;
        return total;
    }

    public void finalizarPedido() {
        if (quantidadeLanches <= 0) {
            System.out.println("Adicione lanches antes de finalizar o pedido");
            return;
        }
        status = "Finalizado";
        System.out.println("Pedido finalizado");
    }

    public void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.println("Preço por lanche: R$ " + precoLanche);
        System.out.println("Taxa de entrega: R$ " + taxaEntrega);
        System.out.println("Status: " + status);
        System.out.printf("Total do pedido: R$ %.2f \n", calcularTotal());
    }
}
