package atividade2;



public class Main {

	public static void main(String[] args) {
		MaquinaRefrigerante maquina = new MaquinaRefrigerante();
		maquina.reporEstoque(15);
		maquina.comprar(5, 25);
		maquina.exibirEstado();
		System.out.println("---------------");
		maquina.comprar(11, 4.5*11);
		maquina.exibirEstado();
		
		
	}

}
