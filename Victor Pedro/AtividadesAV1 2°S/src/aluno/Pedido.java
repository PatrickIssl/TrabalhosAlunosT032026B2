package aluno;

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
        this.status = "aberto";


    }

    public void adicionarLanche(int quantidade) {
        if (this.status.equals("aberto")) {


            this.quantidadeLanches += quantidade;
            System.out.println("Lanche adicionado " + quantidade);

        } else {
            System.out.println("Pedido já foi finalizado");
        }

    }

    public double calcularTotal() {

        double valorTotal = this.quantidadeLanches * this.precoLanche;

        if (quantidadeLanches >= 3) {

            double valorDesconto = valorTotal * 0.10;

            valorTotal = valorTotal - valorDesconto;
        }

        valorTotal = valorTotal + this.taxaEntrega;
        return valorTotal;


    }

    public void finalizarPedido() {
        this.status = "finalizado";
    }


    public void exibirPedido() {
        System.out.println("Nome: " + this.nomeCliente);
        System.out.println("Quantidade lanches: " + this.quantidadeLanches);
        System.out.println("Status: " + this.status);
        System.out.println("Valor total: R$  " + this.calcularTotal());
    }
}




