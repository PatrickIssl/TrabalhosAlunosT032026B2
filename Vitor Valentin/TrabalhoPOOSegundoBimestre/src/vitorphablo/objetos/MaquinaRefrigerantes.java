package vitorphablo.objetos;

public class MaquinaRefrigerantes {
    private int quantidadeEstoque;
    private final double PRECO = 4.5;
    private double dinheiroArrecadado;

    public MaquinaRefrigerantes (int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;

    }

    public void comprar (int quantidade, double valorPago){
        if(quantidade <= 0){
            System.out.println("Quantidade não pode ser menor ou igual a zero");
            return;
        }

        if(quantidadeEstoque - quantidade < 0){
            System.out.println("Quantidade digitada maior que o estoque atual");
            return;
        }

        if(quantidade * PRECO > valorPago){
            System.out.println("Valor insuficiente");
            return;
        }

        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += quantidade * PRECO;

        if(valorPago > quantidade * PRECO){
            System.out.println("Troco de R$" + (valorPago - (quantidade * PRECO)));
        }
    }

    public void reporEstoque (int quantidade){
        if(quantidade <= 0){
            System.out.println("Quantidade não pode ser menor ou igual a zero");
            return;
        }

        quantidadeEstoque += quantidade;
    }

    public void exibirEstado (){
        System.out.println("=-=-= ESTADO =-=-=");
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("Valor arrecadado: R$ " + dinheiroArrecadado);
    }
}
