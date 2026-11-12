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
            System.out.println("Erro: o depósito deve ser um valor positivo.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado.%n", valor);
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor da retirada deve ser positivo.");
            return;
        }
        if (valor > saldo) {
            System.out.printf("Saldo insuficiente. Saldo atual: R$ %.2f%n", saldo);
            return;
        }
        saldo -= valor;
        System.out.printf("Retirada de R$ %.2f realizada.%n", valor);
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Parabéns! A meta de economia foi atingida!");
        } else {
            System.out.printf("Meta ainda não atingida. Faltam R$ %.2f.%n", metaEconomia - saldo);
        }
    }

    public void exibirSaldo() {
        System.out.printf("Dono: %s | Saldo: R$ %.2f | Meta: R$ %.2f%n", dono, saldo, metaEconomia);
    }

    public static void main(String[] args) {
        Cofrinho cofre = new Cofrinho("Maria", 200.00);
        cofre.depositar(50.00);
        cofre.depositar(80.00);
        cofre.retirar(500.00); // acima do saldo
        cofre.exibirSaldo();
        cofre.verificarMeta();
    }
}
