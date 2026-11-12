import java.util.Scanner;

class MaquinaRefrigerante {
    private int quantidadeEstoque;
    private double preco;
    private double dinheiroArrecadado;

    public MaquinaRefrigerante (int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = 4.50;
        this.dinheiroArrecadado = 0.0;
    }

    public void comprar(int quantidade, double valorPago){
        if (quantidade <= 0){
            System.out.println("Erro: quantidade invalida");
            return;
        }
        if (quantidade > quantidadeEstoque){
            System.out.println("Erro: estoque insuficiente");
            return;
        }

        double total = quantidade * preco;

        if (valorPago < total){
            System.out.println("Erro: dinheiro insuficiente");
            return;
        }

        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += total;
        System.out.printf("Compra realizada! Total: R$ %.2f\n", total);

        if (valorPago > total){
            System.out.printf("Troco: R$ %.2f\n", valorPago - total);
        }
    }

    public void reporEstoque(int quantidade){
        if (quantidade <= 0){
            System.out.println("Erro: quantidade invalida");
            return;
        }
        quantidadeEstoque += quantidade;
    }

    public void exibirEstado(){
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.printf("Preco: R$ %.2f\n", preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f\n", dinheiroArrecadado);
    }
}

public class Atv02 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Estoque inicial:");
        int estoque = Integer.parseInt(sc.nextLine());

        MaquinaRefrigerante maquina = new MaquinaRefrigerante(estoque);

        System.out.println("Compra 1 - quantidade:");
        int quantidade1 = Integer.parseInt(sc.nextLine());
        System.out.println("Compra 1 - valor pago:");
        double valor1 = Double.parseDouble(sc.nextLine());
        maquina.comprar(quantidade1, valor1);

        System.out.println("Compra 2 - quantidade:");
        int quantidade2 = Integer.parseInt(sc.nextLine());
        System.out.println("Compra 2 - valor pago:");
        double valor2 = Double.parseDouble(sc.nextLine());
        maquina.comprar(quantidade2, valor2);

        maquina.exibirEstado();

        sc.close();
    }
}
