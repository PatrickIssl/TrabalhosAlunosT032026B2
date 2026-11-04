import java.util.Scanner;

public class Program {

	public static void main (String[] args ) {
		
		
		Cofrinho cofrinho = new Cofrinho("Pedro",250.00,1000.00);
		
		cofrinho.depositar(50.00);
		cofrinho.depositar(25.00);
		cofrinho.depositar(25.00);
		
		cofrinho.exibirSaldo();
		
		cofrinho.retirar(500.00);
		
		cofrinho.verificarMeta();
		
	}
	
}
