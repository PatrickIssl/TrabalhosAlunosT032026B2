package vitorphablo.objetos;

public class Cofrinho {
    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho(String dono, double metaEconomia){
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        this.saldo = 0;
    }

    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("Valor depositado deve ser maior que 0");
            return;
        }

        saldo += valor;

    }

    public void retirar(double valor){
        if(valor <= 0){
            System.out.println("Valor retirado deve ser maior que 0");
            return;
        }
        if(saldo - valor < 0){
            System.out.println("Saldo insuficiente");
            return;
        }

        saldo -= valor;
    }

    public void verificarMeta(){
        if(saldo >= metaEconomia){
            System.out.println("Meta batida!!");
        } else{
            System.out.println("Faltam R$" + (metaEconomia - saldo) + " para atingir a meta");
        }
    }

    public void exibirSaldo(){
        System.out.println("Saldo atual: R$" + saldo);
    }
}

