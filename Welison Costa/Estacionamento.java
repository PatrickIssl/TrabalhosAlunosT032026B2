package trabalhoSegundoSemestre;

import java.util.Scanner;

public class Estacionamento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos estacionamento = new Metodos();

        System.out.print("Placa do carro: ");
        String placa = sc.nextLine();

        System.out.print("Modelo do carro: ");
        String modelo = sc.nextLine();

        System.out.print("Tempo estacionado em minutos: ");
        int tempo = sc.nextInt();

        System.out.println();
        estacionamento.adicionarTempo(tempo);

        System.out.println("Ticket do Veiculo ");
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        estacionamento.exibirResumo();

        sc.close();
    }
}