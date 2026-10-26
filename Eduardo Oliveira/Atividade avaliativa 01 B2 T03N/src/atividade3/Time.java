package atividade3;


public class Time {
	private String nome;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;
	
	
	public Time(String nome) {
		super();
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
public void registrarVitoria() {
		vitorias++;
		pontos += 3;
	}
public void registrarEmpate() {
		empates++;
		pontos += 1;
	}
public void registrarDerrota() {
		derrotas++;
	}
	public void exibirEstatisticas() {
		System.out.println("Nome do time: " + nome);
		System.out.println(vitorias + " Vitórias, " + derrotas + " Derrotas, " + empates + " Empates. Total de pontos = " + pontos);
	}
	
	
	
	
	
}
