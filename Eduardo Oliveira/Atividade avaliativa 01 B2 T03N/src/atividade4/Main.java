package atividade4;


public class Main {

	public static void main(String[] args) {
		Cofrinho c = new Cofrinho("Eduardo Oliveira", 300);
		
		c.depositar(150);
		c.depositar(200);
		c.exibirSaldo();
		c.retirar(30000);
		c.exibirSaldo();
		c.verificarMeta();
		System.out.println("------------");
		c.retirar(200);
		c.exibirSaldo();
		c.verificarMeta();
	}

}
