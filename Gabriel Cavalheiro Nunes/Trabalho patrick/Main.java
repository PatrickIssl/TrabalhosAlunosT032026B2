package trabalhoDupla;

public class Main {
	public static void main(String[] args) {
		/*
		Estacionamento estacionamento = new Estacionamento();
		estacionamento.setPlaca("XHI5823");
		estacionamento.setModelo("Chevette");
		estacionamento.adicionarTempo(-100);
		estacionamento.calcularValor();
		estacionamento.exibirResumo();
		
		MaquinaRefrigerante maquinaRefrigerante = new MaquinaRefrigerante();
		maquinaRefrigerante.setQuantidadeEstoque(3);
		maquinaRefrigerante.comprar(2, 13.00);
		maquinaRefrigerante.comprar(2, 15.00);
		maquinaRefrigerante.exibirEstado();
	
        Time time1 = new Time("Time Azul");
        Time time2 = new Time("Time Vermelho");
        time1.registrarVitoria();
        time1.registrarVitoria();
        time1.registrarEmpate();
        time1.registrarEmpate();

        time2.registrarVitoria();
        time2.registrarEmpate();
        time2.registrarEmpate();
        time2.registrarDerrota();

        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        if (time1.getPontos() > time2.getPontos()) {
            System.out.println("O time " + time1.getNome()
                    + " possui mais pontos.");
        } else if (time2.getPontos() > time1.getPontos()) {
            System.out.println("O time " + time2.getNome()
                    + " possui mais pontos.");
        } else {
            System.out.println("Empate na classificação.");
        }
		
		Cofrinho cofrinho = new Cofrinho("João", 500.00);

        cofrinho.depositar(200.00);
        cofrinho.depositar(100.00);

        cofrinho.retirar(400.00);

        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();]
        */
		
		 Pedido pedido = new Pedido("João");
	        pedido.adicionarLanches(2);
	        pedido.adicionarLanches(1);
	        pedido.exibirPedido();
	        pedido.finalizarPedido();
	        pedido.adicionarLanches(1);
	        pedido.exibirPedido();
	}
}