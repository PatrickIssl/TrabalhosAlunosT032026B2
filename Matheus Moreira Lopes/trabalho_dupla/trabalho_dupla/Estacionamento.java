
package fag;

import java.util.Scanner;

public class Estacionamento {
    String placa;
    String modelo;
    int minutosEstacionado;
    double valorPago;

    public void AdicionarTempo(double tempo) {
        if (tempo > 0) {
            minutosEstacionado += tempo;
        } else {
            System.out.println("Tempo invalido!");
        }
    }

    public void CalcularValor() {
        if (minutosEstacionado == 0) {
            valorPago = 0;
        } else if (minutosEstacionado <= 30) {
            valorPago = 5.0;
        } else {
            valorPago = 5.0 + ((minutosEstacionado - 30) * 0.10);
        }

        if (valorPago > 30) {
            valorPago = 30;
        }

        System.out.printf(
            "\nTempo estacionado: %d minutos%n",
            minutosEstacionado
        );

        System.out.printf(
            "Valor a pagar: R$ %.2f%n",
            valorPago
        );
    }

  
}
