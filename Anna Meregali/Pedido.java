package avaliacao;

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
    //get
    public String getNomeCliente() {
        return nomeCliente;
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
    //set
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }  
    //metodos
    public void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Operação não permitida! O pedido já foi finalizado");
        } 
        else if (quantidade <= 0) {
            System.out.println("Quantidade inválida! Deve ser maior que zero");
        } 
        else {
            quantidadeLanches += quantidade;
            System.out.println(quantidade + " lanche(s) adicionado(s) com sucesso");
        }
    }

    public double calcularTotal() {
        double valorLanches = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            valorLanches = valorLanches * 0.90;
        }
        
        return valorLanches + taxaEntrega;
    }

    public void finalizarPedido() {
        status = "Finalizado";
        System.out.println("Pedido finalizado!");
    }
    
    public void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.println("Preço do lanche: R$ " + precoLanche);
        System.out.println("Taxa de entrega: R$ " + taxaEntrega);
        System.out.println("Status: " + status);
        System.out.println("Total: R$ " + calcularTotal());
        System.out.println();
    }
}
