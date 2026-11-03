package trabalhoSegundoSemestre;

public class MaquinaRefrigerante {

    public static void main(String[] args) {
        Metodos maquina = new Metodos();

        maquina.reporEstoque(5);
        maquina.exibirEstado();

        System.out.println("Tentando comprar 2 refrigerantes com 10 reais:");
        maquina.comprar(2, 10.00f);
        maquina.exibirEstado();

        System.out.println("Tentando comprar 1 refri com só 3 reais:");
        maquina.comprar(1, 3.00f);
        maquina.exibirEstado();

        System.out.println("Tentando comprar 5 de uma vez:");
        maquina.comprar(5, 30.00f);
        maquina.exibirEstado();
    }
}