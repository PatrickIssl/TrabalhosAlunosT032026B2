package estacionamento;

public class Principal {

	public static void main(String[] args) {
		atividade5();
	}

	public static void atividade1() {
		EstacionamentoC veiculo = new EstacionamentoC("ABC-1234", "Gol");

		veiculo.adicionarTempo(45);
		veiculo.adicionarTempo(10);

		double valor = veiculo.calcularValor();
		System.out.printf("Valor calculado: R$ %.2f%n", valor);

		veiculo.exibirResumo();
		veiculo.adicionarTempo(-10);
	}

	public static void atividade2() {
		MaquinaRefrigerante maquina = new MaquinaRefrigerante(10);
		maquina.reporEstoque(10);
		maquina.comprar(2, 10);
	}

	public static void atividade3() {
		Time time1 = new Time("Flamengo");
		Time time2 = new Time("Palmeiras");

		time1.registrarVitoria();
		time1.registrarVitoria();
		time1.registrarEmpate();
		time1.registrarDerrota();

		time2.registrarVitoria();
		time2.registrarEmpate();
		time2.registrarEmpate();
		time2.registrarDerrota();

		time1.exibirEstatisticas();
		System.out.println();
		time2.exibirEstatisticas();
		System.out.println();

		if (time1.getPontos() > time2.getPontos()) {
			System.out.println(time1.getNome() + " tem mais pontos.");
		} else if (time2.getPontos() > time1.getPontos()) {
			System.out.println(time2.getNome() + " tem mais pontos.");
		} else {
			System.out.println("Houve empate na classificação.");
		}
	}
	
	public static void atividade4() {
		Cofrinho cofrinho = new Cofrinho("Maria", 100.00);

		cofrinho.depositar(50.00);
		cofrinho.depositar(30.00);
		cofrinho.depositar(-10.00);

		cofrinho.retirar(200.00);

		cofrinho.exibirSaldo();
		cofrinho.verificarMeta();

		cofrinho.depositar(20.00);
		cofrinho.verificarMeta();
	}
	public static void atividade5() {
		Pedido pedido = new Pedido("Carlos");

		pedido.adicionarLanches(1);
		pedido.adicionarLanches(2);

		double total = pedido.calcularTotal();
		System.out.printf("Total do pedido: R$ %.2f%n", total);

		pedido.finalizarPedido();
		pedido.exibirPedido();

		boolean permitido = pedido.adicionarLanches(1);
		if (permitido) {
			System.out.println("A operação foi permitida.");
		} else {
			System.out.println("A operação NÃO foi permitida.");
		}
	}
}