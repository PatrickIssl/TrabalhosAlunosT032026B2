import java.util.Scanner;

class Cofrinho {
    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho (String dono, double metaEconomia){
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        this.saldo = 0.0;
    }

    public void depositar(double valor){
        if (valor <= 0){
            System.out.println("Erro: deposito deve ser positivo");
            return;
        }
        saldo += valor;
    }

    public void retirar(double valor){
        if (valor <= 0){
            System.out.println("Erro: valor invalido");
            return;
        }
        if (valor > saldo){
            System.out.println("Erro: saldo insuficiente");
            return;
        }
        saldo -= valor;
    }

    public void verificarMeta(){
        if (saldo >= metaEconomia){
            System.out.println("Meta de economia atingida!");
        } else {
            System.out.printf("Meta nao atingida. Faltam R$ %.2f\n", metaEconomia - saldo);
        }
    }

    public void exibirSaldo(){
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
        System.out.printf("Meta: R$ %.2f\n", metaEconomia);
    }
}

public class Atv04 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do dono:");
        String dono = sc.nextLine();

        System.out.println("Meta de economia:");
        double meta = Double.parseDouble(sc.nextLine());

        Cofrinho cofrinho = new Cofrinho(dono, meta);

        System.out.println("Primeiro deposito:");
        cofrinho.depositar(Double.parseDouble(sc.nextLine()));

        System.out.println("Segundo deposito:");
        cofrinho.depositar(Double.parseDouble(sc.nextLine()));

        cofrinho.exibirSaldo();

        System.out.println("Valor para retirar (tente acima do saldo):");
        cofrinho.retirar(Double.parseDouble(sc.nextLine()));

        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();

        sc.close();
    }
}
