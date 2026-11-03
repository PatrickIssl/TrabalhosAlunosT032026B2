import java.util.Scanner;

public class Estacionamento {
	private String placa;
    private String modelo;
    private int minutosEstacionado;
    private double valorPago;

public Estacionamento(String placa, String modelo) {
	this.placa=placa;
	this.modelo=modelo;
	this.minutosEstacionado=0;
	this.valorPago=0.0;
}


public String getPlaca() {//get set do sistema
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


public int getMinutosEstacionado() {
	return minutosEstacionado;
}


public void setMinutosEstacionado(int minutosEstacionado) {
	this.minutosEstacionado = minutosEstacionado;
}


public double getValorPago() {
	return valorPago;
}


public void setValorPago(double valorPago) {
	this.valorPago = valorPago;
}


public void adicionarTempo(int minutos) {//Adicionar tempo estacionado
	if (minutos>0) {
	this.minutosEstacionado += minutos; 	
	}
	else {
    System.out.println("Periodo de Tempo Informado Invalido!.");
	}
}
public double calcularValor() {//Calculo do tempo estacionado
	if (minutosEstacionado <= 0) {
        this.valorPago = 0.0;
    } else if (minutosEstacionado <= 30) {
        this.valorPago = 5.00;
    } else {
        int minutosMais = minutosEstacionado - 30;
        this.valorPago = 5.00 + (minutosMais * 0.10);
    }
	
	if (this.valorPago > 30.00) {  //Valor Maximo cobrado
        this.valorPago = 30.00;
    }

    return this.valorPago;
}

public void exibirResumo() {
	System.out.println("Placa: " + this.placa);
    System.out.println("Modelo: " + this.modelo);
    System.out.println("Tempo Estacionado: " + this.minutosEstacionado + " minutos");
    System.out.printf("Valor a Pagar: R$ %.2f\n", calcularValor());
	}
	
}
