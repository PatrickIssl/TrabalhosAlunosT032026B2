package vitorphablo;

import vitorphablo.objetos.*;

public class Principal {
    public static void main(String[] args) {
        //atvUm();
        //atvDois();
        //atvTres();
        //atvQuatro();
        atvCinco();
    }

    public static void atvUm() {
        Estacionamento est = new Estacionamento("ABC123", "Porsche");

        est.adicionarTempo(27);
        est.calcularValor();
        est.exibirResumo();

        est.adicionarTempo(35);
        est.calcularValor();
        est.exibirResumo();

        est.adicionarTempo(225);
        est.calcularValor();
        est.exibirResumo();
    }

    public static void atvDois() {
        MaquinaRefrigerantes mr = new MaquinaRefrigerantes(10);
        mr.comprar(-10, 2);

        mr.comprar(2, 8);

        mr.comprar(2, 9);

        mr.comprar(2,10);

        mr.comprar(7,22.5);

        mr.exibirEstado();
    }

    public static void atvTres() {
        Time tm = new Time("Corinthians");

        tm.registrarVitoria();
        tm.registrarDerrota();
        tm.registrarDerrota();
        tm.registrarDerrota();
        tm.registrarDerrota();
        tm.registrarDerrota();
        tm.registrarEmpate();

        tm.exibirEstatisticas();
    }

    public static void atvQuatro(){
        Cofrinho cf = new Cofrinho("Vorcaro", 2000);

        cf.depositar(-5);
        cf.depositar(500);
        cf.verificarMeta();
        cf.depositar(50000);
        cf.retirar(3000);
        cf.verificarMeta();
        cf.exibirSaldo();
    }

    public static void atvCinco() {
        Pedido ped = new Pedido("Xandão");

        ped.adicionarLanches(-2);

        ped.adicionarLanches(2);
        ped.exibirPedido();

        ped.adicionarLanches(3);
        ped.exibirPedido();

        ped.finalizarPedido();
        ped.adicionarLanches(10);
        ped.exibirPedido();
    }

}
