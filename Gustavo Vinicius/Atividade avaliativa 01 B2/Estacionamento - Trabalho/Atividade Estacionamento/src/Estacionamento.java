public class Estacionamento {

	private String placa;
	private String modelo;
	private double minutosEstacionado;
	private double valorPago;
	
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getMinutosEstacionado() {
		return minutosEstacionado;
	}

	

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	
	public void adicionarTempo(double minutos) {
		
		if(minutos <=0) {
			System.out.println("ERRO!");
		}
		else {
			minutosEstacionado += minutos;
			calcularValor();
		}
		
	}
	
	public void calcularValor() {
		
		valorPago = 5.00;
		
		double sobra = minutosEstacionado - 30;
		
		if(sobra > 0) {
			valorPago += sobra * 0.10;
		}
		
		if(valorPago > 30){
			valorPago = 30.00;
		}
		
	}
	
	public void exibirResumo() {
		System.out.println("Placa do carro: " + placa);
		System.out.println("Modelo do carro: " + modelo);
		System.out.println("Minutos estacionados: " + minutosEstacionado);
		System.out.println("Valor pago: R$" + valorPago);
		
	}
	
}
