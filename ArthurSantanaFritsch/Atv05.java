import java.util.Scanner;

class Pedido {
    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche;
    private double taxaEntrega;
    private String status;

    public Pedido (String nomeCliente){
        this.nomeCliente = nomeCliente;
        this.quantidadeLanches = 0;
        this.precoLanche = 18.00;
        this.taxaEntrega = 7.00;
        this.status = "Aberto";
    }

    public boolean adicionarLanches(int quantidade){
        if (status.equals("Finalizado")){
            System.out.println("Erro: pedido finalizado nao pode receber lanches");
            return false;
        }
        if (quantidade <= 0){
            System.out.println("Erro: quantidade invalida");
            return false;
        }
        quantidadeLanches += quantidade;
        return true;
    }

    public double calcularTotal(){
        double valorLanches = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3){
            valorLanches = valorLanches * 0.90;
        }

        return valorLanches + taxaEntrega;
    }

    public void finalizarPedido(){
        status = "Finalizado";
    }

    public void exibirPedido(){
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.printf("Taxa de entrega: R$ %.2f\n", taxaEntrega);
        System.out.println("Status: " + status);
        System.out.printf("Total: R$ %.2f\n", calcularTotal());
    }
}

public class Atv05 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do cliente:");
        String nome = sc.nextLine();

        Pedido pedido = new Pedido(nome);

        System.out.println("Quantidade de lanches (primeira operacao):");
        pedido.adicionarLanches(Integer.parseInt(sc.nextLine()));

        System.out.println("Quantidade de lanches (segunda operacao):");
        pedido.adicionarLanches(Integer.parseInt(sc.nextLine()));

        System.out.printf("Total: R$ %.2f\n", pedido.calcularTotal());

        pedido.finalizarPedido();

        boolean permitido = pedido.adicionarLanches(1);
        if (permitido){
            System.out.println("Operacao permitida");
        } else {
            System.out.println("Operacao nao permitida");
        }

        pedido.exibirPedido();

        sc.close();
    }
}
