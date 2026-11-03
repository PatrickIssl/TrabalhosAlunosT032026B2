package atividade1;




public class Main {

	public static void main(String[] args) {
		Estacionamento e = new Estacionamento("BCB2J20", "Wolkswagen Gol", 30);
		e.calcularValor();
		e.exibirResumo();
		System.out.println("------------");
		e.adicionarTempo(10);
		e.calcularValor();
		e.exibirResumo();
		System.out.println("------------");
		e.adicionarTempo(400);
		e.calcularValor();
		e.exibirResumo();
	}

}
