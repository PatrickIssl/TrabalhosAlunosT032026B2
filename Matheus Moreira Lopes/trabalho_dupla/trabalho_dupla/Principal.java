
package fag;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        atividadeUm();
        atividadeDois();
        atividadeTres();
        atividadeQuatro();
        atividadeCinco();
    }

    public static void atividadeUm() {
        Scanner scanner = new Scanner(System.in);
        Estacionamento e = new Estacionamento();

        System.out.println("\nExercicio 1");

        System.out.print("Digite a placa do veiculo: ");
        e.placa = scanner.nextLine();

        System.out.print("Digite o modelo do veiculo: ");
        e.modelo = scanner.nextLine();

        System.out.print("Digite o tempo estacionado em minutos: ");
        int tempo = scanner.nextInt();

        e.AdicionarTempo(tempo);
        e.CalcularValor();
    }

    public static void atividadeDois() {
        Scanner scan = new Scanner(System.in);
        MaquinaRefrigerante mr = new MaquinaRefrigerante();

        System.out.println("\nAtividade 2");

        System.out.println("Quantidade para repor no estoque:");
        int quantidadeRepor = scan.nextInt();

        mr.reporEstoque(quantidadeRepor);

        for (int i = 0; i < 3; i++) {
            System.out.println("\nInsira a quantidade:");
            int quantidade = scan.nextInt();

            System.out.println("Insira o valor pago:");
            double valorPago = scan.nextDouble();

            mr.Comprar(quantidade, valorPago);
        }

        mr.exibirEstado();
    }

    public static void atividadeTres() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nAtividade 3");

        System.out.print("Digite o nome do primeiro time: ");
        Time t1 = new Time(scan.nextLine());

        System.out.print("Digite o nome do segundo time: ");
        Time t2 = new Time(scan.nextLine());

        System.out.print("Vitorias do primeiro time: ");
        int v1 = scan.nextInt();

        System.out.print("Empates do primeiro time: ");
        int e1 = scan.nextInt();

        System.out.print("Derrotas do primeiro time: ");
        int d1 = scan.nextInt();

        System.out.print("Vitorias do segundo time: ");
        int v2 = scan.nextInt();

        System.out.print("Empates do segundo time: ");
        int e2 = scan.nextInt();

        System.out.print("Derrotas do segundo time: ");
        int d2 = scan.nextInt();

        for (int i = 0; i < v1; i++) {
            t1.registrarVitoria();
        }

        for (int i = 0; i < e1; i++) {
            t1.registrarEmpate();
        }

        for (int i = 0; i < d1; i++) {
            t1.registrarDerrota();
        }

        for (int i = 0; i < v2; i++) {
            t2.registrarVitoria();
        }

        for (int i = 0; i < e2; i++) {
            t2.registrarEmpate();
        }

        for (int i = 0; i < d2; i++) {
            t2.registrarDerrota();
        }

        t1.exibirEstatisticas();
        t2.exibirEstatisticas();

        if (t1.pontos > t2.pontos) {
            System.out.println(t1.nome + " tem mais pontos!");
        } else if (t2.pontos > t1.pontos) {
            System.out.println(t2.nome + " tem mais pontos!");
        } else {
            System.out.println("Empate ");
        }
    }

    public static void atividadeQuatro() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nAtividade 4");

        System.out.print("Digite o nome do dono: ");
        String dono = scan.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldo = scan.nextDouble();

        System.out.print("Digite a meta de economia: ");
        double meta = scan.nextDouble();

        Cofrinho c = new Cofrinho(dono, saldo, meta);

        System.out.print("Valor para depositar: ");
        c.depositar(scan.nextDouble());

        System.out.print("Valor para retirar: ");
        c.retirar(scan.nextDouble());

        c.exibirSaldo();
        c.verificarMeta();
    }

    public static void atividadeCinco() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nAtividade 5");

        System.out.print("Digite o nome do cliente: ");
        Pedido p = new Pedido(scan.nextLine());

        System.out.print("Quantidade de lanches: ");
        p.adicionarLanches(scan.nextInt());

        p.exibirPedido();

        p.finalizarPedido();
        p.exibirPedido();
    }
}
