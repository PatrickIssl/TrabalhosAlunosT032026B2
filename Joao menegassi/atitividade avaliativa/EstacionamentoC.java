package estacionamento;

public class EstacionamentoC {

	private String placa;
	private String modelo;
	private int minutoE;
	private double valorP;

	public EstacionamentoC(String p, String m) {
		placa = p;
		modelo = m;
		minutoE = 0;
		valorP = 0;
	}

	public void adicionarTempo(int minutos) {
		if (minutos < 0) {
			System.out.println("Erro: o tempo não pode ser negativo");
		} else {
			minutoE += minutos;
		}
	}

	public double calcularValor() {
		double valor = 5.00;

		if (minutoE > 30) {
			valor += (minutoE - 30) * 0.10;
		}

		if (valor > 30.00) {
			valor = 30.00;
		}

		valorP = valor;
		return valor;
	}

	public void exibirResumo() {
		System.out.println("Placa: " + placa);
		System.out.println("Modelo: " + modelo);
		System.out.println("Minutos estacionados: " + minutoE);
		System.out.printf("Valor a pagar: R$ %.2f%n", valorP);
	}


}
