public class Pedido {
    private String nomecliente;
    private int quantidadelanches;
    private double precolanche;
    private double taxaentrega;
    private String status;

    public Pedido(String cliente) {
        this.nomecliente = cliente;
        this.quantidadelanches = 0;
        this.precolanche = 18.00;
        this.taxaentrega = 7.00;
        this.status = "Aberto";
    }

    public void adicionarlanches(int quantidade) {
        if (this.status.equalsIgnoreCase("Finalizado")) {
            System.out.println("Operação não permitida: O pedido já está finalizado e não pode receber novos lanches.");
        } else if (quantidade > 0) {
            this.quantidadelanches += quantidade;
            System.out.printf("%d lanche(s) adicionado(s) com sucesso! Total atual: %d lanche(s).%n", quantidade, this.quantidadelanches);
        } else {
            System.out.println("A quantidade de lanches a adicionar deve ser maior que zero.");
        }
    }

    public double calculartotal() {
        double subtotal = this.quantidadelanches * this.precolanche;
        if (this.quantidadelanches >= 3) {
            subtotal *= 0.90;
        }
        return subtotal + this.taxaentrega;
    }

    public void finalizarpedido() {
        if (this.status.equalsIgnoreCase("Finalizado")) {
            System.out.println("O pedido já se encontra finalizado.");
        } else {
            this.status = "Finalizado";
            System.out.println("Pedido finalizado com sucesso!");
        }
    }

    public void exibirpedido() {
        System.out.println("RESUMO DO PEDIDO \n");
        System.out.println("Cliente: " + this.nomecliente);
        System.out.println("Quantidade de Lanches: " + this.quantidadelanches);
        System.out.printf("Preço unitário do lanche: R$ %.2f%n", this.precolanche);
        System.out.printf("Taxa de Entrega: R$ %.2f%n", this.taxaentrega);
        System.out.printf("Status: " + this.status + "\n");

        if (this.quantidadelanches >= 3) {
            System.out.println("\nDesconto aplicado: 10% de desconto nos lanches!");
        }

        System.out.printf("Valor Total: R$ %.2f%n", calculartotal());
    }

    public static void main(String[] args) {

        Pedido meuPedido = new Pedido("Carlos");

        System.out.println("Criando Pedido \n");
        meuPedido.exibirpedido();
        System.out.printf("%n");

        System.out.println("Adicionando Lanches");
        meuPedido.adicionarlanches(1);
        meuPedido.adicionarlanches(2);
        System.out.printf("%n");

        System.out.println("Detalhes e Cálculo do Total \n");
        meuPedido.exibirpedido();
        System.out.printf("%n");

        System.out.println("Finalizando Pedido \n");
        meuPedido.finalizarpedido();
        System.out.printf("%n");

        System.out.println("Tentativa de Adicionar Lanche em Pedido Finalizado");
        meuPedido.adicionarlanches(1);
    }
}