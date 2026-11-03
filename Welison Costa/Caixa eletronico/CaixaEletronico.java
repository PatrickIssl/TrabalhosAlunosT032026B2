package caixaEletronico;

import java.util.Scanner;
import java.util.Locale;

public class CaixaEletronico {

    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        
        double saldo = 0.0;
        double limiteDiario = 500.0;
        int opcao = 0; 
        int senha = 5784;
        int tentativas = 0;
        
        while (tentativas < 3) {
            System.out.print("Digite sua senha: ");
            int senhaDigitada = sc.nextInt();
            
            if (senhaDigitada == senha) {
                System.out.println("Senha correta! Acesso permitido.");
                break;
            } else {
                tentativas++;
                System.out.println("Senha incorreta! Tentativa " + tentativas + " de 3.");
            }
        }
        
        if (tentativas == 3) {
            System.out.println("Número máximo de tentativas atingido. Acesso negado.");
            sc.close();
            return;
        }

        while (opcao != 4) {
            System.out.println("\n CAIXA ELETRÔNICO");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinheiro");
            System.out.println("3. Sacar dinheiro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            
            if (opcao == 1) {
                System.out.printf(Locale.of("pt", "BR"),"Seu saldo atual é: %.2f\n", saldo);
            } else if (opcao == 2) {
                System.out.print("Digite o valor a ser depositado: ");
                double valor = sc.nextDouble();
                
                if (valor <= 0) {
                    System.out.println("Valor inválido! Digite um valor maior que zero.");
                } else {
                    saldo += valor;
                    System.out.println("Depósito realizado com sucesso!");
                }
            } else if (opcao == 3) {
                if (limiteDiario <= 0) {
                    System.out.println("Saque bloqueado! Você já utilizou todo o seu limite diário de R$ 500,00.");
                } else {
                    System.out.println("Saldo atual: " + saldo);
                    System.out.println("Limite de saque diário disponível: " + limiteDiario);
                    System.out.print("Digite o valor a ser sacado: ");
                    double valor = sc.nextDouble();
                    
                    if (valor <= 0) {
                        System.out.println("Valor inválido! Digite um valor maior que zero.");
                    } else if (valor > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else if (valor > limiteDiario) {
                        System.out.println("Erro: o valor ultrapassa o seu limite diário restante de " + limiteDiario);
                    } else {
                        saldo -= valor;
                        limiteDiario -= valor;
                        System.out.println("Saque realizado com sucesso!");
                    }
                }
            } else if (opcao == 4) {
                System.out.println("Saindo do sistema...");
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        System.out.println("Obrigado por usar nosso banco!");
        sc.close(); 
    }
}