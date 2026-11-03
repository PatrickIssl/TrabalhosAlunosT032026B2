package atividade04;

public class Cofrinho {
    private String dono;
    private double saldo;
    private double metaEconomia;
    
    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.saldo = 0.0;
        this.metaEconomia = metaEconomia;
    }
    
    public void depositar(double valor) {
    	if (valor <= 0) {
    		System.out.println("Depósito inválido: o valor deve ser positivo.");
    		return;
    	}
    	saldo += valor;
    		System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);

    }
    
    public void retirar(double valor) {
    	if(valor <= 0) {
    		System.out.println("Retirada inválida, o valor deve ser positivo.");
    		return;
    	}
    	if (valor > saldo) {
    		System.out.printf("Retirada de R$ %.2f negada: saldo insuficiente (saldo atual: R$ %.2f).%n",
    				valor, saldo);
    		return;
    	}
    	
    	saldo -= valor; 
        System.out.printf("Retirada de R$ %.2f realizada com sucesso.%n", valor);
    }
    
    public void verificarMeta() {
    	if (saldo >= metaEconomia) {
    			System.out.printf("Parabéns, %s! A meta de R$ %.2f foi atingida!%n", dono, metaEconomia);
    	} else {
            double falta = metaEconomia - saldo;
            System.out.printf("A meta de R$ %.2f ainda não foi atingida. Faltam R$ %.2f.%n",
                    metaEconomia, falta);
        }
    }
    public void exibirSaldo() {
        System.out.printf("Saldo do cofrinho de %s: R$ %.2f%n", dono, saldo);
    }

}
