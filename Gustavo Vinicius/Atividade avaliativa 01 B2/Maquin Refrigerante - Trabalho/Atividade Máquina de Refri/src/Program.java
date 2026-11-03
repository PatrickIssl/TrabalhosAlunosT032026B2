
public class Program {

	public static void main(String[] args) {
		
		MaquinaRefrigerante maquinaUm = new MaquinaRefrigerante();
		
		maquinaUm.reporEstoque(5);
		
		maquinaUm.comprar(3,13.50);
		maquinaUm.exibirEstado();
		
		System.out.println();
		
		maquinaUm.comprar(2, 8.00);
		maquinaUm.exibirEstado();
		
		
	}

}
