package atividade1;


public class Estacionamento {

	private String placa;
	private String modelo;
	private int minutosEstacionados;
	private double valorPago;
	
	public Estacionamento(String placa, String modelo, int minutosEstacionados) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		if (minutosEstacionados < 0) {
			System.out.println("Tempo não pode ser negativo.");
			this.minutosEstacionados = 0;
		} else {
			this.minutosEstacionados = minutosEstacionados;
		}
	}

	public void adicionarTempo(int minutos) {
		if (minutos < 0) {
			System.out.println("Tempo não pode ser negativo.");
			return;
		}
		minutosEstacionados += minutos;
	}
	
	public void calcularValor(){
		double valor = 5.0;
		
	if (minutosEstacionados > 30) {
		int minutosExcedidos = minutosEstacionados - 30;
			valor += 0.1 * minutosExcedidos;
		}
		
	if (valor > 30) {
		valor = 30;
		}
		
		valorPago = valor;
		

	}
	public void exibirResumo() {
		System.out.println("Placa do veículo: " + placa);
		System.out.println("Modelo do veículo: " + modelo);
		System.out.println("Minutos estacionados: " + minutosEstacionados);
		System.out.println("Valor total a ser pago: " + valorPago);
	}
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
public int getMinutosEstacionados() {
		return minutosEstacionados;
	}
public void setMinutosEstacionados(int minutosEstacionados) {
		if (minutosEstacionados < 0) {
			System.out.println("Tempo não pode ser negativo.");
			return;
		}
		this.minutosEstacionados = minutosEstacionados;
	}
	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
}
