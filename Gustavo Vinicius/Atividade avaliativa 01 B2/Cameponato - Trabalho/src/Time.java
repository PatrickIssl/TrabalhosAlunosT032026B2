
public class Time {

	private String nome;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;
	
	
	public Time (String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVitorias() {
		return vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	
	public void registrarVitoria(int qntVitorias) {
		
		if (qntVitorias >= 0) {
			vitorias += qntVitorias;
			if(qntVitorias > 0) {
				pontos += qntVitorias * 3;
			}
		}
		else {
			System.out.println("Número de vitórias inválido");
		}
		
	}
	
	public void registraEmpate(int qntEmpate) {
		
		if(qntEmpate >= 0) {
			empates += qntEmpate;
			pontos += qntEmpate;
		}
		
	}
	
	public void registrarDerrota(int qntDerrota) {
		
		if (qntDerrota >= 0) {
			derrotas += qntDerrota;
		}
		else {
			System.out.println("Número de vitórias inválido");
		}
			
	}
	
	public void exibirEstatisticas() {
		
		System.out.println();
		System.out.println("Time: " + nome);
		System.out.println("Pontos: " + pontos);
		System.out.println("Vitórias: " + vitorias);
		System.out.println("Empates: " + empates);
		System.out.println("Derrotas: " + derrotas);
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
}
