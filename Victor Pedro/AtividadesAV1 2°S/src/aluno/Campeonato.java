package aluno;

public class Campeonato {
	private String nome;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;




public Campeonato(String nome) {
	this.nome = nome;
	this.vitorias = 0;
	this.empates = 0;
	this.derrotas = 0;
	this.pontos = 0;
}

public void RegistrarVitoria() {
	vitorias++;
	pontos +=3;
}
public void RegistrarEmpate() {
	empates++;
	pontos +=1;
}
public void RegistrarDerrota() {
	derrotas++;
}

public void ExibirEstatisticas() {
	System.out.println("ESTATISTICAS "+ nome);
	 System.out.println("Vitórias: " + vitorias);
     System.out.println("Empates: " + empates);
     System.out.println("Derrotas: " + derrotas);
     System.out.println("Pontos: " + pontos);
}

public int getPontos() {
	return pontos;
}
public String getNome() {
	return nome;
}
}