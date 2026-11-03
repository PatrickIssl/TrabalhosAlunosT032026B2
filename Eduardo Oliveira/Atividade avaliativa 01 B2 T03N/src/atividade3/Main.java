package atividade3;



public class Main {
	public static void main(String[] args) {
		Time t = new Time("Corinthians");
		t.registrarVitoria();
		t.registrarVitoria();
		t.registrarDerrota();
		t.registrarEmpate();
		
		Time td = new Time("Inter");
		td.registrarVitoria();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarDerrota();
		td.registrarEmpate();
		
		Time maior = t;
		
		if(maior.getPontos() < td.getPontos()) {
			maior = td;
		} else if(maior.getPontos() == td.getPontos()) {
			System.out.println("Os dois times estão empatados.");
			return;
		}
		System.out.println("Dados do time vencedor: ");
		maior.exibirEstatisticas();
		
	}

}
