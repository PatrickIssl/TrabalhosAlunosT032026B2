import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a placa do veículo (XXX-XXXX):"); 
		String placa = sc.nextLine();
		
		System.out.println("Digite o modelo do veículo: ");
		String modelo = sc.nextLine();
		
		// Cria o objeto
		Estacionamento veiculo = new Estacionamento(placa, modelo);
		
		// Adiciona o tempo
		System.out.println("Digite o tempo a adicionar em minutos: ");
		int minutos = sc.nextInt();
		veiculo.adicionarTempo(minutos);
		
		veiculo.exibirResumo();
		
		sc.close();
	}
}
