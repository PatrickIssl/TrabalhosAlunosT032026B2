public class Cofrinho {

    private String dono;
    private double saldo, metaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Erro: o depósito deve ser positivo.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Erro: saldo insuficiente para retirar R$ " + valor);
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta atingida!");
        } else {
            System.out.println("Faltam R$ " + (metaEconomia - saldo) + " para atingir a meta.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono: " + dono + " | Saldo: R$ " + saldo);
    }

    public static void main(String[] args) {
        Cofrinho c = new Cofrinho("Maria", 200);

        c.depositar(80);
        c.depositar(50);
        c.retirar(500);
        c.exibirSaldo();
        c.verificarMeta();
    }
}