
package trabalhoDupla;

public class Cofrinho {

    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        saldo = 0;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public double getSaldo() {
        return saldo;
    }
    public double getMetaEconomia() {
        return metaEconomia;
    }
    public void setMetaEconomia(double metaEconomia) {
        if (metaEconomia > 0) {
            this.metaEconomia = metaEconomia;
        } else {
            System.out.println("A meta deve ser maior que zero.");
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("O deposito deve ser positivo");
            return;
        }
        saldo = saldo + valor;
        System.out.println("Deposito realizado");
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor da retirada deve ser positivo");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a retirada");
            return;
        }
        saldo = saldo - valor;
        System.out.println("Retirada realizada");
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta de economia atingida");
        } else {
            System.out.printf("Faltam R$%.2f para atingir a meta \n", (metaEconomia - saldo));
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo: R$%.2f \n", saldo);
        System.out.printf("Meta de economia: R$%.2f \n", metaEconomia);
    }
}
