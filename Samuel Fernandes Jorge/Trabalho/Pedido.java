public class Pedido {

    private String cliente, status = "Aberto";
    private int lanches;
    private double preco = 18.00, taxa = 7.00;

    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public void adicionarLanches(int qtd) {
        if (status.equals("Finalizado")) {
            System.out.println("Erro: pedido finalizado, não é possível adicionar lanches.");
        } else if (qtd > 0) {
            lanches += qtd;
            System.out.println(qtd + " lanche(s) adicionado(s).");
        } else {
            System.out.println("Erro: a quantidade deve ser maior que zero.");
        }
    }

    public double calcularTotal() {
        double valor = lanches * preco;
        if (lanches >= 3) {
            valor *= 0.90;
        }
        return valor + taxa;
    }

    public void finalizarPedido() {
        status = "Finalizado";
    }

    public void exibirPedido() {
        System.out.println("Cliente: " + cliente + " | Lanches: " + lanches + " | Status: " + status);
        System.out.println("Total: R$ " + calcularTotal());
    }

    public static void main(String[] args) {
        Pedido p = new Pedido("Carlos");

        p.adicionarLanches(2);
        p.adicionarLanches(1);
        p.finalizarPedido();
        p.exibirPedido();

        p.adicionarLanches(1);
    }
}