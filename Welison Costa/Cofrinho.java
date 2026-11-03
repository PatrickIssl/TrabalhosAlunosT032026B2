package trabalhoSegundoSemestre;

public class Cofrinho {
    public static void main(String[] args) {
        Metodos meusMetodos = new Metodos();
        
        meusMetodos.nomeCliente = "Maria";
        meusMetodos.pedidoFinalizado = false; 
        meusMetodos.quantidadeLanches = 0;
        
        meusMetodos.adicionarLanches(2);
        meusMetodos.adicionarLanches(1);
        
        meusMetodos.exibirPedido();
        
        meusMetodos.finalizarPedido();
        
        System.out.println("\nTentando adicionar mais 1 lanche...");
        meusMetodos.adicionarLanches(1);
    }
}