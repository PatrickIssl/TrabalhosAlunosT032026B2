package aluno;

public class Cofrinho {

    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho(String dono,double metaEconomia) {

        this.saldo = 0;
        this.dono = dono;
        this.metaEconomia = metaEconomia;

    }

    public void depositar(double valor) {

        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor invalido");
        }

    }

    public void retirar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;

        } else {
            System.out.println("saldo insuficiente");
        }


    }

    public void verificarMeta(){

        if (this.saldo >= this.metaEconomia) {

            System.out.println("Meta atingida!!!!");
        }
        else  {
            double falta = this.metaEconomia -= this.saldo;
            System.out.println("quanto falta: R$ "+this.metaEconomia);
        }
    }

    public void exibirSaldo() {

        System.out.println("Saldo: " + this.saldo);
    }



}