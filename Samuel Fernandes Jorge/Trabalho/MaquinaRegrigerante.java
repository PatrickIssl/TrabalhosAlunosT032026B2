public class MaquinaRefrigerante {

    private int estoque;
    private double preco;
    private double caixa;

    public MaquinaRefrigerante(int estoque) {
        this.estoque = estoque;
        this.preco = 4.50;
        this.caixa = 0.0;
    }

    public void comprar(int qtd, double pago) {
        double total = qtd * this.preco;

        if (qtd <= 0) {
            System.out.println("Erro: a quantidade deve ser maior que zero.");
        } else if (qtd > this.estoque) {
            System.out.println("Erro: estoque insuficiente.");
        } else if (pago < total) {
            System.out.println("Erro: dinheiro insuficiente.");
        } else {
            this.estoque -= qtd;
            this.caixa += total;
            System.out.println("Compra realizada com sucesso!");
            if (pago > total) {
                System.out.printf("Troco: R$ %.2f%n", pago - total);
            }
        }
    }

    public void reporEstoque(int qtd) {
        if (qtd > 0) {
            this.estoque += qtd;
        } else {
            System.out.println("Erro: a quantidade para repor deve ser maior que zero.");
        }
    }

    public void exibirEstado() {
        System.out.println("Estoque: " + this.estoque);
        System.out.printf("Preço: R$ %.2f%n", this.preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n", this.caixa);
    }

    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante(5);

        System.out.println("--- Compra 1 ---");
        maquina.comprar(2, 10.00);

        System.out.println();
        System.out.println("--- Compra 2 ---");
        maquina.comprar(10, 50.00);

        System.out.println();
        maquina.exibirEstado();
    }
}