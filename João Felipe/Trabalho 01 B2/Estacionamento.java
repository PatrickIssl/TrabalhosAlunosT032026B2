package trabalhoDupla;

public class Estacionamento {
	private String placa;
	private String modelo;
	private int minutosEstacionados;
	private double valor;
	
	
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
		if(minutosEstacionados < 0) {
			System.out.println("Os minutos não podem ser negativos");
			return;
		}
		this.minutosEstacionados = minutosEstacionados;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		if(valor < 0) {
			System.out.println("O valor tem que ser maior que zero!");
			return;
		}
		this.valor = valor;
	}
	public void adicionarTempo(int minutos) {
		setMinutosEstacionados(minutos + minutosEstacionados);
	}
	
	
	public double calcularValor() {
		if (minutosEstacionados <=30) {
			return valor = 5.00;
			}else{
				valor = 5.00 + (minutosEstacionados - 30) * 0.1;
			}	
		if (valor > 30.00 ) {
			valor = 30.00;
		}
		return valor;
	}
	
	public void exibirResumo() {
		if(minutosEstacionados > 0) {
		System.out.println("Placa: "+ placa);
		System.out.println("Modelo: "+ modelo);
		System.out.println("Minutos Estacionados: "+ minutosEstacionados);
		System.out.println("Valor: "+ valor);
		}
	}
}
