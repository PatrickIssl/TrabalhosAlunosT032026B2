package avaliacao;

public class Cofrinho {

	private String dono;
    private double saldo;
    private double metaEconomia;
       
    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        this.saldo = 0;
    }
    
    //get
    public String getDono() {
    	return dono;
    }
    public double getSaldo() {
    	return saldo;
    }
    public double getMetaEdonomia() {
    	return metaEconomia;
    }
    
    //set
    public void setDono(String dono) {
    	this.dono = dono;
    }
    public void setMetaEconomia(double metaEconomia) {
    	this.metaEconomia = metaEconomia;
    }
    
    //metodos
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado");
        } 
        else {
            System.out.println("Depósito inválido! O valor deve ser positivo");
        }
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("Retirada inválida! O valor deve ser positivo");
        } 
        else if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada de R$ " + valor + " realizada");
        } 
        else {
            System.out.println("Saldo insuficiente! Você tem R$ " + saldo);
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Parabéns! A meta foi atingida!");
        } else {
            double falta = metaEconomia - saldo;
            System.out.println("A meta ainda não foi atingida. Faltam R$ " + falta );
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.println("Saldo atual: R$ " + saldo);
        System.out.println("Meta de economia: R$ " + metaEconomia);
        System.out.println();
    }

}
