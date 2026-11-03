
public class Program {

	public static void main(String[] args) {
		
		Pedido pedido = new Pedido ("Neymar");
		
		pedido.adicionarLanches(3);
		pedido.adicionarLanches(1);
		
		pedido.calcularTotal();
		pedido.finalizarPedido();
		
		pedido.adicionarLanches(1);
		
		pedido.exibirPedido();
	}

}
