
package fag;

public class Cofrinho {
    String dono;
    double saldo, metaEconomia;

    public Cofrinho(String dono, double saldo, double metaEconomia) {
        this.dono = dono;
        this.saldo = saldo;
        this.metaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito feito");
        } else {
            System.out.println("Valor invalido");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada realizada");
        } else {
            System.out.println("Sem saldo");
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta atingida");
        } else {
            System.out.printf("falta R$ %.2f%n", metaEconomia - saldo);
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono " + dono);
        System.out.printf("Saldo R$ %.2f%n", saldo);
    }
}
