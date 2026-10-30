public class Pedido {
    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche;
    private double taxaEntrega;
    private String status;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.quantidadeLanches = 0;
        this.precoLanche = 18.00;
        this.taxaEntrega = 7.00;
        this.status = "Aberto";
    }

    public boolean adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Operação não permitida: o pedido já foi finalizado.");
            return false;
        }
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return false;
        }
        quantidadeLanches += quantidade;
        System.out.println(quantidade + " lanche(s) adicionado(s).");
        return true;
    }

    public double calcularTotal() {
        double valorLanches = quantidadeLanches * precoLanche;
        if (quantidadeLanches >= 3) {
            valorLanches *= 0.90; // desconto de 10%
        }
        return valorLanches + taxaEntrega;
    }

    public void finalizarPedido() {
        status = "Finalizado";
        System.out.println("Pedido finalizado.");
    }

    public void exibirPedido() {
        System.out.println("--- Pedido ---");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.printf("Taxa de entrega: R$ %.2f%n", taxaEntrega);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + status);
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido("Carlos");
        pedido.adicionarLanches(2);
        pedido.adicionarLanches(1);
        System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
        pedido.finalizarPedido();
        pedido.exibirPedido();

        boolean permitido = pedido.adicionarLanches(1);
        System.out.println("Adicionar lanche após finalizar foi permitido? " + (permitido ? "Sim" : "Não"));
    }
}
