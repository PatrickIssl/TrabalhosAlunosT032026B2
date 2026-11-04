public class Program {

	public static void main(String[] args) {
		
		Time timeUm = new Time("Santos");
		Time timeDois = new Time("Corinthias");
		
		timeUm.registrarVitoria(3);
		timeDois.registrarVitoria(5);
		
		timeUm.registraEmpate(4);
		timeDois.registraEmpate(1);
		
		timeUm.registrarDerrota(2);
		timeDois.registrarDerrota(3);
		
		timeUm.exibirEstatisticas();
		timeDois.exibirEstatisticas();
		
		timeUm.registrarVitoria(2);
		timeDois.registrarVitoria(1);
		
		timeUm.registraEmpate(2);
		timeDois.registraEmpate(2);
		
		timeUm.registrarDerrota(0);
		timeDois.registrarDerrota(1);
		
		timeUm.exibirEstatisticas();
		timeDois.exibirEstatisticas();
		
		if(timeUm.getPontos() > timeDois.getPontos()) {
			System.out.println(timeUm.getNome() + " tem mais pontuação");
		}else if (timeDois.getPontos() > timeUm.getPontos() ) {
			System.out.println(timeDois.getNome() + " tem mais pontuação");
		}
		else {
			System.out.println(timeUm.getNome() + " e " + timeDois.getNome() + " tem a mesma pontuação ");
		}

	}

}
