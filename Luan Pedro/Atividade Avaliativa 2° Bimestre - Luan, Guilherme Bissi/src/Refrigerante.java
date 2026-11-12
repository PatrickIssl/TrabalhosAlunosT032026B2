public class Refrigerante {
    private double qntEstoque;
    private double preco;
    private double lucro;

    public void MaquinaRefrigerante(){
        qntEstoque = 0.0;
        preco = 4.50;
        lucro = 0.0;
    }

    public double comprar(int quantidade, double valorpago) {
        double total = quantidade * 4.5;
        
        if(quantidade <= 0){
            System.out.println("Quantidade invalida: ");
        } else if (quantidade > qntEstoque) {
            System.out.println("Estoque insuficiente.");
        } else if (valorpago < total) {
            System.out.printf("Dinheiro insuficiente: %.2f. Total: R$ %.2f \n", total);
        } else {
            qntEstoque -= quantidade;
            lucro += total;
            System.out.println("Compra realizada com sucesso!");
        
        
        double troco = valorpago - total;
        if (troco > 0) {
            System.out.printf("Troco: %.2f \n", troco);
        }
    }
    return valorpago;
}

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            qntEstoque += quantidade;
        }
    }
    
    public void exibirEstado() {
        System.out.println("Estoque atual: " + qntEstoque);
        System.out.printf("Preco: %.2f \n", preco);
        System.out.printf("Lucro: %.2f \n", lucro);
    }

    public static void main(String args[]){
        Refrigerante maquina = new Refrigerante();
        maquina.reporEstoque(10);

        maquina.comprar(2, 10.00);   // ok, troco R$ 1,00
        maquina.comprar(20, 100.00); // estoque insuficiente

        maquina.exibirEstado();
    }
}
