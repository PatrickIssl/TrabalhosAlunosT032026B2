package trabalhoSegundoSemestre;

public class Metodos {

    public int tempoEstacionado = 0;
    private float valorPago = 0;

    public int quantidadeEstoque = 0;
    public float preco = 4.50f;
    public float dinheiroArrecadado = 0.0f;

    private int vitorias = 0;
    private int empates = 0;
    private int derrotas = 0;
    
    public String dono = "";
    public float saldo = 0.0f;
    public float metaEconomia = 0.0f;
    
    public String nomeCliente = "";
    public int quantidadeLanches = 0;
    public float precoLanche = 18.00f;
    public float taxaEntrega = 7.00f;
    public boolean pedidoFinalizado = false;
    
    public void adicionarTempo(int minutos) {
        if (minutos < 0) {
            System.out.println("Tempo invalido");
            return;
        }
        
        tempoEstacionado += minutos;
        System.out.println("Adicionado " + minutos + " min. Total agora: " + tempoEstacionado + " min.");
    }

    public void calcularValor() {
        if (tempoEstacionado > 0 && tempoEstacionado <= 30) {
            valorPago = 5.00f;
        } else if (tempoEstacionado > 30) {
            valorPago = 5.00f + (tempoEstacionado - 30) * 0.10f;
        } else {
            valorPago = 0;
        }

        if (valorPago > 30.00f) {
            valorPago = 30.00f;
        }

        System.out.printf("Valor a pagar: R$ %.2f\n", valorPago);
    }

    public void exibirResumo() {
        calcularValor();
        System.out.println("Tempo parado: " + tempoEstacionado + " min");
        System.out.printf("Total: R$ %.2f\n", valorPago);
    }

    public void comprar(int quantidade, float valorInserido) {
        if (quantidade <= 0) {
            System.out.println("Quantidade invalida");
            return;
        }

        if (quantidade > quantidadeEstoque) {
            System.out.println("Faltou refri no estoque. Tem so " + quantidadeEstoque);
            return;
        }

        float valorTotal = quantidade * preco;

        if (valorInserido < valorTotal) {
            System.out.printf("Faltou grana. Deu R$ %.2f e vc colocou R$ %.2f\n", valorTotal, valorInserido);
            return;
        }

        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += valorTotal;
        float troco = valorInserido - valorTotal;

        System.out.printf("Deu certo. Total: R$ %.2f\n", valorTotal);
        if (troco > 0) {
            System.out.printf("Pega o troco: R$ %.2f\n", troco);
        }
    }

    public void reporEstoque(int qtd) {
        if (qtd <= 0) return;

        quantidadeEstoque += qtd;
        System.out.println("Estoque reposto. Agora tem: " + quantidadeEstoque);
    }

    public void exibirEstado() {
        System.out.println("\n-- Maquina --");
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.printf("Caixa: R$ %.2f\n\n", dinheiroArrecadado);
    }
    
    public void registrarVitoria() {
        vitorias++;
    }

    public void registrarEmpate() {
        empates++;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void exibirEstatisticas() {
        int pontos = (vitorias * 3) + empates;

        System.out.println("\n-- Estatisticas --");
        System.out.println("Vitorias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
        
        return;
    }
    
    public void depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado.\n", valor);
        } else {
            System.out.println("Erro: O depósito deve ser um valor positivo.");
        }
    }
    
    public void retirar(float valor) {
        if (valor > saldo) {
            System.out.printf("Erro: Saldo insuficiente. Tens apenas R$ %.2f.\n", saldo);
        } else if (valor > 0) {
            saldo -= valor;
            System.out.printf("Retirada de R$ %.2f realizada.\n", valor);
        }
    }
    
    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.printf("Parabéns! Atingiste a meta de R$ %.2f.\n", metaEconomia);
        } else {
            float falta = metaEconomia - saldo;
            System.out.printf("Ainda faltam R$ %.2f para atingires a meta.\n", falta);
        }
    }
    
    public void exibirSaldo() {
        System.out.printf("Saldo atual do cofrinho: R$ %.2f\n", saldo);
    }
    
    public void adicionarLanches(int quantidade) {
        if (pedidoFinalizado) {
            System.out.println("Operação não permitida: O pedido já está finalizado.");
            return;
        }
        if (quantidade > 0) {
            quantidadeLanches += quantidade;
            System.out.println(quantidade + " lanche(s) adicionado(s). Total: " + quantidadeLanches);
        }
    }

    public float calcularTotal() {
        float totalLanches = quantidadeLanches * precoLanche;
        
        // Aplica 10% de desconto se houver 3 ou mais lanches
        if (quantidadeLanches >= 3) {
            totalLanches -= (totalLanches * 0.10f);
        }
        
        return totalLanches + taxaEntrega;
    }

    public void finalizarPedido() {
        pedidoFinalizado = true;
        System.out.println("Pedido finalizado com sucesso.");
    }

    public void exibirPedido() {
        System.out.println("\n-- Resumo do Pedido --");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.println("Status: " + (pedidoFinalizado ? "Finalizado" : "Em andamento"));
        System.out.printf("Total a pagar (com entrega): R$ %.2f\n", calcularTotal());
    }
}