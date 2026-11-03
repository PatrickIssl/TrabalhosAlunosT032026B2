package aluno;


public class MaquinaDeRefrigerante {

    private int quantidadeEstoque;
    private double preco;
    private double dinheiroArrecadado;


    public MaquinaDeRefrigerante() {
        this.quantidadeEstoque = 0;
        this.preco = 4.50;
    }


    public void reporEstoque(int quantidade) {

        this.quantidadeEstoque = quantidadeEstoque + quantidade;


    }

    public void comprar(int quantidade, double valorPago) {
        double custoTotal = quantidade * this.preco;
        if (quantidade <= this.quantidadeEstoque) {

            if (valorPago >= custoTotal) {

                this.quantidadeEstoque = this.quantidadeEstoque - quantidade;
                this.dinheiroArrecadado = this.dinheiroArrecadado + custoTotal;

                double troco = valorPago - custoTotal;
                System.out.println("Compra realizada com sucesso. Seu troco é: R$ " + troco);

            } else {
                System.out.println("Dinheiro insuficiente para compra");
            }
        } else {
            System.out.println("Desculpa, não temos estoque disponivel");

        }
    }

    public void exibirEstado() {

        System.out.println("--- ESTADO DA MÁQUINA ---");
        System.out.println("Estoque atual: " + this.quantidadeEstoque + " unidades");
        System.out.println("Preço:  " + this.preco);
        System.out.println("Dinheiro areccadado:  " + this.dinheiroArrecadado);
        System.out.println("-----------------------");

    }

}




















