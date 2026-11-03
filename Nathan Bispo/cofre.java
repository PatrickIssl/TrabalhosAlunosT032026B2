class Cofrinho {
    String dono;
    double saldo;
    double metaEconomia;

    Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        saldo = 0;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Deposito de R$ %.2f realizado.%n", valor);
        } else {
            System.out.println("O valor do deposito deve ser positivo.");
        }
    }

    void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor da retirada deve ser positivo.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para retirada.");
        } else {
            saldo -= valor;
            System.out.printf("Retirada de R$ %.2f realizada.%n", valor);
        }
    }

    void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta de economia atingida!");
        } else {
            System.out.printf("Faltam R$ %.2f para atingir a meta.%n",
                    metaEconomia - saldo);
        }
    }

    void exibirSaldo() {
        System.out.println("\nDono: " + dono);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.printf("Meta: R$ %.2f%n", metaEconomia);
    }
}

public class Main {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho("Nathan", 500.00);

        cofrinho.depositar(200.00);
        cofrinho.depositar(150.00);

        cofrinho.retirar(400.00);

        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();
    }
}