// NOMES: VICTOR PEDRO, PEDRO NARANJO



package aluno;

public class Main {

    public static void main(String[] args) {

        // ===============================
        // Atividade 1 – Estacionamento
        // ===============================
        System.out.println("========== ATIVIDADE 1 – ESTACIONAMENTO ==========");

        Estacionamento veiculo = new Estacionamento("ABC-1234", "COROLLA");
        veiculo.adicionarTempo(20);
        veiculo.calcularValor();
        veiculo.exibirResumo();

        Estacionamento veiculo1 = new Estacionamento("DEF-456", "Honda Civic");
        veiculo1.adicionarTempo(10);
        veiculo1.calcularValor();
        veiculo1.exibirResumo();

        Estacionamento veiculo2 = new Estacionamento("WER-789", "Peugeot 205");
        veiculo2.adicionarTempo(-10);
        veiculo2.calcularValor();
        veiculo2.exibirResumo();


        // ==============================
        // Atividade 2 - Maquina de refrigerante
        // ==============================

        System.out.println("\n========== ATIVIDADE 2 - Maquina de refrigerante ==========");


        MaquinaDeRefrigerante minhaMaquina = new MaquinaDeRefrigerante();

        minhaMaquina.reporEstoque(10);
        minhaMaquina.exibirEstado();

        minhaMaquina.comprar(2, 10);
        minhaMaquina.exibirEstado();

        MaquinaDeRefrigerante minhaMaquina2 = new MaquinaDeRefrigerante();
        minhaMaquina2.reporEstoque(10);
        minhaMaquina2.exibirEstado();

        minhaMaquina2.comprar(1, 2);
        minhaMaquina2.exibirEstado();


        // ===============================
        // Atividade 3 – Campeonato
        // ===============================
        System.out.println("\n========== ATIVIDADE 3 – CAMPEONATO ==========");

        Campeonato time1 = new Campeonato("Flamengo");
        Campeonato time2 = new Campeonato("Palmeiras");

        time1.RegistrarVitoria();
        time1.RegistrarVitoria();
        time1.RegistrarDerrota();
        time1.RegistrarDerrota();

        time2.RegistrarVitoria();
        time2.RegistrarEmpate();
        time2.RegistrarDerrota();
        time2.RegistrarDerrota();

        time1.ExibirEstatisticas();
        time2.ExibirEstatisticas();

        System.out.println("CLASSIFICAÇÃO");

        if (time1.getPontos() > time2.getPontos()) {
            System.out.println(time1.getNome() + " esta na frente");
        } else if (time1.getPontos() < time2.getPontos()) {
            System.out.println(time2.getNome() + " esta na frente");
        } else {
            System.out.println("o jogo esta em empate");
        }


        // ===============================
        // Atividade 4 - Cofrinho
        // ===============================

        System.out.println("\n========== ATIVIDADE 4 – COFRINHO ==========");

        Cofrinho meuCofrinho = new Cofrinho("Victor", 556.00);

        System.out.println("Cofrinho criado com sucesso");
        meuCofrinho.exibirSaldo();

        System.out.println("Deposito");
        meuCofrinho.depositar(200.00);
        meuCofrinho.depositar(356.00);


        meuCofrinho.exibirSaldo();

        System.out.println("Tentando sacar mais que o saldo");
        meuCofrinho.retirar(557);


        System.out.println("Verificando meta");
        meuCofrinho.verificarMeta();


        // ===============================
        // Atividade 5 - Pedido
        // ===============================


        System.out.println("\n========== ATIVIDADE 5 – Pedido ==========");

        Pedido meuPedido = new Pedido("Victor");
        meuPedido.adicionarLanche(2);
        meuPedido.adicionarLanche(1);

        System.out.println("Resumo conta");
        meuPedido.exibirPedido();

        System.out.println("Finalizando");
        meuPedido.finalizarPedido();
        System.out.println("Pedido finalizado com sucesso!");


    }
}