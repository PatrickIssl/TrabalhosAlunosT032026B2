import java.util.Scanner;

public class Program {
	
	public static void main (String [] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		Estacionamento estacionamento = new Estacionamento();
		
		estacionamento.setPlaca("BRA2E19");
		estacionamento.setModelo("Gol");
		estacionamento.adicionarTempo(1500);
		estacionamento.calcularValor();
		estacionamento.exibirResumo();
		
		
		
	}

}
