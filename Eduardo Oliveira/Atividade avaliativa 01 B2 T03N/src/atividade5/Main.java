package atividade5;


public class Main {

	public static void main(String[] args) {
		Pedido p = new Pedido("Eduardo Oliveira");
		
		p.adicionarLanches(2);
		p.adicionarLanches(2);
		System.out.println("Total do pedido: " + p.calcularTotal());
		p.finalizarPedido();
		p.exibirPedido();
		System.out.println("------------");
		if(p.adicionarLanches(1)) {
			System.out.println("Operação permitida.");
		} else {
			System.out.println("Operação não permitida.");
		}
		
	}

}
