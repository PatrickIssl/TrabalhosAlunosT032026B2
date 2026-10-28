package avaliacao;

public class Estacionamento {
	private String placa;
	private String modelo;
	private int minutosEstacionados;
	private double valorPago;
	
	public Estacionamento(String placa, String modelo) {
	    this.placa = placa;
	    this.modelo = modelo;
	    this.minutosEstacionados = 0;
	    this.valorPago = 0;
	}	
	
	//get
	public String getPlaca(){
		return placa;
	}
	public String getModelo(){
		return modelo;
	}
	public int getMinutosEstacionados(){
		return minutosEstacionados;
	}
	public double getValorPago(){
		return valorPago;
	}	
	//set
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	//metodos
	public void adicionarTempo(int minutos) {
		if(minutos >= 0) {
			minutosEstacionados += minutos;
		}
		else {
			System.out.println("Não é permitido valor negativo!");
		}		
	}
	public double calcularValor() {
		if(minutosEstacionados <= 30) {
			valorPago = 5.00;
		}
		else {
			valorPago = ((minutosEstacionados - 30) * 0.10) + 5.00;
		}
		if(valorPago > 30) {
			valorPago = 30.00;
		}
		return valorPago;
	
	}
	public void exibirResumo() {
		System.out.println("Placa: " + placa);
		System.out.println("Modelo: " + modelo);
		System.out.println("Minutos: " + minutosEstacionados);
		System.out.println("Valor total: R$" + valorPago);
	}

}
